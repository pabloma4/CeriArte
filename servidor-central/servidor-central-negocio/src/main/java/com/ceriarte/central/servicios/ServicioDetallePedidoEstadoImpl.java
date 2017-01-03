package com.ceriarte.central.servicios;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.DetallePedidoEstadoConverter;
import com.ceriarte.central.dominio.DetallePedidoEstado;
import com.ceriarte.central.dominio.dto.DetallePedidoEstadoDTO;
import com.ceriarte.central.repository.DetallePedidoEstadoRepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioDetallePedidoEstado")
@Transactional
public class ServicioDetallePedidoEstadoImpl implements ServicioGeneric<DetallePedidoEstadoDTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DetallePedidoEstadoRepository detallePedidoEstadoRepository;

	@Override
	public DetallePedidoEstadoDTO doSaveOrUpdate(DetallePedidoEstadoDTO objetoDTO) {
		return null;
	}

	@Override
	public List<DetallePedidoEstadoDTO> doFindAll() {
		return null;
	}

	@Override
	public DetallePedidoEstadoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Pedido Estado");
		
		// Busco el estado del detalle de pedido por id
		DetallePedidoEstado detallePedidoEstado = detallePedidoEstadoRepository.findOne(id);

		DetallePedidoEstadoDTO pedidoEstadoDTO = DetallePedidoEstadoConverter.toDetallePedidoEstadoDTO(detallePedidoEstado);
		
		logger.debug("Fin doFindOne() del Servicio de Pedido Estado");
		return pedidoEstadoDTO;	}

	@Override
	public void doDelete(int id) {
	}


}
