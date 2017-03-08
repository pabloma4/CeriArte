package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.PagoPedidoConverter;
import com.ceriarte.central.dominio.MovimientoCaja;
import com.ceriarte.central.dominio.TipoMovimientoCaja;
import com.ceriarte.central.dominio.dto.PagoPedidoDTO;
import com.ceriarte.central.repository.MovimientoCajaRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioPagosPedido")
@Transactional
public class ServicioPagosPedidoImpl implements ServicioPagosPedido {
	
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MovimientoCajaRepository movimientoCajaRepository;
	
	public PagoPedidoDTO doSaveOrUpdate(PagoPedidoDTO pagoPedidoDto) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Pagos de Pedido");

		MovimientoCaja movimientoCaja = PagoPedidoConverter.toMovimientoCaja(pagoPedidoDto);
		movimientoCaja.setFechaHora(new Date());
		
		movimientoCaja = movimientoCajaRepository.save(movimientoCaja);
    	logger.debug("Se guardó el movimiento de caja con id " + movimientoCaja.getIdMovimientoCaja());
    	
		logger.debug("Fin doSaveOrUpdate() del Servicio de Pagos de Pedido");
		return PagoPedidoConverter.toPagoPedidoDTO(movimientoCaja);
	}
	
	@Override
	public List<PagoPedidoDTO> doFindAll( ) {		
		return null;
	}
	
	@Override
	public PagoPedidoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Pagos de Pedido");
		
		// Busco el movimientoCaja por id
		MovimientoCaja movimientoCaja = movimientoCajaRepository.findOne(id);

		PagoPedidoDTO pagoPedidoDTO =  PagoPedidoConverter.toPagoPedidoDTO(movimientoCaja);
		
		logger.debug("Fin doFindOne() del Servicio de Pagos de Pedido");
		return pagoPedidoDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Pagos de Pedido");
		
		movimientoCajaRepository.delete(id);
    	logger.debug("Se eliminó el movimientoCaja " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Pagos de Pedido");
	}

	@Override
	public List<PagoPedidoDTO> doFindByIdPedido(int idPedido) {
		logger.debug("Inicio doFindByIdPedido() del Servicio de Pagos de Pedido");
		List<PagoPedidoDTO> pagosPedidoDTO = new ArrayList<PagoPedidoDTO>();
		
		// Busco los movimientos de caja por idPedido
		Iterable<MovimientoCaja> movimientosCaja = movimientoCajaRepository.findByIdPedido(idPedido);

		Iterator<MovimientoCaja> it = movimientosCaja.iterator();
		while (it.hasNext()) {
			PagoPedidoDTO pagoPedidoDTO =  PagoPedidoConverter.toPagoPedidoDTO(it.next());
			pagosPedidoDTO.add(pagoPedidoDTO);
		}
		
		logger.debug("Fin doFindByIdPedido() del Servicio de Pagos de Pedido");
		return pagosPedidoDTO;
	}

}
