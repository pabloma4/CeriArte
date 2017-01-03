package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.OrdenTrabajoEstado;
import com.ceriarte.central.dominio.dto.OrdenTrabajoEstadoDTO;

/**
 * @author pmarengo
 */
public class OrdenTrabajoEstadoConverter {

	/**
	 * Convierte un OrdenTrabajoEstado en un OrdenTrabajoEstadoDTO
	 * 
	 * @param OrdenTrabajoEstado
	 * @return OrdenTrabajoEstadoDTO
	 */
	public static OrdenTrabajoEstadoDTO toOrdenTrabajoEstadoDTO(OrdenTrabajoEstado ordenTrabajoEstado) {
		if (ordenTrabajoEstado == null) {
			return null;
		} else {
			OrdenTrabajoEstadoDTO dto = new OrdenTrabajoEstadoDTO();
			dto.setId(ordenTrabajoEstado.getIdOrdenTrabajoEstado());
			dto.setNombre(ordenTrabajoEstado.getNombre());
			dto.setDescripcion(ordenTrabajoEstado.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte un OrdenTrabajoEstado en un OrdenTrabajoEstadoDTO, pero sólo con datos mínimos
	 * 
	 * @param OrdenTrabajoEstado
	 * @return OrdenTrabajoEstadoDTO
	 */
	public static OrdenTrabajoEstadoDTO toOrdenTrabajoEstadoDTOThin(OrdenTrabajoEstado ordenTrabajoEstado) {
		if (ordenTrabajoEstado == null) {
			return null;
		} else {
			OrdenTrabajoEstadoDTO dto = new OrdenTrabajoEstadoDTO();
			dto.setId(ordenTrabajoEstado.getIdOrdenTrabajoEstado());
			dto.setNombre(ordenTrabajoEstado.getNombre());
			return dto;
		}
	}
	
	/**
	 * Convierte un OrdenTrabajoEstadoDTO en un OrdenTrabajoEstado
	 * 
	 * @param OrdenTrabajoEstadoDTO
	 * @return OrdenTrabajoEstado
	 */
	public static OrdenTrabajoEstado toOrdenTrabajoEstado(OrdenTrabajoEstadoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			OrdenTrabajoEstado ordenTrabajoEstado = new OrdenTrabajoEstado();
			ordenTrabajoEstado.setIdOrdenTrabajoEstado(dto.getId());
			ordenTrabajoEstado.setNombre(dto.getNombre());
			ordenTrabajoEstado.setDescripcion(dto.getDescripcion());
			return ordenTrabajoEstado;		
		}
	}
}
