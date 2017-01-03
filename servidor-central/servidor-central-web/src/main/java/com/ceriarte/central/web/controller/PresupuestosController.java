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

import com.ceriarte.central.dominio.dto.PresupuestoDTO;
import com.ceriarte.central.dominio.dto.PresupuestoEstadoDTO;
import com.ceriarte.central.enums.PresupuestoEstadoEnum;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.servicios.ServicioPresupuestos;
import com.ceriarte.central.web.datamodels.PresupuestosLazyDataModel;

@ManagedBean(name = "presupuestosController")
@ViewScoped
public class PresupuestosController extends AbstractController implements
		Serializable {

	private static final long serialVersionUID = -4675216483105281073L;

	private final Logger logger = LoggerFactory.getLogger(PresupuestosController.class);

	@ManagedProperty(value = "#{servicioPresupuestos}")
	private ServicioPresupuestos servicioPresupuestos;
	
	@ManagedProperty(value ="#{servicioPresupuestoEstado}")
	private ServicioGeneric<PresupuestoEstadoDTO> servicioPresupuestoEstado;

	private LazyDataModel<PresupuestoDTO> lazyModel;
	private PresupuestoDTO seleccionado;
	private List<PresupuestoDTO> presupuestos;
	private List<PresupuestoEstadoDTO> presupuestoEstados;
	
	private Date filtroFechaCreacionDesde;
	private Date filtroFechaCreacionHasta;
	private List<String> filtroPresupuestoEstados;

    @PreAuthorize("hasRole('ROLE_ADMIN_PRESUPUESTOS')")
	@PostConstruct
	public void init() {
    	filtroPresupuestoEstados = new ArrayList<String>();
    	filtroPresupuestoEstados.add(String.valueOf(PresupuestoEstadoEnum.CREADO.getValue()));
		presupuestos = this.servicioPresupuestos.doFindByFilter(filtroFechaCreacionDesde, filtroFechaCreacionHasta, filtroPresupuestoEstados);
	}

	public LazyDataModel<PresupuestoDTO> getLazyModel() {
		if (lazyModel == null || lazyModel.getRowCount() != this.getPresupuestos().size()) {
			lazyModel = new PresupuestosLazyDataModel(this.getPresupuestos());
		}
		return lazyModel;
	}

	public void onRowSelect(SelectEvent event) {
		int idPresupuesto = ((PresupuestoDTO) event.getObject()).getId();
		logger.debug("Prespuesto seleccionado: ", idPresupuesto);
		ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
		configurableNavigationHandler.performNavigation("editPresupuesto?faces-redirect=true&presupuestoId=" + idPresupuesto);
	}
	
    public void search(){
    	logger.debug("Inicio search()");
    	
    	// Invoco al servicio que me devuelve los presupuestos de acuerdo a los filtros pasados por parámetro
    	presupuestos = servicioPresupuestos.doFindByFilter(filtroFechaCreacionDesde, filtroFechaCreacionHasta, filtroPresupuestoEstados);
    	
    	logger.debug("Fin search()");
    }

	public List<PresupuestoDTO> getPresupuestos() {
		return presupuestos;
	}
	
	public List<PresupuestoEstadoDTO> getPresupuestoEstados(){
		if(presupuestoEstados == null){
			presupuestoEstados = servicioPresupuestoEstado.doFindAll();
		}
		return presupuestoEstados;
	}

	public PresupuestoDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(PresupuestoDTO seleccionado) {
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

	public List<String> getFiltroPresupuestoEstados() {
		return filtroPresupuestoEstados;
	}

	public void setFiltroPresupuestoEstados(List<String> filtroPresupuestoEstados) {
		this.filtroPresupuestoEstados = filtroPresupuestoEstados;
	}

	public void setServicioPresupuestos(ServicioPresupuestos servicioPresupuestos) {
		this.servicioPresupuestos = servicioPresupuestos;
	}

	public void setServicioPresupuestoEstado(ServicioGeneric<PresupuestoEstadoDTO> servicioPresupuestoEstado) {
		this.servicioPresupuestoEstado = servicioPresupuestoEstado;
	}

}
