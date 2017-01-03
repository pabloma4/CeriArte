package com.ceriarte.central.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.OrdenTrabajo;
import com.ceriarte.central.dominio.OrdenTrabajoEstado;
import com.ceriarte.central.dominio.Usuario;

/**
 * Interfaz del repository de OrdenTrabajo de AE
 * 
 * @author pmarengo
 *
 */
public interface OrdenTrabajoRepository extends CrudRepository<OrdenTrabajo, Integer> {

	/**
	 * @return Iterable<OrdenTrabajo>
	 * 
	 * Metodo que devuelve las ordenes de trabajo NO borradas
	 */
	public Iterable<OrdenTrabajo> findByBorradoIsFalse();
	
	/**
	 * @return Iterable<OrdenTrabajo>
	 * 
	 * Metodo que devuelve las ordenes de trabajo NO borradas
	 */
	@Query(value = "SELECT o FROM OrdenTrabajo o INNER JOIN o.detallePedido d WHERE d.idDetallePedido = ?1")
	public OrdenTrabajo findByDetallePedidoId(int idDetallePedido);
	
	/**
	 * @param fechaCreacionDesde
	 * @param fechaCreacionHasta
	 * @param ordenTrabajoEstados
	 * @param asignadaA
	 * 
	 * @return Iterable<OrdenTrabajo>
	 * 
	 * Metodo que devuelve las ordenes de trabajo NO borradas, que la fechaCreacion se encuentra entre las pasadas por parámetro, se encuentra en alguno de los estados pasados por parámetro
	 * y fué asignada al usuario pasado por parámetro 
	 */
	@Query(value = "SELECT o FROM OrdenTrabajo o WHERE o.borrado = false AND o.fechaCreacion BETWEEN ?1 AND ?2 AND (o.ordenTrabajoEstado IN ?3 AND ?3 IS NOT NULL) AND (o.asignadaA = ?4 OR ?4 IS NULL)")
	public Iterable<OrdenTrabajo> findByBorradoIsFalseAndFechaCreacionBetweenAndOrdenTrabajoEstadoInAndAsignadaA(Date fechaCreacionDesde, Date fechaCreacionHasta, List<OrdenTrabajoEstado> ordenTrabajoEstados, Usuario asignadaA);
}
