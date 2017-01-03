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
import com.ceriarte.central.converters.DetallePedidoEstadoConverter;
import com.ceriarte.central.converters.PedidoConverter;
import com.ceriarte.central.converters.PresupuestoConverter;
import com.ceriarte.central.converters.ProductoConverter;
import com.ceriarte.central.dominio.Cliente;
import com.ceriarte.central.dominio.DetallePedido;
import com.ceriarte.central.dominio.DetallePedidoEstado;
import com.ceriarte.central.dominio.Pedido;
import com.ceriarte.central.dominio.PedidoEstado;
import com.ceriarte.central.dominio.Presupuesto;
import com.ceriarte.central.dominio.Producto;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;
import com.ceriarte.central.dominio.dto.PedidoDTO;
import com.ceriarte.central.enums.DetallePedidoEstadoEnum;
import com.ceriarte.central.enums.PedidoEstadoEnum;
import com.ceriarte.central.excepciones.ServidorCentralBusinessException;
import com.ceriarte.central.repository.DetallePedidoRepository;
import com.ceriarte.central.repository.PedidoEstadoRepository;
import com.ceriarte.central.repository.PedidoRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioPedidos")
@Transactional
public class ServicioPedidosImpl implements ServicioPedidos {
	
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoEstadoRepository pedidoEstadoRepository;

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	@Autowired
	private ServicioProductos servicioProductos;
	
	public PedidoDTO doSaveOrUpdate(PedidoDTO pedidoDTO) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Pedidos");
		
		Cliente cliente = null != pedidoDTO.getCliente() ? ClienteConverter.toCliente(pedidoDTO.getCliente()) : null; 
		Presupuesto presupuesto = null != pedidoDTO.getPresupuesto() ? PresupuestoConverter.toPresupuesto(pedidoDTO.getPresupuesto()) : null; 

		// Busco el Pedido por id, sino lo encuentro creo uno nuevo.
		Pedido pedido = pedidoRepository.findOne(pedidoDTO.getId());
		if(null != pedido){
			pedido.setCliente(cliente);
			pedido.setPresupuesto(presupuesto);
			pedido.setFechaModificacion(new Date());
		}else{
			// Creo un objeto pedido
			pedido = new Pedido(cliente, presupuesto);
		}
		
		for (DetallePedidoDTO detalleDTO : pedidoDTO.getDetalles().getDetallePedido()) {
			Producto producto = ProductoConverter.toProducto(detalleDTO.getProducto());
			DetallePedidoEstado detallePedidoEstado = DetallePedidoEstadoConverter.toDetallePedidoEstado(detalleDTO.getDetallePedidoEstado());
			
			DetallePedido detalle = new DetallePedido(producto, detalleDTO.getMedida(), detalleDTO.getCantidad(), detalleDTO.getPrecioUnitario(), pedido, detalleDTO.getNombre(), detalleDTO.getDescripcion(), detallePedidoEstado);
			if(detalleDTO.getId() > 0){		
				Iterator<DetallePedido> it= pedido.getDetalles().iterator();
				while(it.hasNext()){
					DetallePedido det= it.next();
					if(detalleDTO.getId() == det.getIdDetallePedido()){
						// Lo que contiene éste if se agrega para bajar el stock de los productos cuando se vende un producto No Elaborado
						if(!det.getProducto().isElaborado() && det.getDetallePedidoEstado().getIdDetallePedidoEstado() != DetallePedidoEstadoEnum.ENTREGADO.getValue() && 
							detallePedidoEstado.getIdDetallePedidoEstado() == DetallePedidoEstadoEnum.ENTREGADO.getValue()){
							servicioProductos.doSaveOrUpdate(detalleDTO.getProducto());
						}
						
						det.setCantidad(detalleDTO.getCantidad());
						det.setMedida(detalleDTO.getMedida());
						det.setPrecioUnitario(detalleDTO.getPrecioUnitario());
						det.setUpdated(true);
						det.setNombre(detalleDTO.getNombre());
						det.setDescripcion(detalleDTO.getDescripcion());
						det.setDetallePedidoEstado(detallePedidoEstado);
						det.setProducto(producto);
					}
				}
			}else{
				pedido.getDetalles().add(detalle);
			}
		}
		
		List<DetallePedido> detallesAux = new ArrayList<DetallePedido>(pedido.getDetalles());
		// Recorro todos los detalles, sino fueron actualizados (updated = true) quiere decir que fué eliminado, entonces lo borro de la BD.
		for (DetallePedido detallePedido : detallesAux) {
			if(!detallePedido.isUpdated()){
				pedido.getDetalles().remove(detallePedido);
				detallePedidoRepository.delete(detallePedido);
			}
		}
		
		// Modifico el estado del pedido
		PedidoEstado pedidoEstado = pedidoEstadoRepository.findOne(this.getPedidoEstado(pedido));
		pedido.setPedidoEstado(pedidoEstado);
		
		// Almaceno los datos del pedido
		pedido = pedidoRepository.save(pedido);
		
