package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.PedidoEstado;

/**
 * Interfaz del repository de PedidoEstado
 * 
 * @author pmarengo
 *
 */
public interface PedidoEstadoRepository extends CrudRepository<PedidoEstado, Integer> {
	
}
