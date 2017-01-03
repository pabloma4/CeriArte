package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.DetallePresupuesto;

/**
 * Interfaz del repository de DetallePresupuesto
 * 
 * @author pmarengo
 *
 */
public interface DetallePresupuestoRepository extends CrudRepository<DetallePresupuesto, Integer> {

}
