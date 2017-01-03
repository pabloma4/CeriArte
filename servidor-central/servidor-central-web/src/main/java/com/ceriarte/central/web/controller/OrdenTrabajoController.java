package com.ceriarte.central.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ceriarte.central.converters.DetalleOrdenTrabajoReporteConverter;
import com.ceriarte.central.dominio.dto.ClienteDTO;
import com.ceriarte.central.dominio.dto.DetalleOrdenTrabajoDTO;
import com.ceriarte.central.dominio.dto.DetalleOrdenTrabajoReporteDTO;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;
import com.ceriarte.central.dominio.dto.DetallesOrdenTrabajo;
import com.ceriarte.central.dominio.dto.OrdenTrabajoDTO;
import com.ceriarte.central.dominio.dto.OrdenTrabajoEstadoDTO;
import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.dominio.dto.UsuarioDTO;
import com.ceriarte.central.enums.OrdenTrabajoEstadoEnum;
import com.ceriarte.central.excepciones.ServidorCentralBusinessException;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.servicios.ServicioOrdenesTrabajo;
import com.ceriarte.central.servicios.ServicioProductos;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;
import com.ceriarte.central.web.comparator.DetalleOrdenTrabajoReporteDTOComparator;

@ManagedBean(name = "ordenTrabajoController")
@ViewScoped
public class OrdenTrabajoController extends AbstractReportController implements Serializable {

	
	private static final long serialVersionUID = -3649684454994377086L;

	private final Logger logger = LoggerFactory.getLogger(OrdenTrabajoController.class);

	@ManagedProperty(value ="#{servicioOrdenesTrabajo}")
	private ServicioOrdenesTrabajo servicioOrdenesTrabajo;
	
	@ManagedProperty(value ="#{servicioClientes}")
	private ServicioGeneric<ClienteDTO> servicioClientes;
	
	@ManagedProperty(value ="#{servicioProductos}")
	private ServicioProductos servicioProductos;
	
	@ManagedProperty(value ="#{servicioDetallePedido}")
	private ServicioGeneric<DetallePedidoDTO> servicioDetallePedido;
	
	@ManagedProperty(value ="#{servicioOrdenTrabajoEstado}")
	private ServicioGeneric<OrdenTrabajoEstadoDTO> servicioOrdenTrabajoEstado;
		
	private OrdenTrabajoDTO editable;
	private DetalleOrdenTrabajoDTO detalleEditable;
	private List<ClienteDTO> clientes;
	private List<ProductoDTO> productos;
	private List<UsuarioDTO> usuarios;
    private Integer detallePedidoId;
    private Integer ordenTrabajoId;
    
