package com.ceriarte.central.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ceriarte.central.dominio.dto.ClienteDTO;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;
import com.ceriarte.central.dominio.dto.DetallePedidoEstadoDTO;
import com.ceriarte.central.dominio.dto.DetallesPedido;
import com.ceriarte.central.dominio.dto.PedidoDTO;
import com.ceriarte.central.dominio.dto.PedidoEstadoDTO;
import com.ceriarte.central.dominio.dto.PresupuestoDTO;
import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.enums.DetallePedidoEstadoEnum;
import com.ceriarte.central.enums.PedidoEstadoEnum;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

@ManagedBean(name = "pedidoController")
@ViewScoped
public class PedidoController extends AbstractController implements Serializable {

	
	private static final long serialVersionUID = -3649684487494377086L;

	private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

	@ManagedProperty(value ="#{servicioPedidos}")
	private ServicioGeneric<PedidoDTO> servicioPedidos;
	
	@ManagedProperty(value ="#{servicioClientes}")
	private ServicioGeneric<ClienteDTO> servicioClientes;
	
	@ManagedProperty(value ="#{servicioPresupuestos}")
	private ServicioGeneric<PresupuestoDTO> servicioPresupuestos;
	
	@ManagedProperty(value ="#{servicioProductos}")
	private ServicioGeneric<ProductoDTO> servicioProductos;
	
	@ManagedProperty(value ="#{servicioDetallePedidoEstado}")
	private ServicioGeneric<DetallePedidoEstadoDTO> servicioDetallePedidoEstado;
	
	@ManagedProperty(value ="#{servicioPedidoEstado}")
	private ServicioGeneric<PedidoEstadoDTO> servicioPedidoEstado;
	
	private PedidoDTO editable;
	private DetallePedidoDTO detalleEditable;
	private Integer detallePedidoEstadoId;
	private List<ClienteDTO> clientes;
	private List<PresupuestoDTO> presupuestos;
	private List<ProductoDTO> productos;
    private Integer pedidoId;
    private double montoTotal;

