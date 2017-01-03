package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Permiso;

/**
 * Interfaz del repository de Permiso
 * 
 * @author pmarengo
 *
 */
public interface PermisoRepository extends CrudRepository<Permiso, Integer> {
	
}
