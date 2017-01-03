package com.ceriarte.central.servicios;

import java.util.List;

import com.ceriarte.central.dominio.dto.UsuarioDTO;


/**
 * Interfaz de ServicioUsuarios
 * 
 * @author pmarengo
 *
 */
public interface ServicioUsuarios extends ServicioGeneric<UsuarioDTO>{

	/**
	 * @param username
	 * 
	 * @return UsuarioDTO
	 * 
	 * Método que busca un usuario en BD por login y devuelve un UsuarioDTO
	 */
	UsuarioDTO doFindByLogin(String login);
	
	/**
	 * @param usuarioDTO
	 * 
	 * @return List<UsuarioDTO>
	 * 
	 * Método que busca todos los usuarios a mostrarle al usuario logueado de acuerdo a los permisos que éste posee
	 */
	List<UsuarioDTO> doFindAllByUserLogged(UsuarioDTO usuarioLogged);

}
