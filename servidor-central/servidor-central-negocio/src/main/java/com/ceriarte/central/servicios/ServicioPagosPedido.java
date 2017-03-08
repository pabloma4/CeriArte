package com.ceriarte.central.servicios;

import java.util.List;

import com.ceriarte.central.dominio.dto.PagoPedidoDTO;


/**
 * Interfaz de ServicioPagosPedido
 * 
 * @author pmarengo
 *
 */
public interface ServicioPagosPedido extends ServicioGeneric<PagoPedidoDTO>{

	/**
	 * @param idPedido
	 * 
	 * @return List<PagoPedidoDTO>
	 * 
	 * Método que busca los Movimientos de Caja en BD por id de pedido y devuelve un List de PagoPedidoDTO
	 */
	List<PagoPedidoDTO> doFindByIdPedido(int idPedido);

}
