package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.TipoValor;

/**
 * Interfaz del repository de TipoValor de AE
 * 
 * @author pmarengo
 *
 */
public interface TipoValorRepository extends CrudRepository<TipoValor, Integer> {

}
