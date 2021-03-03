package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Caja;
import com.ceriarte.central.dominio.Usuario;

/**
 * Interfaz del repository de Caja
 * 
 * @author pmarengo
 *
 */
public interface CajaRepository extends CrudRepository<Caja, Integer> {

	public Caja findByUsuario(Usuario usuario);
}
