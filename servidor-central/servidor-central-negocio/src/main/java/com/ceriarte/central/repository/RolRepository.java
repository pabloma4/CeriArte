package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Rol;

/**
 * Interfaz del repository de Rol
 * 
 * @author pmarengo
 *
 */
public interface RolRepository extends CrudRepository<Rol, Integer> {
	
}
