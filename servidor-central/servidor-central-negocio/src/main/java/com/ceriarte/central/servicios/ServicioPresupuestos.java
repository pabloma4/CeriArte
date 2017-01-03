package com.ceriarte.central.servicios;

import java.util.Date;
import java.util.List;

import com.ceriarte.central.dominio.dto.PresupuestoDTO;


/**
 * Interfaz de ServicioPresupuestos
 * 
 * @author pmarengo
 *
 */
public interface ServicioPresupuestos extends ServicioGeneric<PresupuestoDTO>{

	/**
	 * @param presupuestoDTO
	 * 
	 * @return PresupuestoDTO
	 * 
	 * Método que almacena los datos del presupuesto, e invoca al servicio de Pedidos para crear un nuevo pedido
	 */
	PresupuestoDTO doApprove(PresupuestoDTO presupuestoDTO);
	
	/**
	 * @param fechaCreacionDesde
	 * @param fechaCreacionHasta
	 * @param presupuestoEstadoIds
	 *  
	 * @return List<PresupuestoDTO>
	 * 
	 * Método que devuelve un listado de objetos PresupuestoDTO de acuerdo a los filtros pasados por parámetro
	 */
	List<PresupuestoDTO> doFindByFilter(Date fechaCreacionDesde, Date fechaCreacionHasta, List<String> presupuestoEstadoIds);

}
