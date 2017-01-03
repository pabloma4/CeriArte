package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.PedidoEstado;
import com.ceriarte.central.dominio.dto.PedidoEstadoDTO;

/**
 * @author pmarengo
 */
public class PedidoEstadoConverter {

	/**
	 * Convierte un PedidoEstado en un PedidoEstadoDTO
	 * 
	 * @param PedidoEstado
	 * @return PedidoEstadoDTO
	 */
	public static PedidoEstadoDTO toPedidoEstadoDTO(PedidoEstado pedidoEstado) {
		if (pedidoEstado == null) {
			return null;
		} else {
			PedidoEstadoDTO dto = new PedidoEstadoDTO();
			dto.setId(pedidoEstado.getIdPedidoEstado());
			dto.setNombre(pedidoEstado.getNombre());
			dto.setDescripcion(pedidoEstado.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte un PedidoEstadoDTO en un PedidoEstado
	 * 
	 * @param PedidoEstadoDTO
	 * @return PedidoEstado
	 */
	public static PedidoEstado toPedidoEstado(PedidoEstadoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			PedidoEstado pedidoEstado = new PedidoEstado();
			pedidoEstado.setIdPedidoEstado(dto.getId());
			pedidoEstado.setNombre(dto.getNombre());
			pedidoEstado.setDescripcion(dto.getDescripcion());
			return pedidoEstado;		
		}
	}
}
