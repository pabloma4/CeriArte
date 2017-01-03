package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.UnidadMedida;
import com.ceriarte.central.dominio.dto.UnidadMedidaDTO;

/**
 * @author pmarengo
 */
public class UnidadMedidaConverter {

	/**
	 * Convierte una UnidadMedida en una UnidadMedidaDTO
	 * 
	 * @param UnidadMedida
	 * @return UnidadMedidaDTO
	 */
	public static UnidadMedidaDTO toUnidadMedidaDTO(UnidadMedida unidadMedida) {
		if (unidadMedida == null) {
			return null;
		} else {
			UnidadMedidaDTO dto = new UnidadMedidaDTO();
			dto.setId(unidadMedida.getIdUnidadMedida());
			dto.setNombre(unidadMedida.getNombre());
			dto.setSimbolo(unidadMedida.getSimbolo());
			return dto;
		}
	}
	
	/**
	 * Convierte una UnidadMedidaDTO en una UnidadMedida
	 * 
	 * @param UnidadMedidaDTO
	 * @return UnidadMedida
	 */
	public static UnidadMedida toUnidadMedida(UnidadMedidaDTO dto) {
		if (dto == null) {
			return null;
		} else {
			UnidadMedida unidadMedida = new UnidadMedida();
			unidadMedida.setIdUnidadMedida(dto.getId());
			unidadMedida.setNombre(dto.getNombre());
			unidadMedida.setSimbolo(dto.getSimbolo());
			return unidadMedida;		
		}
	}
}
