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

import com.ceriarte.central.dominio.dto.PedidoDTO;
import com.ceriarte.central.dominio.dto.PedidoEstadoDTO;
import com.ceriarte.central.enums.PedidoEstadoEnum;
import com.ceriarte.central.servicios.ServicioGeneric;
import com.ceriarte.central.servicios.ServicioPedidos;
import com.ceriarte.central.web.datamodels.PedidosLazyDataModel;

@ManagedBean(name = "pedidosController")
@ViewScoped
public class PedidosController extends AbstractController implements Serializable {

	private static final long serialVersionUID = -4675216483433281073L;

	private final Logger logger = LoggerFactory.getLogger(PedidosController.class);

	@ManagedProperty(value = "#{servicioPedidos}")
	private ServicioPedidos servicioPedidos;
	
	@ManagedProperty(value ="#{servicioPedidoEstado}")
	private ServicioGeneric<PedidoEstadoDTO> servicioPedidoEstado;

	private LazyDataModel<PedidoDTO> lazyModel;
	private PedidoDTO seleccionado;
	private List<PedidoDTO> pedidos;
	private List<PedidoEstadoDTO> pedidoEstados;
	
	private Date filtroFechaCreacionDesde;
	private Date filtroFechaCreacionHasta;
	private List<String> filtroPedidoEstados;


    @PreAuthorize("hasRole('ROLE_ADM_PEDIDOS')")
	@PostConstruct
	public void init() {
    	filtroPedidoEstados = new ArrayList<String>();
    	filtroPedidoEstados.add(String.valueOf(PedidoEstadoEnum.NUEVO.getValue()));
    	filtroPedidoEstados.add(String.valueOf(PedidoEstadoEnum.PENDIENTE_ENTREGA.getValue()));
    	filtroPedidoEstados.add(String.valueOf(PedidoEstadoEnum.ENTREGADO_PARCIAL.getValue()));
		pedidos = this.servicioPedidos.doFindByFilter(filtroFechaCreacionDesde, filtroFechaCreacionHasta, filtroPedidoEstados);
	}

	public LazyDataModel<PedidoDTO> getLazyModel() {
		if (lazyModel == null || lazyModel.getRowCount() != this.getPedidos().size()) {
			lazyModel = new PedidosLazyDataModel(this.getPedidos());
		}
		return lazyModel;
	}

	public void onRowSelect(SelectEvent event) {
		int idPedido = ((PedidoDTO) event.getObject()).getId();
		logger.debug("Pedido seleccionado: ", idPedido);
		ConfigurableNavigationHandler configurableNavigationHandler = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
		configurableNavigationHandler.performNavigation("editPedido?faces-redirect=true&pedidoId=" + idPedido);
	}
	
    public void search(){
    	logger.debug("Inicio search()");
    	
    	// Invoco al servicio que me devuelve los pedidos de acuerdo a los filtros pasados por parámetro
    	pedidos = servicioPedidos.doFindByFilter(filtroFechaCreacionDesde, filtroFechaCreacionHasta, filtroPedidoEstados);
    	
    	logger.debug("Fin search()");
    }


	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}
	
	public List<PedidoEstadoDTO> getPedidoEstados(){
		if(pedidoEstados == null){
			pedidoEstados = servicioPedidoEstado.doFindAll();
		}
		return pedidoEstados;
	}

	public PedidoDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(PedidoDTO seleccionado) {
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

	public List<String> getFiltroPedidoEstados() {
		return filtroPedidoEstados;
	}

	public void setFiltroPedidoEstados(List<String> filtroPedidoEstados) {
		this.filtroPedidoEstados = filtroPedidoEstados;
	}

	public void setServicioPedidos(ServicioPedidos servicioPedidos) {
		this.servicioPedidos = servicioPedidos;
	}

	public void setServicioPedidoEstado(
			ServicioGeneric<PedidoEstadoDTO> servicioPedidoEstado) {
		this.servicioPedidoEstado = servicioPedidoEstado;
	}


}
