package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.Provincia;
import com.ceriarte.central.dominio.dto.ProvinciaDTO;

/**
 * @author Carolina Olguin
 */
public class ProvinciaConverter {

	/**
	 * Convierte una Provincia en una ProvinciaDTO
	 * 
	 * @param Provincia
	 * @return ProvinciaDTO
	 */
	public static ProvinciaDTO toProvinciaDTO(Provincia provincia) {
		if (provincia == null) {
			return null;
		} else {
			ProvinciaDTO dto = new ProvinciaDTO();
			dto.setIdProvincia(provincia.getIdProvincia());
			dto.setNombre(provincia.getNombre());
			dto.setPais(PaisConverter.toPaisDTO(provincia.getPais()));
			return dto;
		}
	}
	
	/**
	 * Convierte una ProvinciaDTO en una Provincia
	 * 
	 * @param ProvinciaDTO
	 * @return Provincia
	 */
	public static Provincia toProvincia(ProvinciaDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Provincia provincia = new Provincia();
			provincia.setIdProvincia(dto.getIdProvincia());
			provincia.setNombre(dto.getNombre());
			provincia.setPais(PaisConverter.toPais(dto.getPais()));
			return provincia;		
		}
	}
}
