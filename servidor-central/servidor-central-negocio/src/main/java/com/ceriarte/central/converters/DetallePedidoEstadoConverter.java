package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.DetallePedidoEstado;
import com.ceriarte.central.dominio.dto.DetallePedidoEstadoDTO;

/**
 * @author pmarengo
 */
public class DetallePedidoEstadoConverter {

	/**
	 * Convierte un DetallePedidoEstado en un DetallePedidoEstadoDTO
	 * 
	 * @param DetallePedidoEstado
	 * @return DetallePedidoEstadoDTO
	 */
	public static DetallePedidoEstadoDTO toDetallePedidoEstadoDTO(DetallePedidoEstado detallePedidoEstado) {
		if (detallePedidoEstado == null) {
			return null;
		} else {
			DetallePedidoEstadoDTO dto = new DetallePedidoEstadoDTO();
			dto.setId(detallePedidoEstado.getIdDetallePedidoEstado());
			dto.setNombre(detallePedidoEstado.getNombre());
			dto.setDescripcion(detallePedidoEstado.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte un DetallePedidoEstadoDTO en un DetallePedidoEstado
	 * 
	 * @param DetallePedidoEstadoDTO
	 * @return DetallePedidoEstado
	 */
	public static DetallePedidoEstado toDetallePedidoEstado(DetallePedidoEstadoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			DetallePedidoEstado detallePedidoEstado = new DetallePedidoEstado();
			detallePedidoEstado.setIdDetallePedidoEstado(dto.getId());
			detallePedidoEstado.setNombre(dto.getNombre());
			detallePedidoEstado.setDescripcion(dto.getDescripcion());
			return detallePedidoEstado;		
		}
	}
}
