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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ceriarte.central.converters.DetallePresupuestoReporteConverter;
import com.ceriarte.central.dominio.dto.ClienteDTO;
import com.ceriarte.central.dominio.dto.DetallePresupuestoDTO;
import com.ceriarte.central.dominio.dto.DetallePresupuestoReporteDTO;
import com.ceriarte.central.dominio.dto.DetallesPresupuesto;
import com.ceriarte.central.dominio.dto.LocalidadDTO;
import com.ceriarte.central.dominio.dto.PresupuestoDTO;
import com.ceriarte.central.dominio.dto.PresupuestoEstadoDTO;
import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.enums.PresupuestoEstadoEnum;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.servicios.ServicioPresupuestos;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;
import com.ceriarte.central.web.comparator.DetallePresupuestoReporteDTOComparator;

@ManagedBean(name = "presupuestoController")
@ViewScoped
public class PresupuestoController extends AbstractReportController implements Serializable {

	
	private static final long serialVersionUID = -3649684487498077086L;

	private final Logger logger = LoggerFactory.getLogger(PresupuestoController.class);

	@ManagedProperty(value ="#{servicioPresupuestos}")
	private ServicioPresupuestos servicioPresupuestos;
	
	@ManagedProperty(value ="#{servicioPresupuestoEstado}")
	private ServicioGeneric<PresupuestoEstadoDTO> servicioPresupuestoEstado;
	
	@ManagedProperty(value ="#{servicioClientes}")
	private ServicioGeneric<ClienteDTO> servicioClientes;
	
	@ManagedProperty(value ="#{servicioProductos}")
	private ServicioGeneric<ProductoDTO> servicioProductos;
	
