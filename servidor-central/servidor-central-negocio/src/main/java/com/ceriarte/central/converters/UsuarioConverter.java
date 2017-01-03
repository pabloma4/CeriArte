package com.ceriarte.central.converters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;

import com.ceriarte.central.dominio.Permiso;
import com.ceriarte.central.dominio.Rol;
import com.ceriarte.central.dominio.Usuario;
import com.ceriarte.central.dominio.dto.PermisoDTO;
import com.ceriarte.central.dominio.dto.Permisos;
import com.ceriarte.central.dominio.dto.RolDTO;
import com.ceriarte.central.dominio.dto.Roles;
import com.ceriarte.central.dominio.dto.UsuarioDTO;

/**
 * @author Sebastián Cuevas
 */
public class UsuarioConverter {

	/**
	 * Convierte un Usuario en un UsuarioDTO
	 * 
	 * @param Usuario
	 * @return UsuarioDTO
	 */
	public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
		if (usuario == null) {
			return null;
		} else {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setIdUsuario(usuario.getIdUsuario());
			dto.setNombre(usuario.getNombre());
			dto.setApellido(usuario.getApellido());
			dto.setNombreCompleto(usuario.getNombreCompleto());
			dto.setChangePassword(usuario.getCambiarPwd());
			dto.setEmail(usuario.getEmail());
			dto.setLogin(usuario.getLogin());
			dto.setPassword(usuario.getPassword());
			dto.setTiempoLogin(usuario.getTiempoLogin());

			Set<PermisoDTO> permisosDTO = new HashSet<PermisoDTO>();
			Permisos permisos = new Permisos();
			Roles roles = new Roles();
			for (Rol rol : usuario.getRoles()) {
				RolDTO rolDto = RolConverter.toRolDTO(rol);
				roles.getRol().add(rolDto);
				
				for (Permiso permiso : rol.getPermisos()) {
					PermisoDTO permisoDto = PermisoConverter.toPermisoDTO(permiso);
					permisosDTO.add(permisoDto);
				}
			}
			dto.setRoles(roles);
			
			permisos.getPermiso().addAll(permisosDTO);
			dto.setPermisos(permisos);
			
			return dto;
		}
	}
	
	/**
	 * Convierte un Usuario en un UsuarioDTO, pero sólo con datos mínimos
	 * 
	 * @param Usuario
	 * @return UsuarioDTO
	 */
	public static UsuarioDTO toUsuarioDTOThin(Usuario usuario) {
		if (usuario == null) {
			return null;
		} else {
			UsuarioDTO dto = new UsuarioDTO();
			dto.setIdUsuario(usuario.getIdUsuario());
			dto.setNombre(usuario.getNombre());
			dto.setApellido(usuario.getApellido());
			dto.setNombreCompleto(usuario.getNombreCompleto());
			
			return dto;
		}
	}
	
	/**
	 * Convierte un UsuarioDTO en un Usuario
	 * 
	 * @param UsuarioDTO
	 * @return Usuario
	 */
	public static Usuario toUsuario(UsuarioDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(dto.getIdUsuario());
			usuario.setApellido(dto.getApellido());
			usuario.setCambiarPwd(dto.isChangePassword());
			usuario.setEmail(dto.getEmail());
			usuario.setLogin(dto.getLogin());
			usuario.setNombre(dto.getNombre());
			usuario.setPassword(DigestUtils.md5Hex(dto.getPassword()));
			
			usuario.setTiempoLogin(dto.getTiempoLogin());
			
			Set <Rol> roles= new HashSet<Rol>();
			List <RolDTO> rolesDTO = dto.getRoles() != null ? dto.getRoles().getRol() : new ArrayList<RolDTO>();
			for (RolDTO rolDTO : rolesDTO) {
				Rol rol = RolConverter.toRol(rolDTO);
				roles.add(rol);
				
			}
			usuario.setRoles(roles);
			
			return usuario;		
		}
	}

	/**
	 * Realiza el merge de un UsuarioDTO en un Usuario, ambos pasados por parámetros. Sólo se setea el password cuando el usuario es nuevo.
	 * 
	 * @param UsuarioDTO
	 * @return Usuario
	 */
	public static Usuario merge(Usuario usuario, UsuarioDTO dto) {
		if (dto == null) {
			return null;
		} else {
			if(null == usuario){
				usuario = new Usuario();
				usuario.setPassword(DigestUtils.md5Hex(dto.getPassword()));
			}
			
			usuario.setIdUsuario(dto.getIdUsuario());
			usuario.setApellido(dto.getApellido());
			usuario.setCambiarPwd(dto.isChangePassword());
			usuario.setEmail(dto.getEmail());
			usuario.setLogin(dto.getLogin());
			usuario.setNombre(dto.getNombre());			
			usuario.setTiempoLogin(dto.getTiempoLogin());
			
			Set <Rol> roles= new HashSet<Rol>();
			List <RolDTO> rolesDTO = dto.getRoles() != null ? dto.getRoles().getRol() : new ArrayList<RolDTO>();
			for (RolDTO rolDTO : rolesDTO) {
				Rol rol = RolConverter.toRol(rolDTO);
				roles.add(rol);
				
			}
			usuario.setRoles(roles);
		}
		return usuario;
	}

	/**
     * Permite copiar los datos de un objeto UsuarioDTO en otro
     * @param sourceDTO
     * @param targetDTO
     * @return
     */
    public static UsuarioDTO copyDTO (UsuarioDTO sourceDTO, UsuarioDTO targetDTO) {
    	
    	if (targetDTO == null) {
    		targetDTO = new UsuarioDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setIdUsuario(sourceDTO.getIdUsuario());
        	targetDTO.setNombre(sourceDTO.getNombre());
        	targetDTO.setApellido(sourceDTO.getApellido());
        	targetDTO.setChangePassword(sourceDTO.isChangePassword());
        	targetDTO.setEmail(sourceDTO.getEmail());
        	targetDTO.setLogin(sourceDTO.getLogin());
        	targetDTO.setPassword(sourceDTO.getPassword());
        	targetDTO.setTiempoLogin(sourceDTO.getTiempoLogin());
			targetDTO.setRoles(sourceDTO.getRoles());
    	}
    	return targetDTO;
    }
}
