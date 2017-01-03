package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.DetallePedidoEstado;

/**
 * Interfaz del repository de DetallePedidoEstado
 * 
 * @author pmarengo
 *
 */
public interface DetallePedidoEstadoRepository extends CrudRepository<DetallePedidoEstado, Integer> {
	
}
