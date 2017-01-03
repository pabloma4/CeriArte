package com.ceriarte.central.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ceriarte.central.dominio.dto.OrdenTrabajoDTO;
import com.ceriarte.central.dominio.dto.OrdenTrabajoEstadoDTO;
import com.ceriarte.central.dominio.dto.UsuarioDTO;
import com.ceriarte.central.enums.OrdenTrabajoEstadoEnum;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.servicios.ServicioOrdenesTrabajo;
import com.ceriarte.central.web.datamodels.OrdenesTrabajoLazyDataModel;

@ManagedBean(name = "ordenesTrabajoController")
@ViewScoped
public class OrdenesTrabajoController extends AbstractController implements Serializable {

	private static final long serialVersionUID = -4675216329803281073L;

	private final Logger logger = LoggerFactory.getLogger(OrdenesTrabajoController.class);

	@ManagedProperty(value = "#{servicioOrdenesTrabajo}")
	private ServicioOrdenesTrabajo servicioOrdenesTrabajo;
	
	@ManagedProperty(value ="#{servicioOrdenTrabajoEstado}")
	private ServicioGeneric<OrdenTrabajoEstadoDTO> servicioOrdenTrabajoEstado;

	private LazyDataModel<OrdenTrabajoDTO> lazyModel;
	private OrdenTrabajoDTO seleccionado;
	private List<OrdenTrabajoDTO> ordenesTrabajo;
	private List<OrdenTrabajoEstadoDTO> ordenTrabajoEstados;
	private List<UsuarioDTO> usuarios;
	
	private Date filtroFechaCreacionDesde;
	private Date filtroFechaCreacionHasta;
	private List<String> filtroOrdenTrabajoEstados;
	private UsuarioDTO filtroAsignadaA;

    @PreAuthorize("hasRole('ROLE_ADM_ORDENES_TRABAJO')")
	@PostConstruct
	public void init() {
    	filtroOrdenTrabajoEstados = new ArrayList<String>();
    	filtroOrdenTrabajoEstados.add(String.valueOf(OrdenTrabajoEstadoEnum.NUEVA.getValue()));
    	filtroOrdenTrabajoEstados.add(String.valueOf(OrdenTrabajoEstadoEnum.EN_CONSTRUCCION.getValue()));
    	filtroOrdenTrabajoEstados.add(String.valueOf(OrdenTrabajoEstadoEnum.SUSPENDIDA.getValue()));
    	ordenesTrabajo = this.servicioOrdenesTrabajo.doFindByFilter(filtroFechaCreacionDesde, filtroFechaCreacionHasta, filtroOrdenTrabajoEstados, filtroAsignadaA);
	}

	public LazyDataModel<OrdenTrabajoDTO> getLazyModel() {
		if (lazyModel == null || lazyModel.getRowCount() != this.getOrdenesTrabajo().size()) {
			lazyModel = new OrdenesTrabajoLazyDataModel(this.getOrdenesTrabajo());
		}
		return lazyModel;
	}

	public void onRowSelect(SelectEvent event) {
		int idOrdenTrabajo = ((OrdenTrabajoDTO) event.getObject()).getId();
		logger.debug("Orden de Trabajo seleccionada: ", idOrdenTrabajo);
		ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
		configurableNavigationHandler.performNavigation("editOrdenTrabajo?faces-redirect=true&ordenTrabajoId=" + idOrdenTrabajo);
	}
	
	public List<OrdenTrabajoEstadoDTO> getOrdenTrabajoEstados(){
		if(ordenTrabajoEstados == null){
			ordenTrabajoEstados = servicioOrdenTrabajoEstado.doFindAll();
		}
		return ordenTrabajoEstados;
	}
	
	public List<UsuarioDTO> getUsuarios() {
		if(usuarios == null){
			this.usuarios = super.servicioUsuarios.doFindAllByUserLogged(super.getUsuarioLogged());
		}
		return usuarios;
	}
	
    public void search(){
    	logger.debug("Inicio search()");
    	
    	// Invoco al servicio que me devuelve las ordenes de trabajo de acuerdo a los filtros pasados por parámetro
    	ordenesTrabajo = this.servicioOrdenesTrabajo.doFindByFilter(filtroFechaCreacionDesde, filtroFechaCreacionHasta, filtroOrdenTrabajoEstados, filtroAsignadaA);
    	
    	logger.debug("Fin search()");
    }

	public List<OrdenTrabajoDTO> getOrdenesTrabajo() {
		return ordenesTrabajo;
	}

	public OrdenTrabajoDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(OrdenTrabajoDTO seleccionado) {
		this.seleccionado = seleccionado;
	}

	public Date getFiltroFechaCreacionDesde() {
		return filtroFechaCreacionDesde;
	}

	public void setFiltroFechaCreacionDesde(Date filtroFechaCreacionDesde) {
		this.filtroFechaCreacionDesde = filtroFechaCreacionDesde;
	}

	public Date getFiltroFechaCreacionHasta() {
		return filtroFechaCreacionHasta;
	}

	public void setFiltroFechaCreacionHasta(Date filtroFechaCreacionHasta) {
		this.filtroFechaCreacionHasta = filtroFechaCreacionHasta;
	}

	public List<String> getFiltroOrdenTrabajoEstados() {
		return filtroOrdenTrabajoEstados;
	}

	public void setFiltroOrdenTrabajoEstados(List<String> filtroOrdenTrabajoEstados) {
		this.filtroOrdenTrabajoEstados = filtroOrdenTrabajoEstados;
	}

	public UsuarioDTO getFiltroAsignadaA() {
		return filtroAsignadaA;
	}

	public void setFiltroAsignadaA(UsuarioDTO filtroAsignadaA) {
		this.filtroAsignadaA = filtroAsignadaA;
	}

	public void setServicioOrdenesTrabajo(ServicioOrdenesTrabajo servicioOrdenesTrabajo) {
		this.servicioOrdenesTrabajo = servicioOrdenesTrabajo;
	}

	public void setServicioOrdenTrabajoEstado(
			ServicioGeneric<OrdenTrabajoEstadoDTO> servicioOrdenTrabajoEstado) {
		this.servicioOrdenTrabajoEstado = servicioOrdenTrabajoEstado;
	}
}