		logger.debug("Fin doSaveOrUpdate() del Servicio de Pedidos");
		return PedidoConverter.toPedidoDTO(pedido);
	}
	
	@Override
	public List<PedidoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Pedidos");
		
		List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();

		// Busco todos los pedidos
		Iterable<Pedido> pedidos = pedidoRepository.findByBorradoIsFalse();

		Iterator<Pedido> it = pedidos.iterator();
		while (it.hasNext()) {
			PedidoDTO pedidoDTO = PedidoConverter.toPedidoDTO(it.next());
			pedidosDTO.add(pedidoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Pedidos");
		
		return pedidosDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Pedidos");
		
		Pedido pedido = pedidoRepository.findOne(id);
		
		if(pedido.getPedidoEstado().getIdPedidoEstado() != PedidoEstadoEnum.NUEVO.getValue()){
			throw new ServidorCentralBusinessException("No se puede eliminar un pedido con estado distinto a NUEVO");
		}
		
		pedido.setBorrado(true);
		pedidoRepository.save(pedido);
    	logger.debug("Se eliminó el pedido " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Pedidos");
	}

	@Override
	public PedidoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Pedidos");
		
		// Busco el pedido por id
		Pedido pedido = pedidoRepository.findOne(id);

		PedidoDTO pedidoDTO = PedidoConverter.toPedidoDTO(pedido);
		
		logger.debug("Fin doFindOne() del Servicio de Pedidos");
		return pedidoDTO;
	}

	@Override
	public List<PedidoDTO> doFindByFilter(Date fechaCreacionDesde, Date fechaCreacionHasta, List<String> pedidoEstadoIds) {
		logger.debug("Inicio doFindByFilter() del Servicio de Pedidos");
		List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
		
		// Si la fechaCreacionDesde viene null entonces utilizo la fecha "Desde el Inicio de los Tiempos" de java 
		fechaCreacionDesde = null != fechaCreacionDesde ? fechaCreacionDesde : new Date(0);
		// Si la fechaCreacionHasta viene null entonces utilizo la fecha actual
		fechaCreacionHasta = null != fechaCreacionHasta ? fechaCreacionHasta : new Date();
		
		// Creo el filtro pedidoEstados a partir de los id de estados recibidos por parámetro
		List<PedidoEstado> pedidoEstados = pedidoEstadoIds != null && pedidoEstadoIds.size() > 0 ? new ArrayList<PedidoEstado>() : null;
		for (String idPresupuestoEstado : pedidoEstadoIds) {
			pedidoEstados.add(new PedidoEstado(Integer.parseInt(idPresupuestoEstado)));
		}
		
		// Busco los pedidos que cumplen con los filtros
		Iterable<Pedido> pedidos = pedidoRepository.findByBorradoIsFalseAndFechaCreacionBetweenAndPedidoEstadoIn(fechaCreacionDesde, fechaCreacionHasta, pedidoEstados);

		Iterator<Pedido> it = pedidos.iterator();
		while (it.hasNext()) {
			PedidoDTO pedidoDTO = PedidoConverter.toPedidoDTO(it.next());
			pedidosDTO.add(pedidoDTO);
		}
		
		logger.debug("Fin doFindByFilter() del Servicio de Pedidos");
		return pedidosDTO;
	}
	
	/**
	 * @return PedidoEstadoEnum
	 * 
	 * Método que calcula el estado del pedido de acuerdo a los estados de sus detalles de pedido
	 * 
	 * */
	public int getPedidoEstado(Pedido pedido) {
		int cantEntregado = 0;
		int cantCancelado = 0;
		int cantConstruccion = 0;
		
		for (DetallePedido detallePedido : pedido.getDetalles()) {
			// Si el detalle de pedido se encuentra "En Construcción", o "Pendiente de Entrega" pero es "Elaborado, sumo el contador cantConstruccion
			if(detallePedido.getDetallePedidoEstado().getIdDetallePedidoEstado() == DetallePedidoEstadoEnum.EN_CONSTRUCCION.getValue() ||
			   (detallePedido.getDetallePedidoEstado().getIdDetallePedidoEstado() == DetallePedidoEstadoEnum.PENDIENTE_ENTREGA.getValue() 
			    && detallePedido.getProducto().isElaborado())){
				cantConstruccion ++;
			}
			
			// Si el detalle de pedido se encuentra "Entregado" sumo el contador cantEntregado
			if(detallePedido.getDetallePedidoEstado().getIdDetallePedidoEstado() == DetallePedidoEstadoEnum.ENTREGADO.getValue()){
				cantEntregado ++;
			}
			
			// Si el detalle de pedido se encuentra "Cancelado" sumo el contador cantCancelado
			if(detallePedido.getDetallePedidoEstado().getIdDetallePedidoEstado() == DetallePedidoEstadoEnum.CANCELADO.getValue()){
				cantCancelado ++;
			}
			
		}
		if(pedido.getDetalles().size() == cantCancelado){
			return PedidoEstadoEnum.CANCELADO.getValue();
		}
		
		if(pedido.getDetalles().size() == cantEntregado || cantCancelado + cantEntregado == pedido.getDetalles().size()){
			return PedidoEstadoEnum.ENTREGADO.getValue();
		}
		
		if(cantEntregado > 0){
			return PedidoEstadoEnum.ENTREGADO_PARCIAL.getValue();
		}
		
		if(cantConstruccion > 0){
			return PedidoEstadoEnum.PENDIENTE_ENTREGA.getValue();
		}
		
		return PedidoEstadoEnum.NUEVO.getValue();
	}
}
