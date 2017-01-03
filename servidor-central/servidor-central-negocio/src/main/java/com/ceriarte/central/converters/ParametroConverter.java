package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.Parametro;
import com.ceriarte.central.dominio.dto.ParametroDTO;

/**
 * @author Carolina Olguin
 */
public class ParametroConverter {

	/**
	 * Convierte un Parametro en un ParametroDTO
	 * 
	 * @param Parametro
	 * @return ParametroDTO
	 */
	public static ParametroDTO toParametroDTO(Parametro parametro) {
		if (parametro == null) {
			return null;
		} else {
			ParametroDTO dto = new ParametroDTO();
			dto.setIdParametro(parametro.getIdParametro());
			dto.setClave(parametro.getClave());
			dto.setValor(parametro.getValor());
			dto.setDescripcion(parametro.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte un ParametroDTO en un Parametro
	 * 
	 * @param ParametroDTO
	 * @return Parametro
	 */
	public static Parametro toParametro(ParametroDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Parametro parametro = new Parametro();
			parametro.setIdParametro(dto.getIdParametro());
			parametro.setClave(dto.getClave());
			parametro.setValor(dto.getValor());
			parametro.setDescripcion(dto.getDescripcion());
			return parametro;		
		}
	}
}
