package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.DetallePedidoConverter;
import com.ceriarte.central.converters.OrdenTrabajoConverter;
import com.ceriarte.central.converters.OrdenTrabajoEstadoConverter;
import com.ceriarte.central.converters.PedidoConverter;
import com.ceriarte.central.converters.ProductoConverter;
import com.ceriarte.central.converters.UsuarioConverter;
import com.ceriarte.central.dominio.DetalleOrdenTrabajo;
import com.ceriarte.central.dominio.DetallePedido;
import com.ceriarte.central.dominio.OrdenTrabajo;
import com.ceriarte.central.dominio.OrdenTrabajoEstado;
import com.ceriarte.central.dominio.Producto;
import com.ceriarte.central.dominio.Usuario;
import com.ceriarte.central.dominio.dto.DetalleOrdenTrabajoDTO;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;
import com.ceriarte.central.dominio.dto.DetallePedidoEstadoDTO;
import com.ceriarte.central.dominio.dto.OrdenTrabajoDTO;
import com.ceriarte.central.dominio.dto.OrdenTrabajoEstadoDTO;
import com.ceriarte.central.dominio.dto.PedidoDTO;
import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.dominio.dto.UsuarioDTO;
import com.ceriarte.central.enums.DetallePedidoEstadoEnum;
import com.ceriarte.central.enums.ErrorCodeEnum;
import com.ceriarte.central.enums.OrdenTrabajoEstadoEnum;
import com.ceriarte.central.excepciones.ServidorCentralBusinessException;
import com.ceriarte.central.repository.DetalleOrdenTrabajoRepository;
import com.ceriarte.central.repository.OrdenTrabajoRepository;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioOrdenesTrabajo")
@Transactional
public class ServicioOrdenesTrabajoImpl implements ServicioOrdenesTrabajo {
	
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private OrdenTrabajoRepository ordenTrabajoRepository;

	@Autowired
	private DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;
	
	@Autowired
	private ServicioPedidos servicioPedidos;

	public OrdenTrabajoDTO doSaveOrUpdate(OrdenTrabajoDTO ordenTrabajoDTO) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Ordenes de Trabajo");
		
		DetallePedido detallePedido = null != ordenTrabajoDTO.getDetallePedido() ? DetallePedidoConverter.toDetallePedido(ordenTrabajoDTO.getDetallePedido()) : null; 
		OrdenTrabajoEstado ordenTrabajoEstado = null != ordenTrabajoDTO.getOrdenTrabajoEstado() ? OrdenTrabajoEstadoConverter.toOrdenTrabajoEstado(ordenTrabajoDTO.getOrdenTrabajoEstado()) : null; 
		Usuario creadaPor = null != ordenTrabajoDTO.getCreadaPor() ? UsuarioConverter.toUsuario(ordenTrabajoDTO.getCreadaPor()) : null; 
		Usuario asignadaA = null != ordenTrabajoDTO.getAsignadaA() ? UsuarioConverter.toUsuario(ordenTrabajoDTO.getAsignadaA()) : null; 
		Date fechaEstimadaFin = null != ordenTrabajoDTO.getFechaEstimadaFin() ? XMLGregorianCalendarConverter.asDate(ordenTrabajoDTO.getFechaEstimadaFin()) : null;
		
		// Busco la OrdenTrabajo por id, sino lo encuentro creo una nueva.
		OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findOne(ordenTrabajoDTO.getId());
		if(null != ordenTrabajo){
			ordenTrabajo.setDetallePedido(detallePedido);
			ordenTrabajo.setOrdenTrabajoEstado(ordenTrabajoEstado);
			ordenTrabajo.setAsignadaA(asignadaA);
			ordenTrabajo.setFechaModificacion(new Date());
			ordenTrabajo.setFechaEstimadaFin(fechaEstimadaFin);
		}else{
			// Creo un objeto ordenTrabajo
			ordenTrabajo = new OrdenTrabajo(creadaPor, asignadaA, ordenTrabajoEstado, detallePedido, fechaEstimadaFin);
		}
		
		for (DetalleOrdenTrabajoDTO detalleDTO : ordenTrabajoDTO.getDetalles().getDetalleOrdenTrabajo()) {
			Producto producto = ProductoConverter.toProducto(detalleDTO.getProducto());
			
			DetalleOrdenTrabajo detalle = new DetalleOrdenTrabajo(producto, detalleDTO.getCantidad(), ordenTrabajo);
			if(detalleDTO.getId() > 0){		
				Iterator<DetalleOrdenTrabajo> it= ordenTrabajo.getDetalles().iterator();
				while(it.hasNext()){
					DetalleOrdenTrabajo det= it.next();
					if(detalleDTO.getId() == det.getIdDetalleOrdenTrabajo()){
						det.setCantidad(detalleDTO.getCantidad());
						det.setUpdated(true);
						det.setProducto(producto);
					}
				}
			}else{
				ordenTrabajo.getDetalles().add(detalle);
			}
		}
		
