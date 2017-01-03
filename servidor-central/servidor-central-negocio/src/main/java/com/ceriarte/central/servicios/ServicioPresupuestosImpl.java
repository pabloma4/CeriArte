package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.ClienteConverter;
import com.ceriarte.central.converters.PresupuestoConverter;
import com.ceriarte.central.converters.PresupuestoEstadoConverter;
import com.ceriarte.central.converters.ProductoConverter;
import com.ceriarte.central.dominio.Cliente;
import com.ceriarte.central.dominio.DetallePresupuesto;
import com.ceriarte.central.dominio.Presupuesto;
import com.ceriarte.central.dominio.PresupuestoEstado;
import com.ceriarte.central.dominio.Producto;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;
import com.ceriarte.central.dominio.dto.DetallePedidoEstadoDTO;
import com.ceriarte.central.dominio.dto.DetallePresupuestoDTO;
import com.ceriarte.central.dominio.dto.DetallesPedido;
import com.ceriarte.central.dominio.dto.PedidoDTO;
import com.ceriarte.central.dominio.dto.PresupuestoDTO;
import com.ceriarte.central.enums.DetallePedidoEstadoEnum;
import com.ceriarte.central.enums.PresupuestoEstadoEnum;
import com.ceriarte.central.excepciones.ServidorCentralBusinessException;
import com.ceriarte.central.repository.DetallePresupuestoRepository;
import com.ceriarte.central.repository.PresupuestoRepository;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioPresupuestos")
@Transactional
public class ServicioPresupuestosImpl implements ServicioPresupuestos{
	
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PresupuestoRepository presupuestoRepository;

	@Autowired
	private DetallePresupuestoRepository detallePresupuestoRepository;
	
	@Autowired
	private ServicioGeneric<PedidoDTO> servicioPedidos;
	
	
	@Autowired
	private ServicioGeneric<DetallePedidoEstadoDTO> servicioDetallePedidoEstado;

	public PresupuestoDTO doSaveOrUpdate(PresupuestoDTO presupuestoDTO) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Presupuestos");
		
		Date fechaValidoHasta = XMLGregorianCalendarConverter.asDate(presupuestoDTO.getFechaValidoHasta());
		Cliente cliente = null != presupuestoDTO.getCliente() ? ClienteConverter.toCliente(presupuestoDTO.getCliente()) : null; 
		PresupuestoEstado presupuestoEstado = null != presupuestoDTO.getPresupuestoEstado() ? PresupuestoEstadoConverter.toPresupuestoEstado(presupuestoDTO.getPresupuestoEstado()) : null; 
				
		// Busco el Presupuesto por id, sino lo encuentro creo uno nuevo.
		Presupuesto presupuesto = presupuestoRepository.findOne(presupuestoDTO.getId());
		if(null != presupuesto){
			presupuesto.setCliente(cliente);
			presupuesto.setFechaValidoHasta(fechaValidoHasta);
			presupuesto.setFechaModificacion(new Date());
			presupuesto.setPresupuestoEstado(presupuestoEstado);
		}else{
			// Creo un objeto prespuesto
			presupuesto = new Presupuesto(cliente, fechaValidoHasta, presupuestoEstado);
		}
		
		for (DetallePresupuestoDTO detalleDTO : presupuestoDTO.getDetalles().getDetallePresupuesto()) {
			Producto producto = ProductoConverter.toProducto(detalleDTO.getProducto());
			
			DetallePresupuesto detalle = new DetallePresupuesto(producto, detalleDTO.getCantidad(), detalleDTO.getMedida(), detalleDTO.getPrecioUnitario(), presupuesto, detalleDTO.getNombre(), detalleDTO.getDescripcion());
			if(detalleDTO.getId() > 0){		
				Iterator<DetallePresupuesto> it= presupuesto.getDetalles().iterator();
				while(it.hasNext()){
					DetallePresupuesto det= it.next();
					if(detalleDTO.getId() == det.getIdDetallePresupuesto()){
						det.setCantidad(detalleDTO.getCantidad());
						det.setMedida(detalleDTO.getMedida());
						det.setPrecioUnitario(detalleDTO.getPrecioUnitario());
						det.setUpdated(true);
						det.setNombre(detalleDTO.getNombre());
						det.setDescripcion(detalleDTO.getDescripcion());
					}
				}
			}else{
				presupuesto.getDetalles().add(detalle);
			}
		}
		
		List<DetallePresupuesto> detallesAux = new ArrayList<DetallePresupuesto>(presupuesto.getDetalles());
		// Recorro todos los detalles, sino fueron actualizados (updated = true) quiere decir que fué eliminado, entonces lo borro de la BD.
		for (DetallePresupuesto detallePresupuesto : detallesAux) {
			if(!detallePresupuesto.isUpdated()){
				presupuesto.getDetalles().remove(detallePresupuesto);
				detallePresupuestoRepository.delete(detallePresupuesto);
			}
		}
		
		// Almaceno los datos del presupuesto
		presupuesto = presupuestoRepository.save(presupuesto);
		
