package com.ceriarte.central.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Presupuesto;
import com.ceriarte.central.dominio.PresupuestoEstado;

/**
 * Interfaz del repository de Presupuesto
 * 
 * @author pmarengo
 *
 */
public interface PresupuestoRepository extends CrudRepository<Presupuesto, Integer> {

	/**
	 * @return Presupuesto
	 * 
	 * Metodo que devuelve los presupuestos NO borrados
	 */
	public Iterable<Presupuesto> findByBorradoIsFalse();

	/**
	 * @param fechaCreacionDesde
	 * @param fechaCreacionHasta
	 * @param presupuestoEstados
	 * 
	 * @return Iterable<Presupuesto>
	 * 
	 * Metodo que devuelve los presupuestos NO borrados, que la fechaCreacion se encuentra entre las pasadas por parámetro y se encuentra en alguno de los estados pasados por parámetro 
	 */
	@Query(value = "SELECT p FROM Presupuesto p WHERE p.borrado = false AND p.fechaCreacion BETWEEN ?1 AND ?2 AND (p.presupuestoEstado IN ?3 AND ?3 IS NOT NULL)")
	public Iterable<Presupuesto> findByBorradoIsFalseAndFechaCreacionBetweenAndPresupuestoEstadoIn(Date fechaCreacionDesde, Date fechaCreacionHasta, List<PresupuestoEstado> presupuestoEstados);
}
