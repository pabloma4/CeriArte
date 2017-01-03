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

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ceriarte.central.converters.ClienteConverter;
import com.ceriarte.central.dominio.dto.ClienteDTO;
import com.ceriarte.central.dominio.dto.LocalidadDTO;
import com.ceriarte.central.dominio.dto.ResponsabilidadIVADTO;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.web.datamodels.ClientesLazyDataModel;

@ManagedBean(name = "clientesController")
@ViewScoped
public class ClientesController extends AbstractController implements Serializable {

	private static final long serialVersionUID = -7987601930287301133L;

	private final Logger logger = LoggerFactory.getLogger(ClientesController.class);

	@ManagedProperty(value ="#{servicioClientes}")
	private ServicioGeneric<ClienteDTO> servicioClientes;

	@ManagedProperty(value ="#{servicioLocalidades}")
	private ServicioGeneric<LocalidadDTO> servicioLocalidades;
	
	@ManagedProperty(value ="#{servicioResponsabilidadIVA}")
	private ServicioGeneric<ResponsabilidadIVADTO> servicioResponsabilidadIVA;

	private LazyDataModel<ClienteDTO> lazyModel;  
    private ClienteDTO seleccionado;  
    private ClienteDTO editable;  
    private List<ClienteDTO> clientes;
    private List<LocalidadDTO> localidades;
    private List<ResponsabilidadIVADTO> responsabilidadIVAList;

    @PreAuthorize("hasRole('ROLE_ADM_CLIENTES')")
    @PostConstruct
    public void init() {
    	clientes = this.servicioClientes.doFindAll();
    }

	public LazyDataModel<ClienteDTO> getLazyModel() {
		if (lazyModel==null) {
			lazyModel = new ClientesLazyDataModel(this.getClientes());
		}
		return lazyModel;
	}

    /**
     * Prepara un nuevo DTO para cargar los datos
     */
    @PreAuthorize("hasRole('ROLE_NEW_CLIENTE')")
    public void prepareNew(ActionEvent actionEvent) {
		logger.debug("Inicio prepareNew()");
    	RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = new ClienteDTO();
		logger.debug("Fin prepareNew()");
    }

    /**
     * Prepara un DTO para modificar los datos
     */
    @PreAuthorize("hasRole('ROLE_EDIT_CLIENTE')")
    public void prepareEdit(SelectEvent event) {
		logger.debug("Inicio prepareEdit()");
    	RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = ClienteConverter.copyDTO(seleccionado, new ClienteDTO());
		logger.debug("Fin prepareEdit()");
    }

    /**
     * Guarda un nuevo DTO o los cambios a uno existente
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_CLIENTE','ROLE_EDIT_CLIENTE')")
    public void save() {
		logger.debug("Inicio save()");
    	FacesMessage fMsg;
    	
    	try {
    		int id = this.servicioClientes.doSaveOrUpdate(editable).getId();
        	
    		logger.info("Cliente {} guardado exitosamente", editable != null ? editable.getNombreCompleto() : null);
    		fMsg = new FacesMessage(msg.getString("cliente.saved"), editable != null ? editable.getNombreCompleto() : null);
        	
        	if (editable.getId() <= 0) { // Es nuevo
        	    editable.setId(id);
        		clientes.add(editable);
            } else { // Es modificado
        		seleccionado = ClienteConverter.copyDTO(editable, seleccionado);
        	}
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");        	
        	
    	} catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Cliente -{}- ya existe!", editable != null ? editable.getNombreCompleto() : null);
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("cliente.save.error.duplicated"), editable != null ? editable.getNombreCompleto() : null);
    	} catch(Exception e){
    		logger.error("No se pudo guadar el Cliente {}", editable != null ? editable.getNombreCompleto() : null);
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("cliente.save.error"), editable != null ? editable.getNombreCompleto() : null);
    	}
    	
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:clientesTable");

        logger.debug("Fin save()");
    }

    @PreAuthorize("hasRole('ROLE_DELETE_CLIENTE')")
    public void delete() {
		logger.debug("Inicio delete()");
    	FacesMessage fMsg;

    	try{
    		this.servicioClientes.doDelete(seleccionado.getId());
    	
			fMsg = new FacesMessage(msg.getString("cliente.deleted"), seleccionado != null ? seleccionado.getNombreCompleto() : null);
    		clientes.remove(seleccionado);
    		seleccionado = null;
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
            RequestContext.getCurrentInstance().update("form:clientesTable");
    	}catch(Exception e){
    		logger.error("No se pudo eliminar el cliente {}", seleccionado != null ? seleccionado.getNombreCompleto() : null);
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("cliente.delete.error"), seleccionado != null ? seleccionado.getNombreCompleto() : null);
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
    }
    
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	public void setServicioClientes(ServicioGeneric<ClienteDTO> servicioClientes) {
		this.servicioClientes = servicioClientes;
	}


	public void setServicioLocalidades(
			ServicioGeneric<LocalidadDTO> servicioLocalidades) {
		this.servicioLocalidades = servicioLocalidades;
	}

	public void setServicioResponsabilidadIVA(
			ServicioGeneric<ResponsabilidadIVADTO> servicioResponsabilidadIVA) {
		this.servicioResponsabilidadIVA = servicioResponsabilidadIVA;
	}

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public List<LocalidadDTO> getLocalidades() {
		if(localidades == null){
			this.localidades = this.servicioLocalidades.doFindAll();
		}
		return localidades;
	}	

	public List<ResponsabilidadIVADTO> getResponsabilidadIVAList() {
		if(responsabilidadIVAList == null){
			this.responsabilidadIVAList = this.servicioResponsabilidadIVA.doFindAll();
		}
		return responsabilidadIVAList;
	}
	
	public ClienteDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(ClienteDTO seleccionado) {
		this.seleccionado = seleccionado;
	}

	public ClienteDTO getEditable() {
		return editable;
	}

	public void setEditable(ClienteDTO editable) {
		this.editable = editable;
	}
    
}