		logger.debug("Fin doSaveOrUpdate() del Servicio de Presupuestos");
		return PresupuestoConverter.toPresupuestoDTO(presupuesto);
	}
	
	@Override
	public List<PresupuestoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Presupuestos");
		
		List<PresupuestoDTO> presupuestosDTO = new ArrayList<PresupuestoDTO>();

		// Busco todos los presupuestos
		Iterable<Presupuesto> presupuestos = presupuestoRepository.findByBorradoIsFalse();

		Iterator<Presupuesto> it = presupuestos.iterator();
		while (it.hasNext()) {
			PresupuestoDTO presupuestoDTO = PresupuestoConverter.toPresupuestoDTO(it.next());
			presupuestosDTO.add(presupuestoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Presupuestos");
		
		return presupuestosDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Presupuestos");
		
		Presupuesto presupuesto = presupuestoRepository.findOne(id);
		
		if(presupuesto.getPresupuestoEstado().getIdPresupuestoEstado() != PresupuestoEstadoEnum.CREADO.getValue()){
			throw new ServidorCentralBusinessException("No se puede eliminar un presupuesto con estado distinto a CREADO");
		}
		
		presupuesto.setBorrado(true);
		presupuestoRepository.save(presupuesto);
    	logger.debug("Se eliminó el presupuesto " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Presupuestos");
	}

	@Override
	public PresupuestoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Presupuestos");
		
		// Busco el presupuesto por id
		Presupuesto presupuesto = presupuestoRepository.findOne(id);

		PresupuestoDTO presupuestoDTO = PresupuestoConverter.toPresupuestoDTO(presupuesto);
		
		logger.debug("Fin doFindOne() del Servicio de Presupuestos");
		return presupuestoDTO;
	}

	@Override
	public PresupuestoDTO doApprove(PresupuestoDTO presupuestoDTO) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Presupuestos");
		
		presupuestoDTO = this.doSaveOrUpdate(presupuestoDTO);
		
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setCliente(presupuestoDTO.getCliente());
		pedidoDTO.setPresupuesto(presupuestoDTO);
		
		DetallesPedido detalles = new DetallesPedido();
		for (DetallePresupuestoDTO detallePresupuestoDTO : presupuestoDTO.getDetalles().getDetallePresupuesto()) {
			DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
			detallePedidoDTO.setMedida(detallePresupuestoDTO.getMedida());
			detallePedidoDTO.setCantidad(detallePresupuestoDTO.getCantidad());
			detallePedidoDTO.setDescripcion(detallePresupuestoDTO.getDescripcion());
			detallePedidoDTO.setMonto(detallePresupuestoDTO.getMonto());
			detallePedidoDTO.setNombre(detallePresupuestoDTO.getNombre());
			detallePedidoDTO.setPrecioUnitario(detallePresupuestoDTO.getPrecioUnitario());
			detallePedidoDTO.setProducto(detallePresupuestoDTO.getProducto());
			
	    	DetallePedidoEstadoDTO detallePedidoEstadoDTO = new DetallePedidoEstadoDTO();
	    	if(detallePresupuestoDTO.getProducto().isElaborado()){
	    		detallePedidoEstadoDTO.setId(DetallePedidoEstadoEnum.PENDIENTE_ELABORACION.getValue());
	    	}else{
			    detallePedidoEstadoDTO.setId(DetallePedidoEstadoEnum.PENDIENTE_ENTREGA.getValue());
	    	}

			detallePedidoDTO.setDetallePedidoEstado(detallePedidoEstadoDTO);
			
			detalles.getDetallePedido().add(detallePedidoDTO);
		}
		pedidoDTO.setDetalles(detalles);
		
		this.servicioPedidos.doSaveOrUpdate(pedidoDTO);
		
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Presupuestos");
		return presupuestoDTO;
	}

	@Override
	public List<PresupuestoDTO> doFindByFilter(Date fechaCreacionDesde, Date fechaCreacionHasta, List<String> presupuestoEstadoIds) {
		logger.debug("Inicio doFindByFilter() del Servicio de Presupuestos");
		List<PresupuestoDTO> presupuestosDTO = new ArrayList<PresupuestoDTO>();
		
		// Si la fechaCreacionDesde viene null entonces utilizo la fecha "Desde el Inicio de los Tiempos" de java 
		fechaCreacionDesde = null != fechaCreacionDesde ? fechaCreacionDesde : new Date(0);
		// Si la fechaCreacionHasta viene null entonces utilizo la fecha actual
		fechaCreacionHasta = null != fechaCreacionHasta ? fechaCreacionHasta : new Date();
		
		// Creo el filtro presupuestoEstados a partir de los id de estados recibidos por parámetro
		List<PresupuestoEstado> presupuestoEstados = presupuestoEstadoIds != null && presupuestoEstadoIds.size() > 0 ? new ArrayList<PresupuestoEstado>() : null;
		for (String idPresupuestoEstado : presupuestoEstadoIds) {
			presupuestoEstados.add(new PresupuestoEstado(Integer.parseInt(idPresupuestoEstado)));
		}
		
		// Busco los presupuestos que cumplen con los filtros
		Iterable<Presupuesto> presupuestos = presupuestoRepository.findByBorradoIsFalseAndFechaCreacionBetweenAndPresupuestoEstadoIn(fechaCreacionDesde, fechaCreacionHasta, presupuestoEstados);

		Iterator<Presupuesto> it = presupuestos.iterator();
		while (it.hasNext()) {
			PresupuestoDTO presupuestoDTO = PresupuestoConverter.toPresupuestoDTO(it.next());
			presupuestosDTO.add(presupuestoDTO);
		}
		
		logger.debug("Fin doFindByFilter() del Servicio de Presupuestos");
		return presupuestosDTO;
	}
}
