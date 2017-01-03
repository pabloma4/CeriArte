package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.Localidad;
import com.ceriarte.central.dominio.dto.LocalidadDTO;

/**
 * @author pmarengo
 */
public class LocalidadConverter {

	/**
	 * Convierte una Localidad en una LocalidadDTO
	 * 
	 * @param Localidad
	 * @return LocalidadDTO
	 */
	public static LocalidadDTO toLocalidadDTO(Localidad localidad) {
		if (localidad == null) {
			return null;
		} else {
			LocalidadDTO dto = new LocalidadDTO();
			dto.setIdLocalidad(localidad.getIdLocalidad());
			dto.setNombre(localidad.getNombre());
			return dto;
		}
	}
	
	/**
	 * Convierte una LocalidadDTO en una Localidad
	 * 
	 * @param LocalidadDTO
	 * @return Localidad
	 */
	public static Localidad toLocalidad(LocalidadDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Localidad localidad = new Localidad();
			localidad.setIdLocalidad(dto.getIdLocalidad());
			localidad.setNombre(dto.getNombre());
			return localidad;		
		}
	}
}
