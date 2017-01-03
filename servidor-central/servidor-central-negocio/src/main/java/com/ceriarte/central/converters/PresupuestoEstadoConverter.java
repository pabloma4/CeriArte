package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.PresupuestoEstado;
import com.ceriarte.central.dominio.dto.PresupuestoEstadoDTO;

/**
 * @author pmarengo
 */
public class PresupuestoEstadoConverter {

	/**
	 * Convierte un PresupuestoEstado en un PresupuestoEstadoDTO
	 * 
	 * @param PresupuestoEstado
	 * @return PresupuestoEstadoDTO
	 */
	public static PresupuestoEstadoDTO toPresupuestoEstadoDTO(PresupuestoEstado presupuestoEstado) {
		if (presupuestoEstado == null) {
			return null;
		} else {
			PresupuestoEstadoDTO dto = new PresupuestoEstadoDTO();
			dto.setId(presupuestoEstado.getIdPresupuestoEstado());
			dto.setNombre(presupuestoEstado.getNombre());
			dto.setDescripcion(presupuestoEstado.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte un PresupuestoEstadoDTO en un PresupuestoEstado
	 * 
	 * @param PresupuestoEstadoDTO
	 * @return PresupuestoEstado
	 */
	public static PresupuestoEstado toPresupuestoEstado(PresupuestoEstadoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			PresupuestoEstado presupuestoEstado = new PresupuestoEstado();
			presupuestoEstado.setIdPresupuestoEstado(dto.getId());
			presupuestoEstado.setNombre(dto.getNombre());
			presupuestoEstado.setDescripcion(dto.getDescripcion());
			return presupuestoEstado;		
		}
	}
}
