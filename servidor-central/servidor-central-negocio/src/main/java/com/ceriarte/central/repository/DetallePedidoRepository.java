package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.DetallePedido;

/**
 * Interfaz del repository de DetallePedido
 * 
 * @author pmarengo
 *
 */
public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer> {

}