	/**
     * Se redirecciona a editPedido.xhtml 
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_PEDIDO','ROLE_EDIT_PEDIDO')")
    public void init() {
		logger.debug("Se inicia el método init()");
    	if(null == editable && pedidoId != null){
    		editable = this.servicioPedidos.doFindOne(pedidoId);
    	}
		if(null == editable && pedidoId == null){
			PedidoEstadoDTO pedidoEstadoDTO = servicioPedidoEstado.doFindOne(PedidoEstadoEnum.NUEVO.getValue());
			
			editable = new PedidoDTO();
			editable.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(new Date()));
			editable.setDetalles(new DetallesPedido());
			editable.setPedidoEstado(pedidoEstadoDTO);
		}
	}
    
    /**
     * Guarda un nuevo DTO o los cambios a uno existente
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_PEDIDO','ROLE_EDIT_PEDIDO')")
    public void save() {
		logger.debug("Inicio save()");
    	FacesMessage fMsg;
    	
    	try {
    		editable = this.servicioPedidos.doSaveOrUpdate(editable);
        	
    		logger.info("Pedido del Cliente {} guardado exitosamente", editable.getCliente().getApellido());
    		fMsg = new FacesMessage(msg.getString("pedido.saved"), editable.getCliente().getApellido());        	
    	} catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Pedido del Cliente -{}- ya existe!", editable.getCliente().getApellido());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("pedido.save.error.duplicated"), editable.getCliente().getApellido());
    	} catch(Exception e){
    		logger.error("No se pudo guadar el Prespuesto del Cliente {}", editable.getCliente().getApellido());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("pedido.save.error"), editable.getCliente().getApellido());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:detalles");
        RequestContext.getCurrentInstance().update("form:estado");

        logger.debug("Fin save()");
    }
    
    @PreAuthorize("hasRole('ROLE_DELETE_PEDIDO')")
    public String delete() {
		logger.debug("Inicio delete()");
    	FacesMessage fMsg;

    	try{
    		this.servicioPedidos.doDelete(editable.getId());	
			fMsg = new FacesMessage(msg.getString("pedido.deleted"));
    	}catch(Exception e){
    		logger.error("No se pudo eliminar el pedido id: {}", editable.getId());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("pedido.delete.error"), String.valueOf(editable.getId()));
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
		
        return "pedidos";
    }
    
    public String cancel() {
		logger.debug("Inicio cancel()");
		return "pedidos";
    }
    
    public void onRowSelect(SelectEvent event) {
    	logger.debug("Prespuesto seleccionado: ", ((PedidoDTO) event.getObject()).getId());
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
    
    public List<PresupuestoDTO> completarPresupuesto(String query) {
        List<PresupuestoDTO> presupuestosFiltrados = new ArrayList<PresupuestoDTO>();
         
       	for (PresupuestoDTO presupuetoDTO : this.getPresupuestos()) {
	        if(String.valueOf(presupuetoDTO.getId()).contains(query) || presupuetoDTO.getCliente().getNombre().toLowerCase().contains(query.toLowerCase()) || presupuetoDTO.getCliente().getApellido().toLowerCase().contains(query.toLowerCase())) {
                presupuestosFiltrados.add(presupuetoDTO);
            }
        }
        return presupuestosFiltrados;
    }
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_PEDIDO','ROLE_EDIT_PEDIDO')")
    public void prepareNewDetalle() {
    	this.detalleEditable = new DetallePedidoDTO();
    	this.detalleEditable.setCantidad(1.0);
    	
		logger.debug("Se inicia el método prepareNewDetalle()");
    }
    
    /**
     * Agregar un nuevo DetallePedidoDTO a la lista de detalles del pedido que se está editando/agregando
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_PEDIDO','ROLE_EDIT_PEDIDO')")
    public void addDetalle() {
		logger.debug("Inicio addDetalle()");
    	FacesMessage fMsg;
    	 
    	detalleEditable.setNombre(detalleEditable.getProducto().getNombre());
    	detalleEditable.setDescripcion(detalleEditable.getProducto().getDescripcion());
    	if(detalleEditable.getProducto().isElaborado()){
    		detalleEditable.setDetallePedidoEstado(servicioDetallePedidoEstado.doFindOne(DetallePedidoEstadoEnum.PENDIENTE_ELABORACION.getValue()));
    	}else{
    		detalleEditable.setDetallePedidoEstado(servicioDetallePedidoEstado.doFindOne(DetallePedidoEstadoEnum.PENDIENTE_ENTREGA.getValue()));
    	}
    	
    	if(editable.getDetalles().getDetallePedido().contains(detalleEditable)){
    		int idx = editable.getDetalles().getDetallePedido().indexOf(detalleEditable);
    		DetallePedidoDTO det = editable.getDetalles().getDetallePedido().get(idx);
    		det.setCantidad(det.getCantidad() + detalleEditable.getCantidad());
    	}
    	else{
        	editable.getDetalles().getDetallePedido().add(detalleEditable);
    	}
    	
    	fMsg = new FacesMessage(msg.getString("pedido.detalle.saved"));
    	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");   
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:detalles");
        RequestContext.getCurrentInstance().update("form:montoTotal");
		logger.info("Detalle de Pedido agregado exitosamente");
        logger.debug("Fin save()");
    }
    
    @PreAuthorize("hasAnyRole('ROLE_NEW_PEDIDO','ROLE_EDIT_PEDIDO')")
    public void deleteDetalle() {
		logger.debug("Inicio deleteDetalle()");
    	FacesMessage fMsg;

    	try{
    		fMsg = new FacesMessage(msg.getString("pedido.detalle.deleted"));
    		editable.getDetalles().getDetallePedido().remove(detalleEditable);
            RequestContext.getCurrentInstance().update("form:detalles");
            RequestContext.getCurrentInstance().update("form:montoTotal");
    	}catch(Exception e){
    		logger.error("No se pudo eliminar el detalle para el producto:  {}", detalleEditable.getProducto().getNombre());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("pedido.detalle.deleted.error"), detalleEditable.getProducto().getNombre());
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
    }

    
    public void onRowEdit(RowEditEvent event) {
        DetallePedidoDTO currentDetallePedidoDTO = (DetallePedidoDTO) event.getObject();
		ProductoDTO producto = currentDetallePedidoDTO.getProducto();
        
        if(detallePedidoEstadoId != null){
	        DetallePedidoEstadoDTO detallePedidoEstadoDTO = servicioDetallePedidoEstado.doFindOne(detallePedidoEstadoId);
	        currentDetallePedidoDTO.setDetallePedidoEstado(detallePedidoEstadoDTO);
			if(currentDetallePedidoDTO.getDetallePedidoEstado().getId() == DetallePedidoEstadoEnum.ENTREGADO.getValue() && !producto.isElaborado() && producto.getStock() != null){
				producto.setStock(producto.getStock() - (currentDetallePedidoDTO.getCantidad() * currentDetallePedidoDTO.getMedida()));
			}
		}
        
        // Seteo la variable detallePedidoEstadoId en null para que al editar otro registro no tome en cuenta el estado anterior de dicha variable
        detallePedidoEstadoId = null;
    	logger.debug("Detalle Modificado", (producto.getNombre()));
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modificación Cancelada", ((DetallePedidoDTO) event.getObject()).getProducto().getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onProductoChange(AjaxBehaviorEvent event) {
    	logger.debug("Se seleccionó un nuevo producto - Se modifica el  Precio Unitario");
    	detalleEditable.setPrecioUnitario(detalleEditable.getProducto().getPrecioUnitario());
    	detalleEditable.setMedida(detalleEditable.getProducto().getMedida());
    }
    
    public void onPresupuestoChange(AjaxBehaviorEvent event) {
    	logger.debug("Se seleccionó un nuevo presupuesto - Se modifica el Cliente");
    	if(editable.getPresupuesto() != null){
    		editable.setCliente(editable.getPresupuesto().getCliente());
    	}
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

	public List<ClienteDTO> getClientes() {
		if(clientes == null){
			clientes = this.servicioClientes.doFindAll();
		}
		return clientes;
	}
	
	public List<PresupuestoDTO> getPresupuestos() {
		if(presupuestos == null){
			presupuestos = this.servicioPresupuestos.doFindAll();
		}
		return presupuestos;
	}

	public List<ProductoDTO> getProductos() {
		if(productos == null){
			productos = this.servicioProductos.doFindAll();
		}
		return productos;
	}

	public PedidoDTO getEditable() {
		return editable;
	}

	public void setEditable(PedidoDTO editable) {
		this.editable = editable;
	}
	
	public DetallePedidoDTO getDetalleEditable() {
		return detalleEditable;
	}

	public void setDetalleEditable(DetallePedidoDTO detalleEditable) {
		this.detalleEditable = detalleEditable;
	}
    
    public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}
	
	public Integer getDetallePedidoEstadoId() {
		return detallePedidoEstadoId;
	}

	public void setDetallePedidoEstadoId(Integer detallePedidoEstadoId) {
		this.detallePedidoEstadoId = detallePedidoEstadoId;
	}

	public double getMontoTotal() {
		montoTotal = 0.0;
		for (DetallePedidoDTO detallePedidoDTO : editable.getDetalles().getDetallePedido()) {
			montoTotal += detallePedidoDTO.getDetallePedidoEstado().getId() != DetallePedidoEstadoEnum.CANCELADO.getValue() ? 
						  detallePedidoDTO.getPrecioUnitario() * detallePedidoDTO.getCantidad() * detallePedidoDTO.getMedida(): 0.0;
		}
		return montoTotal;
	}
	
	public int getDetallePedidoEstadoEnumPendienteElaboracion() {
		return DetallePedidoEstadoEnum.PENDIENTE_ELABORACION.getValue();
	}
	
	public int getDetallePedidoEstadoEnumPendienteEntrega() {
		return DetallePedidoEstadoEnum.PENDIENTE_ENTREGA.getValue();
	}
	
	public int getDetallePedidoEstadoEnumEnConstruccion() {
		return DetallePedidoEstadoEnum.EN_CONSTRUCCION.getValue();
	}
	
	public int getDetallePedidoEstadoEnumEntregado() {
		return DetallePedidoEstadoEnum.ENTREGADO.getValue();
	}
	
	public int getDetallePedidoEstadoEnumCancelado() {
		return DetallePedidoEstadoEnum.CANCELADO.getValue();
	}
	
	public int getPedidoEstadoEnumNuevo() {
		return PedidoEstadoEnum.NUEVO.getValue();
	}
	
	public int getPedidoEstadoEnumEntregado() {
		return PedidoEstadoEnum.ENTREGADO.getValue();
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public void setServicioPedidos(ServicioGeneric<PedidoDTO> servicioPedidos) {
		this.servicioPedidos = servicioPedidos;
	}
	
	public void setServicioClientes(ServicioGeneric<ClienteDTO> servicioClientes) {
		this.servicioClientes = servicioClientes;
	}    

	public void setServicioPresupuestos(
			ServicioGeneric<PresupuestoDTO> servicioPresupuestos) {
		this.servicioPresupuestos = servicioPresupuestos;
	}

	public void setServicioProductos(ServicioGeneric<ProductoDTO> servicioProductos) {
		this.servicioProductos = servicioProductos;
	}

	public void setServicioDetallePedidoEstado(
			ServicioGeneric<DetallePedidoEstadoDTO> servicioDetallePedidoEstado) {
		this.servicioDetallePedidoEstado = servicioDetallePedidoEstado;
	}

	public void setServicioPedidoEstado(
			ServicioGeneric<PedidoEstadoDTO> servicioPedidoEstado) {
		this.servicioPedidoEstado = servicioPedidoEstado;
	}
}
