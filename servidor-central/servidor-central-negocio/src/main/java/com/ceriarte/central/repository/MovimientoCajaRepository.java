package com.ceriarte.central.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.MovimientoCaja;

/**
 * Interfaz del repository de MovimientoCaja
 * 
 * @author pmarengo
 *
 */
public interface MovimientoCajaRepository extends CrudRepository<MovimientoCaja, Integer> {

	@Query(value = "SELECT m FROM MovimientoCaja m INNER JOIN m.pedido p WHERE p.idPedido = ?1")
	public Iterable<MovimientoCaja> findByIdPedido(int idPedido);
}
