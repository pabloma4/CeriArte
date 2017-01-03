package com.ceriarte.central.servicios;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.DetallePedidoConverter;
import com.ceriarte.central.converters.DetallePedidoEstadoConverter;
import com.ceriarte.central.dominio.DetallePedido;
import com.ceriarte.central.dominio.DetallePedidoEstado;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;
import com.ceriarte.central.repository.DetallePedidoRepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioDetallePedido")
@Transactional
public class ServicioDetallePedidoImpl implements ServicioGeneric<DetallePedidoDTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	@Override
	public DetallePedidoDTO doSaveOrUpdate(DetallePedidoDTO detallePedidoDTO) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Detalles de Pedido");
		
		DetallePedidoEstado detallePedidoEstado = null != detallePedidoDTO.getDetallePedidoEstado() ? DetallePedidoEstadoConverter.toDetallePedidoEstado(detallePedidoDTO.getDetallePedidoEstado()) : null; 
		
		// Busco el DetallePedido por id, éste método no crea un nuevo detallePedido, por el momento sólo modifica el estado.
		DetallePedido detallePedido = detallePedidoRepository.findOne(detallePedidoDTO.getId());
		if(null != detallePedido){
			detallePedido.setDetallePedidoEstado(detallePedidoEstado);
		}
		
		// Almaceno los datos del DetallePedido
		detallePedido = detallePedidoRepository.save(detallePedido);
		
		logger.debug("Fin doSaveOrUpdate() del Servicio de Detalles de Pedido");
		return DetallePedidoConverter.toDetallePedidoDTO(detallePedido);
	}

	@Override
	public List<DetallePedidoDTO> doFindAll() {
		return null;
	}

	@Override
	public DetallePedidoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Detalle de Pedido");
		
		// Busco el detalle de pedido por id
		DetallePedido detallePedido = detallePedidoRepository.findOne(id);

		DetallePedidoDTO detallePedidoDTO = DetallePedidoConverter.toDetallePedidoDTO(detallePedido);
		
		logger.debug("Fin doFindOne() del Servicio de Detalle de Pedido");
		return detallePedidoDTO;	}

	@Override
	public void doDelete(int id) {
	}


}
