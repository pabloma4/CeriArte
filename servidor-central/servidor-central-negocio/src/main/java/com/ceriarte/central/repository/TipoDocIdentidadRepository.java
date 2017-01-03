package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.TipoDocIdentidad;

/**
 * Interfaz del repository de TipoDocIdentidad de AE
 * 
 * @author pmarengo
 *
 */
public interface TipoDocIdentidadRepository extends CrudRepository<TipoDocIdentidad, String> {

}
