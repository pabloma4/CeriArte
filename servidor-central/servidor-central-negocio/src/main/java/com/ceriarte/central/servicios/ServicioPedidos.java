package com.ceriarte.central.servicios;

import java.util.Date;
import java.util.List;

import com.ceriarte.central.dominio.dto.PedidoDTO;


/**
 * Interfaz de ServicioPedidos
 * 
 * @author pmarengo
 *
 */
public interface ServicioPedidos extends ServicioGeneric<PedidoDTO>{

	/**
	 * @param fechaCreacionDesde
	 * @param fechaCreacionHasta
	 * @param pedidoEstadoIds
	 * 
	 * @return List<PedidoDTO>
	 * 
	 * Método que devuelve un listado de objetos PedidoDTO de acuerdo a los filtros pasados por parámetro
	 */
	List<PedidoDTO> doFindByFilter(Date fechaCreacionDesde, Date fechaCreacionHasta, List<String> pedidoEstadoIds);

}
