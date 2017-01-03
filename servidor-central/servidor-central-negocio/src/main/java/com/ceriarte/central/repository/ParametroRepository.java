package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Parametro;

/**
 * Interfaz del repository de Parametro de AE
 * 
 * @author Carolina Olguín
 *
 */
public interface ParametroRepository extends CrudRepository<Parametro, Integer> {

	/**
	 * 
	 * @param clave
	 * @return Parametro
	 */
	public Parametro findByClave(String clave);
	
}
