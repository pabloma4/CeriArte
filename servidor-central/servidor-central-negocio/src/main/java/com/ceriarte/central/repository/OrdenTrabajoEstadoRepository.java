package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.OrdenTrabajoEstado;

/**
 * Interfaz del repository de OrdenTrabajoEstado
 * 
 * @author pmarengo
 *
 */
public interface OrdenTrabajoEstadoRepository extends CrudRepository<OrdenTrabajoEstado, Integer> {
	
}