	/**
     * Se redirecciona a editOrdenTrabajo.xhtml 
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public void init() {
    	logger.debug("Se inicia el método init()");
		
    	if(null == editable && ordenTrabajoId != null){
    		editable = servicioOrdenesTrabajo.doFindOne(ordenTrabajoId);
    	}
    	
    	if(null == editable && ordenTrabajoId == null){
    		OrdenTrabajoEstadoDTO ordenTrabajoEstadoDTO = servicioOrdenTrabajoEstado.doFindOne(OrdenTrabajoEstadoEnum.NUEVA.getValue()); 
			DetallePedidoDTO detallePedidoDTO = servicioDetallePedido.doFindOne(detallePedidoId);

			editable = new OrdenTrabajoDTO();
			editable.setOrdenTrabajoEstado(ordenTrabajoEstadoDTO);
			editable.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(new Date()));
			editable.setDetalles(new DetallesOrdenTrabajo());
			editable.setCreadaPor(super.getUsuarioLogged());
			editable.setDetallePedido(detallePedidoDTO);
		}
	}
    
    /**
     * Guarda un nuevo DTO o los cambios a uno existente
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public String save() {
		logger.debug("Inicio save()");
    	FacesMessage fMsg;
    	
    	try {
    		this.servicioOrdenesTrabajo.doSaveOrUpdate(editable);
        	
    		logger.info("OrdenTrabajo del Producto {} guardada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(msg.getString("ordenTrabajo.saved"), editable.getDetallePedido().getProducto().getNombre());        	
    	} catch(Exception e){
    		logger.error("No se pudo guadar la Orden de Trabajo del Producto {}", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.save.error"), editable.getDetallePedido().getProducto().getNombre());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:ordenesTrabajoTable");

        logger.debug("Fin save()");
        
		if(detallePedidoId != null){
			ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + editable.getDetallePedido().getPedido().getId());
		}
		return "ordenesTrabajo";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public void saveAndExportToPDF() throws JRException, IOException {
		logger.debug("Inicio saveAndExportToPDF()");
    	FacesMessage fMsg;
    	
    	try {
    		editable = this.servicioOrdenesTrabajo.doSaveOrUpdate(editable);
        	
    		super.setExportOption(ExportOption.PDF);
    		super.createReport();
    		super.exportReport();

    		logger.info("OrdenTrabajo del Producto {} guardada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(msg.getString("ordenTrabajo.saved"), editable.getDetallePedido().getProducto().getNombre());        	
    	} catch(Exception e){
    		logger.error("No se pudo imprimir la Orden de Trabajo del Usuario {}", editable.getAsignadaA().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.print.error"), editable.getAsignadaA().getNombreCompleto());
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:detalles");
    	
        logger.debug("Fin saveAndExportToPDF()");
	}
    
    /**
     * Guarda y cambia el estado de una orden de trabajo a "En Construncción"
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public String start() {
		logger.debug("Inicio start()");
    	FacesMessage fMsg;
    	
    	try {
    		this.servicioOrdenesTrabajo.doStart(editable);
        	
    		logger.info("OrdenTrabajo del Producto {} guardada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		logger.info("OrdenTrabajo del Producto {} iniciada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(msg.getString("ordenTrabajo.started"), editable.getDetallePedido().getProducto().getNombre());        	
    	} 
    	catch (ServidorCentralBusinessException e) {
    		logger.error("No se pudo iniciar la Orden de Trabajo del Producto {}", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            RequestContext.getCurrentInstance().update("form:messages");
            return null;
    	} 
    	catch(Exception e){
    		logger.error("No se pudo iniciar la Orden de Trabajo del Producto {}", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.save.error"), editable.getDetallePedido().getProducto().getNombre());
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            RequestContext.getCurrentInstance().update("form:messages");
            return null;
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");

        logger.debug("Fin start()");
        
		if(detallePedidoId != null){
			ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + editable.getDetallePedido().getPedido().getId());
		}
		return "ordenesTrabajo";
    }
    
    /**
     * Guarda y cambia el estado de una orden de trabajo a "Finalizada"
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public String complete() {
		logger.debug("Inicio complete()");
    	FacesMessage fMsg;
    	
    	try {
    		this.servicioOrdenesTrabajo.doComplete(editable);
        	
    		logger.info("OrdenTrabajo del Producto {} guardada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		logger.info("OrdenTrabajo del Producto {} finalizada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(msg.getString("ordenTrabajo.finalized"), editable.getDetallePedido().getProducto().getNombre());        	
    	} 
    	catch (ServidorCentralBusinessException e) {
    		logger.error("No se pudo completar la Orden de Trabajo del Producto {}", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            RequestContext.getCurrentInstance().update("form:messages");
            return null;
    	}  
    	catch(Exception e){
    		logger.error("No se pudo completar la Orden de Trabajo del Producto {}", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.save.error"), editable.getDetallePedido().getProducto().getNombre());
            FacesContext.getCurrentInstance().addMessage(null, fMsg);
            RequestContext.getCurrentInstance().update("form:messages");
            return null;
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");

        logger.debug("Fin complete()");
        
		if(detallePedidoId != null){
			ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + editable.getDetallePedido().getPedido().getId());
		}
		return "ordenesTrabajo";
    }
    
    /**
     * Guarda y cambia el estado de una orden de trabajo a "Suspendida"
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public String suspend() {
		logger.debug("Inicio suspend()");
    	FacesMessage fMsg;
    	
    	try {
    		this.servicioOrdenesTrabajo.doSuspend(editable);
        	
    		logger.info("OrdenTrabajo del Producto {} guardada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		logger.info("OrdenTrabajo del Producto {} suspendida exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(msg.getString("ordenTrabajo.suspended"), editable.getDetallePedido().getProducto().getNombre());        	
    	} catch(Exception e){
    		logger.error("No se pudo guadar la Orden de Trabajo del Producto {}", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.save.error"), editable.getDetallePedido().getProducto().getNombre());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:ordenesTrabajoTable");

        logger.debug("Fin suspend()");
        
		if(detallePedidoId != null){
			ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + editable.getDetallePedido().getPedido().getId());
		}
		return "ordenesTrabajo";
    }
    
    /**
     * Guarda y cambia el estado de una orden de trabajo a "Cancelada"
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public String cancel() {
		logger.debug("Inicio cancel()");
    	FacesMessage fMsg;
    	
    	try {
    		this.servicioOrdenesTrabajo.doCancel(editable);
        	
    		logger.info("OrdenTrabajo del Producto {} guardada exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		logger.info("OrdenTrabajo del Producto {} suspendida exitosamente", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(msg.getString("ordenTrabajo.canceled"), editable.getDetallePedido().getProducto().getNombre());        	
    	} catch(Exception e){
    		logger.error("No se pudo guadar la Orden de Trabajo del Producto {}", editable.getDetallePedido().getProducto().getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.save.error"), editable.getDetallePedido().getProducto().getNombre());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:ordenesTrabajoTable");

        logger.debug("Fin cancel()");
        
		if(detallePedidoId != null){
			ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + editable.getDetallePedido().getPedido().getId());
		}
		return "ordenesTrabajo";
    }
    
	
    @PreAuthorize("hasRole('ROLE_DELETE_ORDEN_TRABAJO')")
    public String delete() {
		logger.debug("Inicio delete()");
    	FacesMessage fMsg;

    	try{
    		this.servicioOrdenesTrabajo.doDelete(editable.getId());
    	
			fMsg = new FacesMessage(msg.getString("ordenTrabajo.deleted"));
            RequestContext.getCurrentInstance().update("form:ordenesTrabajoTable");
    	}catch(Exception e){
    		logger.error("No se pudo eliminar la orden de trabajo id: {}", editable.getId());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.delete.error"), String.valueOf(editable.getId()));
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
		
		if(detallePedidoId != null){
			ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + editable.getDetallePedido().getPedido().getId());
		}
		return "ordenesTrabajo";
    }
    
    public String exit() {
		logger.debug("Inicio cancel()");
		if(detallePedidoId != null){
			ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + editable.getDetallePedido().getPedido().getId());
		}
		return "ordenesTrabajo";
    }
    
    public void onRowSelect(SelectEvent event) {
    	logger.debug("Orden de Trabajo seleccionada: ", ((OrdenTrabajoDTO) event.getObject()).getId());
    }    
    
    
    public List<ClienteDTO> completarCliente(String query) {
        List<ClienteDTO> clientesFiltrados = new ArrayList<ClienteDTO>();
         
       	for (ClienteDTO clienteDTO : this.getClientes()) {
	        if(clienteDTO.getNombre().toLowerCase().contains(query.toLowerCase()) || clienteDTO.getApellido().toLowerCase().contains(query.toLowerCase())) {
                clientesFiltrados.add(clienteDTO);
            }
        }
        return clientesFiltrados;
    }
    
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public void prepareNewDetalle() {
    	this.detalleEditable = new DetalleOrdenTrabajoDTO();
    	this.detalleEditable.setCantidad(1.0);
		logger.debug("Se inicia el método prepareNewDetalle()");
    }
    
    /**
     * Agregar un nuevo DetalleOrdenTrabajoDTO a la lista de detalles de la Orden de Trabajo que se está editando/agregando
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public void addDetalle() {
		logger.debug("Inicio addDetalle()");
    	FacesMessage fMsg;
    	        	
		fMsg = new FacesMessage(msg.getString("ordenTrabajo.detalle.saved"));
    	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");        	
    	if(editable.getDetalles().getDetalleOrdenTrabajo().contains(detalleEditable)){
    		int idx = editable.getDetalles().getDetalleOrdenTrabajo().indexOf(detalleEditable);
    		DetalleOrdenTrabajoDTO det = editable.getDetalles().getDetalleOrdenTrabajo().get(idx);
    		det.setCantidad(det.getCantidad() + detalleEditable.getCantidad());
    	}
    	else{
        	editable.getDetalles().getDetalleOrdenTrabajo().add(detalleEditable);
    	}
    	    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:detalles");
        logger.info("Detalle de OrdenTrabajo agregado exitosamente");
        logger.debug("Fin save()");
    }
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_ORDEN_TRABAJO','ROLE_EDIT_ORDEN_TRABAJO')")
    public void deleteDetalle() {
		logger.debug("Inicio deleteDetalle()");
    	FacesMessage fMsg;

    	try{
    		fMsg = new FacesMessage(msg.getString("ordenTrabajo.detalle.deleted"));
    		editable.getDetalles().getDetalleOrdenTrabajo().remove(detalleEditable);
            RequestContext.getCurrentInstance().update("form:detalles");
        }catch(Exception e){
    		logger.error("No se pudo eliminar el detalle para el insumo:  {}", detalleEditable.getProducto().getNombre());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("ordenTrabajo.detalle.deleted.error"), detalleEditable.getProducto().getNombre());
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
    }

    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Detalle Modificado", ((DetalleOrdenTrabajoDTO) event.getObject()).getProducto().getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modificación Cancelada", ((DetalleOrdenTrabajoDTO) event.getObject()).getProducto().getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public List<ProductoDTO> completarProducto(String query) {
        List<ProductoDTO> productosFiltrados = new ArrayList<ProductoDTO>();
         
       	for (ProductoDTO productoDTO : this.getProductos()) {
	        if(productoDTO.getNombre().toLowerCase().startsWith(query.toLowerCase())) {
                productosFiltrados.add(productoDTO);
            }
        }
        return productosFiltrados;
    }
    

	public Date getEditableFechaCreacion() {
		return editable != null && editable.getFechaCreacion() != null ? XMLGregorianCalendarConverter.asDate(editable.getFechaCreacion()) : null;
	}
	
	public void setEditableFechaEstimadaFin(Date fecha) {
		this.editable.setFechaEstimadaFin(XMLGregorianCalendarConverter.asXMLGregorianCalendar(fecha));
	}
	
	public Date getEditableFechaEstimadaFin() {
		return editable != null && editable.getFechaEstimadaFin() != null ? XMLGregorianCalendarConverter.asDate(editable.getFechaEstimadaFin()) : null;
	}

	public List<ClienteDTO> getClientes() {
		if(clientes == null){
			clientes = this.servicioClientes.doFindAll();
		}
		return clientes;
	}
	
	public List<ProductoDTO> getProductos() {
		if(productos == null){
			productos = this.servicioProductos.doFindByElaboradoIsFalse();
		}
		return productos;
	}
	
	public List<UsuarioDTO> getUsuarios() {
		if(usuarios == null){
			this.usuarios = super.servicioUsuarios.doFindAllByUserLogged(super.getUsuarioLogged());
		}
		return usuarios;
	}

	public OrdenTrabajoDTO getEditable() {
		return editable;
	}

	public void setEditable(OrdenTrabajoDTO editable) {
		this.editable = editable;
	}
	
	public DetalleOrdenTrabajoDTO getDetalleEditable() {
		return detalleEditable;
	}

	public void setDetalleEditable(DetalleOrdenTrabajoDTO detalleEditable) {
		this.detalleEditable = detalleEditable;
	}

	
	public Integer getDetallePedidoId() {
		return detallePedidoId;
	}

	public void setDetallePedidoId(Integer detallePedidoId) {
		this.detallePedidoId = detallePedidoId;
	}

	public Integer getOrdenTrabajoId() {
		return ordenTrabajoId;
	}

	public void setOrdenTrabajoId(Integer ordenTrabajoId) {
		this.ordenTrabajoId = ordenTrabajoId;
	}
	
	public int getOrdenTrabajoEstadoEnumNueva() {
		return OrdenTrabajoEstadoEnum.NUEVA.getValue();
	}
	
	public int getOrdenTrabajoEstadoEnumEnConstruccion() {
		return OrdenTrabajoEstadoEnum.EN_CONSTRUCCION.getValue();
	}
	
	public int getOrdenTrabajoEstadoEnumFinalizada() {
		return OrdenTrabajoEstadoEnum.FINALIZADA.getValue();
	}
	
	public int getOrdenTrabajoEstadoEnumSuspendida() {
		return OrdenTrabajoEstadoEnum.SUSPENDIDA.getValue();
	}
	
	public int getOrdenTrabajoEstadoEnumCancelada() {
		return OrdenTrabajoEstadoEnum.CANCELADA.getValue();
	}
	
	@Override
	protected String getCompileFileName() {
		return "ordenTrabajoPDF";
	}

	@Override
	protected JRBeanCollectionDataSource getJRBeanCollectionDataSource() {
		List<DetalleOrdenTrabajoReporteDTO> list = new ArrayList<DetalleOrdenTrabajoReporteDTO>();
		for (DetalleOrdenTrabajoDTO detalleOrdenTrabajoDTO : this.editable.getDetalles().getDetalleOrdenTrabajo()) {
			DetalleOrdenTrabajoReporteDTO dto = DetalleOrdenTrabajoReporteConverter.toDetalleOrdenTrabajoReporteDTO(detalleOrdenTrabajoDTO);
			list.add(dto);
		}
		Collections.sort(list,new DetalleOrdenTrabajoReporteDTOComparator());
		return new JRBeanCollectionDataSource((Collection<DetalleOrdenTrabajoReporteDTO>) list);
	}

	@Override
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> params = new HashMap<String, Object>();
	    
	    ClienteDTO cliente = this.editable.getDetallePedido().getPedido().getCliente();
	    
	    params.put("cliente", cliente.getNombreCompleto());
	    params.put("fechaEstimadaFin", XMLGregorianCalendarConverter.asDate(this.editable.getFechaEstimadaFin()));
	    params.put("id", this.editable.getId());
	    params.put("estado", this.editable.getOrdenTrabajoEstado().getNombre());
	    params.put("creadaPor", this.editable.getCreadaPor().getNombreCompleto());
	    params.put("asignadaA", this.editable.getAsignadaA().getNombreCompleto());
	    params.put("pedidoAsociado", this.editable.getDetallePedido().getPedido().getId());
	    params.put("nombreProducto", this.editable.getDetallePedido().getNombre());
	    params.put("descripcionProducto", this.editable.getDetallePedido().getDescripcion());
	    params.put("medidaProducto", String.valueOf(this.editable.getDetallePedido().getMedida()) + " ("+this.editable.getDetallePedido().getProducto().getUnidadMedida().getSimbolo()+")");
	    params.put("cantidadProducto", this.editable.getDetallePedido().getCantidad());
	    return params;
	}

	public void setServicioOrdenesTrabajo(ServicioOrdenesTrabajo servicioOrdenesTrabajo) {
		this.servicioOrdenesTrabajo = servicioOrdenesTrabajo;
	}
	
	public void setServicioClientes(ServicioGeneric<ClienteDTO> servicioClientes) {
		this.servicioClientes = servicioClientes;
	}    

	public void setServicioProductos(ServicioProductos servicioProductos) {
		this.servicioProductos = servicioProductos;
	}

	public void setServicioDetallePedido(ServicioGeneric<DetallePedidoDTO> servicioDetallePedido) {
		this.servicioDetallePedido = servicioDetallePedido;
	}

	public void setServicioOrdenTrabajoEstado(
			ServicioGeneric<OrdenTrabajoEstadoDTO> servicioOrdenTrabajoEstado) {
		this.servicioOrdenTrabajoEstado = servicioOrdenTrabajoEstado;
	}
}