	private PresupuestoDTO editable;
	private DetallePresupuestoDTO detalleEditable;
	private List<ClienteDTO> clientes;
	private List<ProductoDTO> productos;
    private Integer presupuestoId;
    private double montoTotal;
   

    
	/**
     * Se redirecciona a editPresupuesto.xhtml 
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public void init() {
		logger.debug("Se inicia el método init()");
    	if(null == editable && presupuestoId != null){
    		editable = this.servicioPresupuestos.doFindOne(presupuestoId);
    	}
		if(null == editable && presupuestoId == null){
			PresupuestoEstadoDTO presupuestoEstadoDTO = servicioPresupuestoEstado.doFindOne(PresupuestoEstadoEnum.CREADO.getValue());
			
			editable = new PresupuestoDTO();
			editable.setPresupuestoEstado(presupuestoEstadoDTO);
			editable.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(new Date()));
			editable.setDetalles(new DetallesPresupuesto());
		}
	}
    
    /**
     * Guarda un nuevo DTO o los cambios a uno existente
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public void save() {
		logger.debug("Inicio save()");
    	FacesMessage fMsg;
    	
    	try {
    		editable = this.servicioPresupuestos.doSaveOrUpdate(editable);
        	
    		logger.info("Presupuesto del Cliente {} guardado exitosamente", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(msg.getString("presupuesto.saved"), editable.getCliente().getNombreCompleto());        	
    	} catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Presupuesto del Cliente -{}- ya existe!", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("presupuesto.save.error.duplicated"), editable.getCliente().getNombreCompleto());
    	} catch(Exception e){
    		logger.error("No se pudo guadar el Prespuesto del Cliente {}", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("presupuesto.save.error"), editable.getCliente().getNombreCompleto());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:detalles");

        logger.debug("Fin save()");
    }

    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public void saveAndExportToPDF() throws JRException, IOException {
		logger.debug("Inicio saveAndExportToPDF()");
    	FacesMessage fMsg;
    	
    	try {
    		editable = this.servicioPresupuestos.doSaveOrUpdate(editable);
        	
    		super.setExportOption(ExportOption.PDF);
    		super.createReport();
    		super.exportReport();

    		logger.info("Presupuesto del Cliente {} guardado e impreso exitosamente", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(msg.getString("presupuesto.saved"), editable.getCliente().getNombreCompleto());        	
    	} catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Presupuesto del Cliente -{}- ya existe!", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("presupuesto.save.error.duplicated"), editable.getCliente().getNombreCompleto());
    	} catch(Exception e){
    		logger.error("No se pudo imprimir el Prespuesto del Cliente {}", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("presupuesto.print.error"), editable.getCliente().getNombreCompleto());
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:detalles");
    	
        logger.debug("Fin saveAndExportToPDF()");
	}
    
	@PreAuthorize("hasRole('ROLE_DELETE_PRESUPUESTO')")
	public String delete() {
		logger.debug("Inicio delete()");
    	FacesMessage fMsg;

    	try{
    		servicioPresupuestos.doDelete(editable.getId());
    	
			fMsg = new FacesMessage(msg.getString("presupuesto.deleted"));
            RequestContext.getCurrentInstance().update("form:presupuestosTable");
    	}catch(Exception e){
    		logger.error("No se pudo eliminar el presupuesto id: {}", editable.getId());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("presupuesto.delete.error"), String.valueOf(editable.getId()));
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
		
		return "presupuestos";
    }

    @PreAuthorize("hasRole('ROLE_ADM_PRESUPUESTOS')")
    public void exportToPDF(ActionEvent actionEvent) throws JRException, IOException {
		super.setExportOption(ExportOption.PDF);
		super.createReport();
		super.exportReport();
	}
    
    public String cancel() {
		logger.debug("Inicio cancel()");
		return "presupuestos";
    }

    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public String approve() {
		logger.debug("Inicio approve()");
    	FacesMessage fMsg;
    	
    	try {
			PresupuestoEstadoDTO presupuestoEstadoDTO = new PresupuestoEstadoDTO();
			presupuestoEstadoDTO.setId(PresupuestoEstadoEnum.APROBADO.getValue());
    		editable.setPresupuestoEstado(presupuestoEstadoDTO);
    		this.servicioPresupuestos.doApprove(editable);
        	
    		logger.info("Presupuesto del Cliente {} guardado exitosamente", editable.getCliente().getNombreCompleto());
    		logger.info("Presupuesto del Cliente {} aprobado exitosamente", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(msg.getString("presupuesto.approved"), editable.getCliente().getNombreCompleto());
    	} catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Presupuesto del Cliente -{}- ya existe!", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("presupuesto.save.error.duplicated"), editable.getCliente().getNombreCompleto());
    	} catch(Exception e){
    		logger.error("No se pudo guadar el Prespuesto del Cliente {}", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("presupuesto.save.error"), editable.getCliente().getNombreCompleto());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        return "presupuestos";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public String disapprove() {
		logger.debug("Inicio disapprove()");
    	FacesMessage fMsg;
    	try {
			PresupuestoEstadoDTO presupuestoEstadoDTO = new PresupuestoEstadoDTO();
			presupuestoEstadoDTO.setId(PresupuestoEstadoEnum.NO_APROBADO.getValue());
    		editable.setPresupuestoEstado(presupuestoEstadoDTO);
    		this.servicioPresupuestos.doSaveOrUpdate(editable);
        	
    		logger.info("Presupuesto del Cliente {} guardado exitosamente", editable.getCliente().getNombreCompleto());
    		logger.info("Presupuesto del Cliente {} reprobado exitosamente", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(msg.getString("presupuesto.no.approved"), editable.getCliente().getNombreCompleto());
    	} catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Presupuesto del Cliente -{}- ya existe!", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("presupuesto.save.error.duplicated"), editable.getCliente().getNombreCompleto());
    	} catch(Exception e){
    		logger.error("No se pudo guadar el Prespuesto del Cliente {}", editable.getCliente().getNombreCompleto());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("presupuesto.save.error"), editable.getCliente().getNombreCompleto());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        return "presupuestos";
    }
    
    public void onRowSelect(SelectEvent event) {
    	logger.debug("Prespuesto seleccionado: ", ((PresupuestoDTO) event.getObject()).getId());
    }    
    
    
    public List<ClienteDTO> completarCliente(String query) {
        List<ClienteDTO> clientesFiltrados = new ArrayList<ClienteDTO>();
         
       	for (ClienteDTO clienteDTO : this.getClientes()) {
	        if(clienteDTO.getNombre().toLowerCase().startsWith(query.toLowerCase()) || clienteDTO.getApellido().toLowerCase().startsWith(query.toLowerCase())) {
                clientesFiltrados.add(clienteDTO);
            }
        }
        return clientesFiltrados;
    }
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public void prepareNewDetalle() {
    	this.detalleEditable = new DetallePresupuestoDTO();
    	this.detalleEditable.setCantidad(1);
		logger.debug("Se inicia el método prepareNewDetalle()");
    }
    
    /**
     * Agregar un nuevo DetallePresupuestoDTO a la lista de detalles del presupuesto que se está editando/agregando
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public void addDetalle() {
		logger.debug("Inicio addDetalle()");
    	FacesMessage fMsg;
    	
    	detalleEditable.setNombre(detalleEditable.getProducto().getNombre());
    	detalleEditable.setDescripcion(detalleEditable.getProducto().getDescripcion());
    	
		fMsg = new FacesMessage(msg.getString("presupuesto.detalle.saved"));
    	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");        	
    	if(editable.getDetalles().getDetallePresupuesto().contains(detalleEditable)){
    		int idx = editable.getDetalles().getDetallePresupuesto().indexOf(detalleEditable);
    		DetallePresupuestoDTO det = editable.getDetalles().getDetallePresupuesto().get(idx);
    		det.setCantidad(det.getCantidad() + detalleEditable.getCantidad());
    	}
    	else{
        	editable.getDetalles().getDetallePresupuesto().add(detalleEditable);
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:detalles");
        RequestContext.getCurrentInstance().update("form:montoTotal");
		logger.info("Detalle de Presupuesto agregado exitosamente");
        logger.debug("Fin save()");
    }
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_PRESUPUESTO','ROLE_EDIT_PRESUPUESTO')")
    public void deleteDetalle() {
		logger.debug("Inicio deleteDetalle()");
    	FacesMessage fMsg;

    	try{
    		fMsg = new FacesMessage(msg.getString("presupuesto.detalle.deleted"));
    		editable.getDetalles().getDetallePresupuesto().remove(detalleEditable);
            RequestContext.getCurrentInstance().update("form:detalles");
            RequestContext.getCurrentInstance().update("form:montoTotal");
    	}catch(Exception e){
    		logger.error("No se pudo eliminar el detalle para el producto:  {}", detalleEditable.getProducto().getNombre());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("presupuesto.detalle.delete.error"), detalleEditable.getProducto().getNombre());
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
    }

    
    public void onRowEdit(RowEditEvent event) {
    	logger.debug("Detalle Modificado", ((DetallePresupuestoDTO) event.getObject()).getProducto().getNombre());
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modificación Cancelada", ((DetallePresupuestoDTO) event.getObject()).getProducto().getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onProductoChange(AjaxBehaviorEvent event) {
    	logger.debug("Se seleccionó un nuevo producto - Se modifica el  Precio Unitario");
    	detalleEditable.setPrecioUnitario(detalleEditable.getProducto().getPrecioUnitario());
    	detalleEditable.setMedida(detalleEditable.getProducto().getMedida());
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
    
	public Date getEditableFechaValidoHasta() {
		return editable != null && editable.getFechaValidoHasta() != null ? XMLGregorianCalendarConverter.asDate(editable.getFechaValidoHasta()) : null;
	}

	public void setEditableFechaValidoHasta(Date fecha) {
		this.editable.setFechaValidoHasta(XMLGregorianCalendarConverter.asXMLGregorianCalendar(fecha));
	}
	
	public Date getEditableFechaCreacion() {
		return editable != null && editable.getFechaCreacion() != null ? XMLGregorianCalendarConverter.asDate(editable.getFechaCreacion()) : null;
	}

	public List<ClienteDTO> getClientes() {
		if(clientes == null){
			clientes = this.servicioClientes.doFindAll();
		}
		return clientes;
	}
	
	public List<ProductoDTO> getProductos() {
		if(productos == null){
			productos = this.servicioProductos.doFindAll();
		}
		return productos;
	}

	public PresupuestoDTO getEditable() {
		return editable;
	}

	public void setEditable(PresupuestoDTO editable) {
		this.editable = editable;
	}
	
	public DetallePresupuestoDTO getDetalleEditable() {
		return detalleEditable;
	}

	public void setDetalleEditable(DetallePresupuestoDTO detalleEditable) {
		this.detalleEditable = detalleEditable;
	}
    
    public Integer getPresupuestoId() {
		return presupuestoId;
	}

	public void setPresupuestoId(Integer presupuestoId) {
		this.presupuestoId = presupuestoId;
	}
	
	public double getMontoTotal() {
		montoTotal = 0.0;
		for (DetallePresupuestoDTO detallePresupuestoDTO : editable.getDetalles().getDetallePresupuesto()) {
			montoTotal += detallePresupuestoDTO.getPrecioUnitario() * detallePresupuestoDTO.getCantidad() * detallePresupuestoDTO.getMedida();
		}
		return montoTotal;
	}
	

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	@Override
	protected String getCompileFileName() {
		return "presupuestoPDF";
	}

	@Override
	protected JRBeanCollectionDataSource getJRBeanCollectionDataSource() {
		List<DetallePresupuestoReporteDTO> list = new ArrayList<DetallePresupuestoReporteDTO>();
		for (DetallePresupuestoDTO detallePresupuestoDTO : this.editable.getDetalles().getDetallePresupuesto()) {
			DetallePresupuestoReporteDTO dto = DetallePresupuestoReporteConverter.toDetallePresupuestoReporteDTO(detallePresupuestoDTO);
			list.add(dto);
		}
		Collections.sort(list,new DetallePresupuestoReporteDTOComparator());
		return new JRBeanCollectionDataSource((Collection<DetallePresupuestoReporteDTO>) list);
	}
	
	@Override
	protected Map<String, Object> getReportParameters() {
	    Map<String, Object> params = new HashMap<String, Object>();
	    
	    ClienteDTO cliente = this.editable.getCliente();
	    LocalidadDTO localidad = cliente.getLocalidad();
	    
	    params.put("cliente", cliente.getNombreCompleto());
	    params.put("domicilio", cliente.getDomicilio());
	    params.put("localidad", localidad != null ? localidad.getNombre() : "");
	    params.put("fechaCreacion", XMLGregorianCalendarConverter.asDate(this.editable.getFechaCreacion()));
	    params.put("fechaValidoHasta", XMLGregorianCalendarConverter.asDate(this.editable.getFechaValidoHasta()));
	    params.put("id", this.editable.getId());
	    params.put("estado", this.editable.getPresupuestoEstado().getNombre());
	    params.put("montoTotal", this.getMontoTotal());
	    params.put("observaciones", this.editable.getObservaciones());
	    return params;
	}
	
	public int getPresupuestoEstadoEnumCreado() {
		return PresupuestoEstadoEnum.CREADO.getValue();
	}

	public ServicioPresupuestos getServicioPresupuestos() {
		return servicioPresupuestos;
	}

	public void setServicioPresupuestos(ServicioPresupuestos servicioPresupuestos) {
		this.servicioPresupuestos = servicioPresupuestos;
	}

	public void setServicioClientes(ServicioGeneric<ClienteDTO> servicioClientes) {
		this.servicioClientes = servicioClientes;
	}    

	public void setServicioProductos(ServicioGeneric<ProductoDTO> servicioProductos) {
		this.servicioProductos = servicioProductos;
	}

	public void setServicioPresupuestoEstado(
			ServicioGeneric<PresupuestoEstadoDTO> servicioPresupuestoEstado) {
		this.servicioPresupuestoEstado = servicioPresupuestoEstado;
	}
}
