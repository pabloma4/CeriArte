package com.ceriarte.central.converters;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ceriarte.central.dominio.Permiso;
import com.ceriarte.central.dominio.Rol;
import com.ceriarte.central.dominio.dto.PermisoDTO;
import com.ceriarte.central.dominio.dto.Permisos;
import com.ceriarte.central.dominio.dto.RolDTO;

/**
 * @author Sebastian Cuevas
 */
public class RolConverter {
	
	/**
	 * Convierte un Rol en un RolDTO
	 * 
	 * @param Rol
	 * @return RolDTO
	 */
	public static RolDTO toRolDTO(Rol rol) {
		if (rol == null) {
			return null;
		} else {
			RolDTO dto = new RolDTO();
			dto.setIdRol(rol.getIdRol());
			dto.setNombre(rol.getNombre());
			dto.setDescripcion(rol.getDescripcion());
			
			Permisos permisos = new Permisos();
			for (Permiso permiso : rol.getPermisos()) {
				PermisoDTO permisoDto = PermisoConverter.toPermisoDTO(permiso);
				permisos.getPermiso().add(permisoDto);
			}
			dto.setPermisos(permisos);
			
			return dto;
		}
	}
	
	/**
	 * Convierte un RolDTO en un Rol
	 * 
	 * @param RolDTO
	 * @return Rol
	 */
	public static Rol toRol(RolDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Rol rol = new Rol();
			rol.setIdRol(dto.getIdRol());
			rol.setNombre(dto.getNombre());
			rol.setDescripcion(dto.getDescripcion());
			
			Set <Permiso> permisos = new HashSet<Permiso>();
			List <PermisoDTO> permisosDTO = dto.getPermisos() != null ? dto.getPermisos().getPermiso() : new ArrayList<PermisoDTO>();
			for (PermisoDTO permisoDTO : permisosDTO) {
				Permiso permiso = PermisoConverter.toPermiso(permisoDTO);
				permisos.add(permiso);
				
			}
			rol.setPermisos(permisos);
			
			return rol;		
		}
	}
	
	/**
     * Permite copiar los datos de un objeto RolDTO en otro
     * @param sourceDTO
     * @param targetDTO
     * @return
     */
    public static RolDTO copyDTO (RolDTO sourceDTO, RolDTO targetDTO) {
    	
    	if (targetDTO == null) {
    		targetDTO = new RolDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setIdRol(sourceDTO.getIdRol());
        	targetDTO.setNombre(sourceDTO.getNombre());
        	targetDTO.setDescripcion(sourceDTO.getDescripcion());
			targetDTO.setPermisos(sourceDTO.getPermisos());
    	}
    	return targetDTO;
    }
}
