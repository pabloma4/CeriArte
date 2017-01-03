package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.UnidadMedida;

/**
 * Interfaz del repository de UnidadMedida
 * 
 * @author pmarengo
 *
 */
public interface UnidadMedidaRepository extends CrudRepository<UnidadMedida, Integer> {

}
