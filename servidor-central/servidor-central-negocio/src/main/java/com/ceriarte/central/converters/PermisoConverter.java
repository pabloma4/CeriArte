package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.Permiso;
import com.ceriarte.central.dominio.dto.PermisoDTO;

/**
 * @author Sebastián Cuevas
 */
public class PermisoConverter {

	/**
	 * Convierte un Permiso en un PermisoDTO
	 * 
	 * @param Permiso
	 * @return PermisoDTO
	 */
	public static PermisoDTO toPermisoDTO(Permiso permiso) {
		if (permiso == null) {
			return null;
		} else {
			PermisoDTO dto = new PermisoDTO();
			dto.setIdPermiso(permiso.getIdPermiso());
			dto.setNombre(permiso.getNombre());
			dto.setDescripcion(permiso.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte un PermisoDTO en un Permiso
	 * 
	 * @param PermisoDTO
	 * @return Permiso
	 */
	public static Permiso toPermiso(PermisoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Permiso permiso= new Permiso();
			permiso.setIdPermiso(dto.getIdPermiso());
			permiso.setNombre(dto.getNombre());
			permiso.setDescripcion(dto.getDescripcion());
			return permiso;		
		}
	}
}
