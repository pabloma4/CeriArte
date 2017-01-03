package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.MedioDePago;

/**
 * Interfaz del repository de MedioDePago de AE
 * 
 * @author pmarengo
 *
 */
public interface MedioDePagoRepository extends CrudRepository<MedioDePago, Integer> {

}
