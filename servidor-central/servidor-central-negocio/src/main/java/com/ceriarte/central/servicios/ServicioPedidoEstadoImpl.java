package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.PedidoEstadoConverter;
import com.ceriarte.central.dominio.PedidoEstado;
import com.ceriarte.central.dominio.dto.PedidoEstadoDTO;
import com.ceriarte.central.repository.PedidoEstadoRepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioPedidoEstado")
@Transactional
public class ServicioPedidoEstadoImpl implements ServicioGeneric<PedidoEstadoDTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PedidoEstadoRepository pedidoEstadoRepository;

	@Override
	public PedidoEstadoDTO doSaveOrUpdate(PedidoEstadoDTO objetoDTO) {
		return null;
	}

	@Override
	public List<PedidoEstadoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de PedidoEstado");
		
		List<PedidoEstadoDTO> pedidoEstadosDTO = new ArrayList<PedidoEstadoDTO>();

		// Busco todos los pedidoEstados
		Iterable<PedidoEstado> pedidoEstados = pedidoEstadoRepository.findAll();

		Iterator<PedidoEstado> it = pedidoEstados.iterator();
		while (it.hasNext()) {
			PedidoEstadoDTO pedidoEstadoDTO = PedidoEstadoConverter.toPedidoEstadoDTO(it.next());
			pedidoEstadosDTO.add(pedidoEstadoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de PedidoEstado");
		
		return pedidoEstadosDTO;
	}

	@Override
	public PedidoEstadoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Pedido Estado");
		
		// Busco el estado del pedido por id
		PedidoEstado pedidoEstado = pedidoEstadoRepository.findOne(id);

		PedidoEstadoDTO pedidoEstadoDTO = PedidoEstadoConverter.toPedidoEstadoDTO(pedidoEstado);
		
		logger.debug("Fin doFindOne() del Servicio de Pedido Estado");
		return pedidoEstadoDTO;	}

	@Override
	public void doDelete(int id) {
	}


}
