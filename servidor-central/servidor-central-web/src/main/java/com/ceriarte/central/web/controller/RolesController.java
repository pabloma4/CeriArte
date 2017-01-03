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

import com.ceriarte.central.converters.RolConverter;
import com.ceriarte.central.dominio.dto.PermisoDTO;
import com.ceriarte.central.dominio.dto.Permisos;
import com.ceriarte.central.dominio.dto.RolDTO;
import com.ceriarte.central.excepciones.ServidorCentralBusinessException;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.web.datamodels.RolesLazyDataModel;

@ManagedBean(name = "rolesController")
@ViewScoped
public class RolesController extends AbstractController implements Serializable {

	private static final long serialVersionUID = -6635290737158887598L;

	private final Logger logger = LoggerFactory.getLogger(RolesController.class);
    	
	@ManagedProperty(value ="#{servicioPermisos}")
	private ServicioGeneric<PermisoDTO> servicioPermisos;
	
	@ManagedProperty(value ="#{servicioRoles}")
	private ServicioGeneric<RolDTO> servicioRoles;

	private LazyDataModel<RolDTO> lazyModel;
    private RolDTO seleccionado;  
    private RolDTO editable;  
    private List<RolDTO> roles;
    private List<PermisoDTO> permisos;
    private Set<String> selectedPermisos;
    
    @PreAuthorize("hasRole('ROLE_ADM_ROLES')")
    @PostConstruct
    public void init() {
   		roles = this.servicioRoles.doFindAll();
    }

	public LazyDataModel<RolDTO> getLazyModel() {
		if (lazyModel==null) {
			lazyModel = new RolesLazyDataModel(this.getRoles());
		}
		return lazyModel;
	}

    /**
     * Prepara un nuevo DTO para cargar los datos
     */
    @PreAuthorize("hasRole('ROLE_NEW_ROL')")
    public void prepareNew(ActionEvent actionEvent) {
		logger.debug("Inicio prepareNew()");
		RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = new RolDTO();
    	selectedPermisos = new HashSet<String>();
		logger.debug("Fin prepareNew()");
    }

    /**
     * Prepara un DTO para modificar los datos
     */
    @PreAuthorize("hasRole('ROLE_EDIT_ROL')")
    public void prepareEdit(SelectEvent event) {
		logger.debug("Inicio prepareEdit()");
    	RequestContext.getCurrentInstance().reset("form:panelEdit");
    	editable = RolConverter.copyDTO(seleccionado, new RolDTO());
    	selectedPermisos = new HashSet<String>();
		for (PermisoDTO permiso : editable.getPermisos().getPermiso()) {
			selectedPermisos.add(String.valueOf(permiso.getIdPermiso()));
		}
		logger.debug("Fin prepareEdit()");
    }

    /**
     * Guarda un nuevo DTO o los cambios a uno existente
     */
    @PreAuthorize("hasAnyRole('ROLE_NEW_ROL','ROLE_EDIT_ROL')")
    public void save() {
		logger.debug(editable.toString());
    	logger.debug("Inicio save()");
    	FacesMessage fMsg;
    	
    	try {
    		Permisos permisos = new Permisos();
    		for (String permisoSelected : selectedPermisos) {
    			PermisoDTO permisoDTOSelected = new PermisoDTO();
    			permisoDTOSelected.setIdPermiso(Integer.parseInt(permisoSelected));
    			int idx = this.getPermisos().indexOf(permisoDTOSelected);
    			permisoDTOSelected = this.getPermisos().get(idx);
    			
				permisos.getPermiso().add(permisoDTOSelected);
			}
    		editable.setPermisos(permisos);
    		
    		logger.debug(editable.toString());
    		int id = this.servicioRoles.doSaveOrUpdate(editable).getIdRol();
    		logger.info("Rol {} guardado exitosamente", editable.getNombre());
    		fMsg = new FacesMessage(msg.getString("rol.saved"), editable.getNombre());
        	if (editable.getIdRol()==0) { // Es nuevo
        		editable.setIdRol(id);
                roles.add(editable);
                seleccionado = editable;
        	} else { // Es modificado
        		seleccionado = RolConverter.copyDTO(editable, seleccionado);
        	}
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");        	
    	} 
    	catch (org.springframework.dao.DataIntegrityViolationException e) {
    		logger.warn("Rol -{}- ya existe!", editable.getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg.getString("rol.save.error.duplicated"), editable.getNombre());
    	}
    	catch (ServidorCentralBusinessException e) {
    		logger.error("No se pudo guadar el Rol {}", editable.getNombre());
    		fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), editable.getNombre());
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
        RequestContext.getCurrentInstance().update("form:messages");
        RequestContext.getCurrentInstance().update("form:rolesTable");

        logger.debug("Fin save()");
    }
	
    @PreAuthorize("hasRole('ROLE_DELETE_ROL')")
    public void delete() throws Exception {
		logger.debug("Inicio delete()");
    	FacesMessage fMsg;

    	try {
			this.servicioRoles.doDelete(seleccionado.getIdRol());
    		fMsg = new FacesMessage(msg.getString("rol.deleted"), seleccionado.getNombre());
    		roles.remove(seleccionado);
    		seleccionado = null;
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
            RequestContext.getCurrentInstance().update("form:rolesTable");
    	} 
    	catch (Exception e){	
    		logger.error("No se pudo eliminar el Rol {}", seleccionado.getNombre());
        	fMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getString("rol.delete.error"), seleccionado.getNombre());
        	RequestContext.getCurrentInstance().execute("PF('dialogEdit').hide()");
    	}
        FacesContext.getCurrentInstance().addMessage(null, fMsg);
		logger.debug("Fin delete()");
    }
    
	public List<PermisoDTO> getPermisos() {
		if(permisos == null){
			permisos = servicioPermisos.doFindAll();
		}
		return permisos;
	}
	
	public RolDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(RolDTO seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public RolDTO getEditable() {
		return editable;
	}

	public void setEditable(RolDTO editable) {
		this.editable = editable;
	}
  
	public void setServicioPermisos(ServicioGeneric<PermisoDTO> servicioPermisos) {
		this.servicioPermisos = servicioPermisos;
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
    
	public Set<String> getSelectedPermisos() {
        return selectedPermisos;
    }

	public void setSelectedPermisos(Set<String> selectedPermisos) {
		this.selectedPermisos = selectedPermisos;
	}
	
}
