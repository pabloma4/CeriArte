package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.ResponsabilidadIVA;
import com.ceriarte.central.dominio.dto.ResponsabilidadIVADTO;

/**
 * @author pmarengo
 */
public class ResponsabilidadIVAConverter {

	/**
	 * Convierte una ResponsabilidadIVA en una ResponsabilidadIVADTO
	 * 
	 * @param ResponsabilidadIVA
	 * @return ResponsabilidadIVADTO
	 */
	public static ResponsabilidadIVADTO toResponsabilidadIVADTO(ResponsabilidadIVA responsabilidadIVA) {
		if (responsabilidadIVA == null) {
			return null;
		} else {
			ResponsabilidadIVADTO dto = new ResponsabilidadIVADTO();
			dto.setIdResponsabilidadIVA(responsabilidadIVA.getIdResponsabilidadIVA());
			dto.setDescripcion(responsabilidadIVA.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte una ResponsabilidadIVADTO en una ResponsabilidadIVA
	 * 
	 * @param ResponsabilidadIVADTO
	 * @return ResponsabilidadIVA
	 */
	public static ResponsabilidadIVA toResponsabilidadIVA(ResponsabilidadIVADTO dto) {
		if (dto == null) {
			return null;
		} else {
			ResponsabilidadIVA responsabilidadIVA = new ResponsabilidadIVA();
			responsabilidadIVA.setIdResponsabilidadIVA(dto.getIdResponsabilidadIVA());
			responsabilidadIVA.setDescripcion(dto.getDescripcion());
			return responsabilidadIVA;		
		}
	}
}
