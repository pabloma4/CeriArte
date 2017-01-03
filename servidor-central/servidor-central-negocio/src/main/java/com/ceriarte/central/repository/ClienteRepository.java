package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Cliente;

/**
 * Interfaz del repository de Cliente
 * 
 * @author pmarengo
 *
 */
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {


	/**
	 * @param email
	 * @return Email
	 * 
	 * Metodo que busca un cliente por email, si lo encuentra lo devuelve. 
	 */
	public Cliente findByEmail(String email);
	
	/**
	 * @return Cliente
	 * 
	 * Metodo que devuelve los clientes NO borrados
	 */
	public Iterable<Cliente> findByBorradoIsFalse();
}
