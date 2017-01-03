package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Localidad;

/**
 * Interfaz del repository de Localidad
 * 
 * @author pmarengo
 *
 */
public interface LocalidadRepository extends CrudRepository<Localidad, String> {

}
