package com.ceriarte.central.web.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.ceriarte.central.converters.UsuarioConverter;
import com.ceriarte.central.dominio.dto.RolDTO;
import com.ceriarte.central.dominio.dto.Roles;
import com.ceriarte.central.dominio.dto.UsuarioDTO;
import com.ceriarte.central.excepciones.ServidorCentralBusinessException;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.servicios.ServicioUsuarios;
import com.ceriarte.central.web.datamodels.UsuariosLazyDataModel;

@ManagedBean(name = "usuariosController")
@ViewScoped
public class UsuariosController extends AbstractController implements Serializable {

	private static final long serialVersionUID = -6635677737158887598L;

	private final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
    
	@ManagedProperty(value ="#{servicioUsuarios}")
	private ServicioUsuarios servicioUsuarios;
	
	@ManagedProperty(value ="#{servicioRoles}")
	private ServicioGeneric<RolDTO> servicioRoles;

	private LazyDataModel<UsuarioDTO> lazyModel;
    private UsuarioDTO seleccionado;  
    private UsuarioDTO editable;  
    private List<UsuarioDTO> usuarios;
    private List<RolDTO> roles;
    private Set<String> selectedRoles;
    
    @PreAuthorize("hasRole('ROLE_ADM_USUARIOS')")
    @PostConstruct
    public void init() {
   		usuarios = super.servicioUsuarios.doFindAllByUserLogged(super.getUsuarioLogged());
    }

    public LazyDataModel<UsuarioDTO> getLazyModel() {
		if (lazyModel==null) {
			lazyModel = new UsuariosLazyDataModel(this.getUsuarios());
		}
		return lazyModel;
	}

    /**
     * Prepara un nuevo DTO para cargar los datos
     */
    @PreAuthorize("hasRole('ROLE_NEW_USUARIO')")
    public void prepareNew(ActionEvent actionEvent) {
		logger.debug("Inicio prepareNew()");
		RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = new UsuarioDTO();
    	selectedRoles = new HashSet<String>();
		logger.debug("Fin prepareNew()");
    }

    /**
     * Prepara un DTO para modificar los datos
     */
    @PreAuthorize("hasRole('ROLE_EDIT_USUARIO')")
    public void prepareEdit(SelectEvent event) {
		logger.debug("Inicio prepareEdit()");
    	RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = UsuarioConverter.copyDTO(seleccionado, new UsuarioDTO());
    	selectedRoles = new HashSet<String>();
		for (RolDTO rol : editable.getRoles().getRol()) {
			selectedRoles.add(String.valueOf(rol.getIdRol()));
		}
		logger.debug("Fin prepareEdit()");
    }

    /**
     * Guarda un nuevo DTO o los cambios a uno existente
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_USUARIO','ROLE_EDIT_USUARIO')")
    public void save() {
		logger.debug(editable.toString());
    	logger.debug("Inicio save()");
    	FacesMessage fMsg;
    	
    	try {
    		editable.setTiempoLogin(0);
    		
    		Roles roles = new Roles();
    		for (String rolSelected : selectedRoles) {
    			RolDTO rolDTOSelected = new RolDTO();
    			rolDTOSelected.setIdRol(Integer.parseInt(rolSelected));
    			int idx = this.getRoles().indexOf(rolDTOSelected);
    			rolDTOSelected = this.getRoles().get(idx);
    			
				roles.getRol().add(rolDTOSelected);
			}
    		editable.setRoles(roles);
    		
    		logger.debug(editable.toString());
    		int id = super.servicioUsuarios.doSaveOrUpdate(editable).getIdUsuario();
    		logger.info("Usuario {} guardado exitosamente", editable.getLogin());
    		fMsg = new FacesMessage(msg.getString("usuario.saved"), editable.getLogin());
        	if (editable.getIdUsuario()==0) { // Es nueva
        		editable.setIdUsuario(id);
                usuarios.add(editable);
                seleccionado = editable;
        	} else { // Es modificada
        		seleccionado = UsuarioConverter.copyDTO(editable, seleccionado);
        	}
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");        	
    	} 
    	catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Usuario -{}- ya existe!", editable.getLogin());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("usuario.save.error.duplicated"), editable.getLogin());
    	}
    	catch (ServidorCentralBusinessException e) {
    		logger.error("No se pudo guadar el Usuario {}", editable.getLogin());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), editable.getLogin());
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:usuariosTable");

        logger.debug("Fin save()");
    }
	
    @PreAuthorize("hasRole('ROLE_DELETE_USUARIO')")
    public void delete() throws Exception {
		logger.debug("Inicio delete()");
    	FacesMessage fMsg;

    	try {
			super.servicioUsuarios.doDelete(seleccionado.getIdUsuario());
    		fMsg = new FacesMessage(msg.getString("usuario.deleted"), seleccionado.getLogin());
    		usuarios.remove(seleccionado);
    		seleccionado = null;
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
            RequestContext.getCurrentInstance().update("form:usuariosTable");
    	} 
    	catch (Exception e){	
    		logger.error("No se pudo eliminar el Usuario {}", seleccionado.getLogin());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("usuario.delete.error"), seleccionado.getLogin());
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
    }
    
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}
	
	public UsuarioDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(UsuarioDTO seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public UsuarioDTO getEditable() {
		return editable;
	}

	public void setEditable(UsuarioDTO editable) {
		this.editable = editable;
	}

	public void setServicioRoles(ServicioGeneric<RolDTO> servicioRoles) {
		this.servicioRoles = servicioRoles;
	}
	
	public List<RolDTO> getRoles() {
		if(roles == null){
			return servicioRoles.doFindAll();
		}
        return roles;
    }	
    
	public Set<String> getSelectedRoles() {
        return selectedRoles;
    }

	public void setSelectedRoles(Set<String> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
}
