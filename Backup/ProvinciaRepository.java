package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Provincia;

/**
 * Interfaz del repository de Provincia de AE
 * 
 * @author pmarengo
 *
 */
public interface ProvinciaRepository extends CrudRepository<Provincia, String> {

}
