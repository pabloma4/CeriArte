package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.Pais;
import com.ceriarte.central.dominio.dto.PaisDTO;

/**
 * @author Carolina Olguin
 */
public class PaisConverter {

	/**
	 * Convierte un Pais en un PaisDTO
	 * 
	 * @param Pais
	 * @return PaisDTO
	 */
	public static PaisDTO toPaisDTO(Pais pais) {
		if (pais == null) {
			return null;
		} else {
			PaisDTO dto = new PaisDTO();
			dto.setIdPais(pais.getIdPais());
			dto.setNombre(pais.getNombre());
			return dto;
		}
	}
	
	/**
	 * Convierte un PaisDTO en un Pais
	 * 
	 * @param PaisDTO
	 * @return Pais
	 */
	public static Pais toPais(PaisDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Pais pais = new Pais();
			pais.setIdPais(dto.getIdPais());
			pais.setNombre(dto.getNombre());
			return pais;		
		}
	}
}
