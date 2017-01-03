package com.ceriarte.central.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Usuario;

/**
 * Interfaz del repository de Usuario
 * 
 * @author pmarengo
 *
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Usuario findByLoginAndBorradoIsFalse(String login);

	
	@Query(value = "SELECT u FROM Usuario u WHERE upper(u.email) = upper(?1) AND u.borrado = false")
	Usuario findByEmailAndBorradoIsFalse(String email);
	
	/**
	 * @return Usuario
	 * 
	 * Metodo que devuelve los usuarios NO borrados
	 */
	public Iterable<Usuario> findByBorradoIsFalse();
	
	/**
	 * @param idUsuario
	 * @return Usuario
	 * 
	 * Metodo que devuelve los usuarios NO borrados y que no tengan el idUsuario pasado por parámetro
	 */
	public Iterable<Usuario> findByBorradoIsFalseAndIdUsuarioNot(int idUsuario);

}
