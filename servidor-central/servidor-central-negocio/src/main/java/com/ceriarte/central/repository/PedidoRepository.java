package com.ceriarte.central.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Pedido;
import com.ceriarte.central.dominio.PedidoEstado;

/**
 * Interfaz del repository de Pedido de AE
 * 
 * @author pmarengo
 *
 */
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

	/**
	 * @return Pedido
	 * 
	 * Metodo que devuelve los pedidos NO borrados
	 */
	public Iterable<Pedido> findByBorradoIsFalse();
	
	/**
	 * @param fechaCreacionDesde
	 * @param fechaCreacionHasta
	 * @param pedidoEstados
	 * 
	 * @return Iterable<Pedido>
	 * 
	 * Metodo que devuelve los pedidos NO borrados, que la fechaCreacion se encuentra entre las pasadas por parámetro y se encuentra en alguno de los estados pasados por parámetro 
	 */
	@Query(value = "SELECT p FROM Pedido p WHERE p.borrado = false AND p.fechaCreacion BETWEEN ?1 AND ?2 AND (p.pedidoEstado IN ?3 AND ?3 IS NOT NULL)")
	public Iterable<Pedido> findByBorradoIsFalseAndFechaCreacionBetweenAndPedidoEstadoIn(Date fechaCreacionDesde, Date fechaCreacionHasta, List<PedidoEstado> pedidoEstados);
}