		List<DetalleOrdenTrabajo> detallesAux = new ArrayList<DetalleOrdenTrabajo>(ordenTrabajo.getDetalles());
		// Recorro todos los detalles, sino fueron actualizados (updated = true) quiere decir que fué eliminado, entonces lo borro de la BD.
		for (DetalleOrdenTrabajo detalleOrdenTrabajo : detallesAux) {
			if(!detalleOrdenTrabajo.isUpdated()){
				ordenTrabajo.getDetalles().remove(detalleOrdenTrabajo);
				detalleOrdenTrabajoRepository.delete(detalleOrdenTrabajo);
			}
		}
		
		// Almaceno los datos de la ordenTrabajo
		ordenTrabajo = ordenTrabajoRepository.save(ordenTrabajo);
		
		// Actualizo el pedido para actualizar su Estado
		PedidoDTO pedidoDTO = PedidoConverter.toPedidoDTO(ordenTrabajo.getDetallePedido().getPedido());
		servicioPedidos.doSaveOrUpdate(pedidoDTO);
		
		logger.debug("Fin doSaveOrUpdate() del Servicio de Ordenes de Trabajo");
		return OrdenTrabajoConverter.toOrdenTrabajoDTO(ordenTrabajo);
	}
	
	@Override
	public OrdenTrabajoDTO doStart(OrdenTrabajoDTO ordenTrabajoDTO){
		logger.debug("Inicio doStart() del Servicio de Ordenes de Trabajo");
		if(ordenTrabajoDTO.getAsignadaA() == null){
			throw new ServidorCentralBusinessException(ErrorCodeEnum.ORDEN_TRABAJO_SIN_USUARIO_ASIGNADO, "Es necesario asignar un Responsable a la Orden de Trabajo");
		}
		
		OrdenTrabajoEstadoDTO ordenTrabajoEstadoDTO = new OrdenTrabajoEstadoDTO(); 
		ordenTrabajoEstadoDTO.setId(OrdenTrabajoEstadoEnum.EN_CONSTRUCCION.getValue());
		ordenTrabajoDTO.setOrdenTrabajoEstado(ordenTrabajoEstadoDTO);

		DetallePedidoDTO detallePedidoDTO = ordenTrabajoDTO.getDetallePedido();
		DetallePedidoEstadoDTO detallePedidoEstadoDTO = new DetallePedidoEstadoDTO();
		detallePedidoEstadoDTO.setId(DetallePedidoEstadoEnum.EN_CONSTRUCCION.getValue());
		detallePedidoDTO.setDetallePedidoEstado(detallePedidoEstadoDTO);
		
		ordenTrabajoDTO = this.doSaveOrUpdate(ordenTrabajoDTO);
		
		logger.debug("Se modificó el estado del detallePedido " + detallePedidoDTO.getId() + " a EN CONSTRUCCION");
		logger.debug("Fin doStart() del Servicio de Ordenes de Trabajo");
	
		return ordenTrabajoDTO;
	}
	
	@Override
	public OrdenTrabajoDTO doComplete(OrdenTrabajoDTO ordenTrabajoDTO){
		logger.debug("Inicio doStart() del Servicio de Ordenes de Trabajo");
		
		if(ordenTrabajoDTO.getAsignadaA() == null){
			throw new ServidorCentralBusinessException(ErrorCodeEnum.ORDEN_TRABAJO_SIN_USUARIO_ASIGNADO, "Es necesario asignar un Responsable a la Orden de Trabajo");
		}
		
		OrdenTrabajoEstadoDTO ordenTrabajoEstadoDTO = new OrdenTrabajoEstadoDTO(); 
		ordenTrabajoEstadoDTO.setId(OrdenTrabajoEstadoEnum.FINALIZADA.getValue());
		ordenTrabajoDTO.setOrdenTrabajoEstado(ordenTrabajoEstadoDTO);
		
		DetallePedidoDTO detallePedidoDTO = ordenTrabajoDTO.getDetallePedido();
		DetallePedidoEstadoDTO detallePedidoEstadoDTO = new DetallePedidoEstadoDTO();
		detallePedidoEstadoDTO.setId(DetallePedidoEstadoEnum.PENDIENTE_ENTREGA.getValue());
		detallePedidoDTO.setDetallePedidoEstado(detallePedidoEstadoDTO);
		
		for (DetalleOrdenTrabajoDTO detalleOrdenTrabajoDTO: ordenTrabajoDTO.getDetalles().getDetalleOrdenTrabajo()) {
			ProductoDTO producto = detalleOrdenTrabajoDTO.getProducto();
			if(producto.getStock() != null){
				producto.setStock(producto.getStock() - detalleOrdenTrabajoDTO.getCantidad());
			}
		}
		
		ordenTrabajoDTO = this.doSaveOrUpdate(ordenTrabajoDTO);
		logger.debug("Se modificó el estado del detallePedido " + detallePedidoDTO.getId() + " a PENDIENTE ENTREGA");
		logger.debug("Fin doStart() del Servicio de Ordenes de Trabajo");
	
		return ordenTrabajoDTO;
	}
	
	@Override
	public OrdenTrabajoDTO doSuspend(OrdenTrabajoDTO ordenTrabajoDTO){
		logger.debug("Inicio doSuspend() del Servicio de Ordenes de Trabajo");
		
		OrdenTrabajoEstadoDTO ordenTrabajoEstadoDTO = new OrdenTrabajoEstadoDTO(); 
		ordenTrabajoEstadoDTO.setId(OrdenTrabajoEstadoEnum.SUSPENDIDA.getValue());
		ordenTrabajoDTO.setOrdenTrabajoEstado(ordenTrabajoEstadoDTO);
		
		DetallePedidoDTO detallePedidoDTO = ordenTrabajoDTO.getDetallePedido();
		DetallePedidoEstadoDTO detallePedidoEstadoDTO = new DetallePedidoEstadoDTO();
		detallePedidoEstadoDTO.setId(DetallePedidoEstadoEnum.SUSPENDIDO.getValue());
		detallePedidoDTO.setDetallePedidoEstado(detallePedidoEstadoDTO);
		
		ordenTrabajoDTO = this.doSaveOrUpdate(ordenTrabajoDTO);

		logger.debug("Se modificó el estado del detallePedido " + detallePedidoDTO.getId() + " a SUSPENDIDO");
		logger.debug("Fin doSuspend() del Servicio de Ordenes de Trabajo");
	
		return ordenTrabajoDTO;
	}
	
	@Override
	public OrdenTrabajoDTO doCancel(OrdenTrabajoDTO ordenTrabajoDTO){
		logger.debug("Inicio doStart() del Servicio de Ordenes de Trabajo");
		
		OrdenTrabajoEstadoDTO ordenTrabajoEstadoDTO = new OrdenTrabajoEstadoDTO(); 
		ordenTrabajoEstadoDTO.setId(OrdenTrabajoEstadoEnum.CANCELADA.getValue());
		ordenTrabajoDTO.setOrdenTrabajoEstado(ordenTrabajoEstadoDTO);
		
		DetallePedidoDTO detallePedidoDTO = ordenTrabajoDTO.getDetallePedido();
		DetallePedidoEstadoDTO detallePedidoEstadoDTO = new DetallePedidoEstadoDTO();
		detallePedidoEstadoDTO.setId(DetallePedidoEstadoEnum.CANCELADO.getValue());
		detallePedidoDTO.setDetallePedidoEstado(detallePedidoEstadoDTO);
		
		for (DetalleOrdenTrabajoDTO detalleOrdenTrabajoDTO: ordenTrabajoDTO.getDetalles().getDetalleOrdenTrabajo()) {
			ProductoDTO producto = detalleOrdenTrabajoDTO.getProducto();
			if(producto.getStock() != null){
				producto.setStock(producto.getStock() - detalleOrdenTrabajoDTO.getCantidad());
			}
		}
		
		ordenTrabajoDTO = this.doSaveOrUpdate(ordenTrabajoDTO);

		logger.debug("Se modificó el estado del detallePedido " + detallePedidoDTO.getId() + " a CANCELADO");
		logger.debug("Fin doStart() del Servicio de Ordenes de Trabajo");
	
		return ordenTrabajoDTO;
	}
	
	@Override
	public List<OrdenTrabajoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Ordenes de Trabajo");
		
		List<OrdenTrabajoDTO> ordenesTrabajoDTO = new ArrayList<OrdenTrabajoDTO>();

		// Busco todos las ordenesTrabajo
		Iterable<OrdenTrabajo> ordenesTrabajo = ordenTrabajoRepository.findByBorradoIsFalse();

		Iterator<OrdenTrabajo> it = ordenesTrabajo.iterator();
		while (it.hasNext()) {
			OrdenTrabajoDTO ordenTrabajoDTO = OrdenTrabajoConverter.toOrdenTrabajoDTOThin(it.next());
			ordenesTrabajoDTO.add(ordenTrabajoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Ordenes de Trabajo");
		
		return ordenesTrabajoDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Ordenes de Trabajo");
		
		OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findOne(id);
		
		if(ordenTrabajo.getOrdenTrabajoEstado().getIdOrdenTrabajoEstado() != OrdenTrabajoEstadoEnum.NUEVA.getValue()){
			throw new ServidorCentralBusinessException("No se puede eliminar una orden de trabajo con estado distinto a CREADA");
		}
		
		ordenTrabajo.setBorrado(true);
		ordenTrabajoRepository.save(ordenTrabajo);
    	logger.debug("Se eliminó la orden de trabajo " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Ordenes de Trabajo");
	}

	@Override
	public OrdenTrabajoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Ordenes de Trabajo");
		
		// Busco la ordenTrabajo por id
		OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findOne(id);

		OrdenTrabajoDTO ordenTrabajoDTO = OrdenTrabajoConverter.toOrdenTrabajoDTO(ordenTrabajo);
		
		logger.debug("Fin doFindOne() del Servicio de Ordenes de Trabajo");
		return ordenTrabajoDTO;
	}

	@Override
	public OrdenTrabajoDTO doFindByIdDetallePedido(int idDetallePedido) {
		logger.debug("Inicio doFindByIdDetallePedido() del Servicio de Ordenes de Trabajo");
		
		// Busco la ordenTrabajo por idDetallePedido
		OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findByDetallePedidoId(idDetallePedido);

		OrdenTrabajoDTO ordenTrabajoDTO = OrdenTrabajoConverter.toOrdenTrabajoDTO(ordenTrabajo);
		
		logger.debug("Fin doFindByIdDetallePedido() del Servicio de Ordenes de Trabajo");
		return ordenTrabajoDTO;
	}
	
	@Override
	public List<OrdenTrabajoDTO> doFindByFilter(Date fechaCreacionDesde, Date fechaCreacionHasta, List<String> ordenTrabajoEstadoIds, UsuarioDTO asignadaA) {
		logger.debug("Inicio doFindByFilter() del Servicio de Ordenes de Trabajo");
		List<OrdenTrabajoDTO> ordenesTrabajoDTO = new ArrayList<OrdenTrabajoDTO>();
		
		// Si la fechaCreacionDesde viene null entonces utilizo la fecha "Desde el Inicio de los Tiempos" de java 
		fechaCreacionDesde = null != fechaCreacionDesde ? fechaCreacionDesde : new Date(0);
		// Si la fechaCreacionHasta viene null entonces utilizo la fecha actual
		fechaCreacionHasta = null != fechaCreacionHasta ? fechaCreacionHasta : new Date();
		
		// Creo el filtro ordenTrabajoEstados a partir de los id de estados recibidos por parámetro
		List<OrdenTrabajoEstado> ordenTrabajoEstados = ordenTrabajoEstadoIds != null && ordenTrabajoEstadoIds.size() > 0 ? new ArrayList<OrdenTrabajoEstado>() : null;
		for (String idOrdenTrabajoEstado : ordenTrabajoEstadoIds) {
			ordenTrabajoEstados.add(new OrdenTrabajoEstado(Integer.parseInt(idOrdenTrabajoEstado)));
		}
		
		// Creo el Filtro asignadaA de acuerdo al UsuarioDTO pasado por parámetro
		Usuario asignada = UsuarioConverter.toUsuario(asignadaA);
		
		// Busco las ordenesTrabajo que cumplen con los filtros
		Iterable<OrdenTrabajo> ordenesTrabajo = ordenTrabajoRepository.findByBorradoIsFalseAndFechaCreacionBetweenAndOrdenTrabajoEstadoInAndAsignadaA(fechaCreacionDesde, fechaCreacionHasta, ordenTrabajoEstados, asignada);

		Iterator<OrdenTrabajo> it = ordenesTrabajo.iterator();
		while (it.hasNext()) {
			OrdenTrabajoDTO ordenTrabajoDTO = OrdenTrabajoConverter.toOrdenTrabajoDTO(it.next());
			ordenesTrabajoDTO.add(ordenTrabajoDTO);
		}
		
		logger.debug("Fin doFindByFilter() del Servicio de Ordenes de Trabajo");
		return ordenesTrabajoDTO;
	}
}
