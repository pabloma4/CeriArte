package com.ceriarte.central.web.controller;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ceriarte.central.converters.ProductoConverter;
import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.dominio.dto.UnidadMedidaDTO;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.web.datamodels.ProductosLazyDataModel;

@ManagedBean(name = "productosController")
@ViewScoped
public class ProductosController extends AbstractController implements Serializable {

	private static final long serialVersionUID = -1948400855599072861L;

	private final Logger logger = LoggerFactory.getLogger(ProductosController.class);

	@ManagedProperty(value ="#{servicioProductos}")
	private ServicioGeneric<ProductoDTO> servicioProductos;

	@ManagedProperty(value ="#{servicioUnidadesMedida}")
	private ServicioGeneric<UnidadMedidaDTO> servicioUnidadesMedida;
	
	private LazyDataModel<ProductoDTO> lazyModel;  
    private ProductoDTO seleccionado;  
    private ProductoDTO editable;  
    private List<ProductoDTO> productos;
    private List<UnidadMedidaDTO> unidadesMedida;

    @PreAuthorize("hasRole('ROLE_ADM_PRODUCTOS')")
    @PostConstruct
    public void init() {
    	productos = this.servicioProductos.doFindAll();
    }

	public LazyDataModel<ProductoDTO> getLazyModel() {
		if (lazyModel==null) {
			lazyModel = new ProductosLazyDataModel(this.getProductos());
		}
		return lazyModel;
	}

    /**
     * Prepara un nuevo DTO para cargar los datos
     */
    @PreAuthorize("hasRole('ROLE_NEW_PRODUCTO')")
    public void prepareNew(ActionEvent actionEvent) {
		logger.debug("Inicio prepareNew()");
    	RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = new ProductoDTO();
		editable.setMedida(1.0);
		logger.debug("Fin prepareNew()");
    }

    /**
     * Prepara un DTO para modificar los datos
     */
    @PreAuthorize("hasRole('ROLE_EDIT_PRODUCTO')")
    public void prepareEdit(SelectEvent event) {
		logger.debug("Inicio prepareEdit()");
    	RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = ProductoConverter.copyDTO(seleccionado, new ProductoDTO());
    	logger.debug("Fin prepareEdit()");
    }

    /**
     * Guarda un nuevo DTO o los cambios a uno existente
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_PRODUCTO','ROLE_EDIT_PRODUCTO')")
    public void save() {
		logger.debug("Inicio save()");
    	FacesMessage fMsg;
    	
    	try {
    		int id = this.servicioProductos.doSaveOrUpdate(editable).getId();
        	
    		logger.info("Producto {} guardado exitosamente", editable.getNombre());
    		fMsg = new FacesMessage(msg.getString("producto.saved"), editable.getNombre());
        	
        	if (editable.getId() <= 0) { // Es nuevo
        	    editable.setId(id);
        		productos.add(editable);
            } else { // Es modificado
        		seleccionado = ProductoConverter.copyDTO(editable, seleccionado);
        	}
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");        	
        	
    	} catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Producto -{}- ya existe!", editable.getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("producto.save.error.duplicated"), editable.getNombre());
    	} catch(Exception e){
    		logger.error("No se pudo guadar el Producto {}", editable.getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("producto.save.error"), editable.getNombre());
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:productosTable");

        logger.debug("Fin save()");
    }

    @PreAuthorize("hasRole('ROLE_DELETE_PRODUCTO')")
    public void delete() {
		logger.debug("Inicio delete()");
    	FacesMessage fMsg;

    	try{
    		this.servicioProductos.doDelete(seleccionado.getId());
    	
			fMsg = new FacesMessage(msg.getString("producto.deleted"), seleccionado.getNombre());
    		productos.remove(seleccionado);
    		seleccionado = null;
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
            RequestContext.getCurrentInstance().update("form:productosTable");
    	}catch(Exception e){
    		logger.error("No se pudo eliminar el producto {}", seleccionado.getNombre());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("producto.delete.error"), seleccionado.getNombre());
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
    }
    
    public void onUnidadMedidaChange(AjaxBehaviorEvent event) {
    	logger.debug("Unidad de Medida seleccionada");
    }
    
    public void onProductoMedidaBlur(AjaxBehaviorEvent event) {
    	logger.debug("Se modificó el tamaño del producto - Se modifica el Precio y Precio Unitario del Producto");
		if(null != editable.getMedida()){
			editable.setPrecio(editable.getPrecioUnitario() * editable.getMedida());
			editable.setPrecioUnitario(editable.getPrecio()/editable.getMedida());
		}
    }
    
    public void onProductoPrecioBlur(AjaxBehaviorEvent event) {
    	logger.debug("Se modificó el precio del producto - Se modifica el Precio Unitario del Producto");
		if(null != editable.getMedida()){
			editable.setPrecioUnitario(editable.getPrecio()/editable.getMedida());
		}
    }
    
    public void onProductoPrecioUnitarioBlur(AjaxBehaviorEvent event) {
    	logger.debug("Se modificó el precio unitario del producto - Se modifica el Precio del Producto");
		if(null != editable.getMedida()){
			editable.setPrecio(editable.getPrecioUnitario() * editable.getMedida());
		}
    }
    
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	public void setServicioProductos(ServicioGeneric<ProductoDTO> servicioProductos) {
		this.servicioProductos = servicioProductos;
	}

	public void setServicioUnidadesMedida(ServicioGeneric<UnidadMedidaDTO> servicioUnidadesMedida) {
		this.servicioUnidadesMedida = servicioUnidadesMedida;
	}
	
	public List<ProductoDTO> getProductos() {
		return productos;
	}

	public List<UnidadMedidaDTO> getUnidadesMedida() {
		if(unidadesMedida == null){
			this.unidadesMedida = this.servicioUnidadesMedida.doFindAll();
		}
		return unidadesMedida;
	}	

	public ProductoDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(ProductoDTO seleccionado) {
		this.seleccionado = seleccionado;
	}

	public ProductoDTO getEditable() {
		return editable;
	}

	public void setEditable(ProductoDTO editable) {
		this.editable = editable;
	}    
}
