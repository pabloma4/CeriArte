package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.PresupuestoEstado;

/**
 * Interfaz del repository de PresupuestoEstado
 * 
 * @author pmarengo
 *
 */
public interface PresupuestoEstadoRepository extends CrudRepository<PresupuestoEstado, Integer> {
	
}
