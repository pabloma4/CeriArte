package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.DetalleOrdenTrabajo;

/**
 * Interfaz del repository de DetalleOrdenTrabajo de AE
 * 
 * @author pmarengo
 *
 */
public interface DetalleOrdenTrabajoRepository extends CrudRepository<DetalleOrdenTrabajo, Integer> {

}
