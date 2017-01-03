package com.ceriarte.central.servicios;

import java.util.Date;
import java.util.List;

import com.ceriarte.central.dominio.dto.OrdenTrabajoDTO;
import com.ceriarte.central.dominio.dto.UsuarioDTO;


/**
 * Interfaz de ServicioOrdenesTrabajo
 * 
 * @author pmarengo
 *
 */
public interface ServicioOrdenesTrabajo extends ServicioGeneric<OrdenTrabajoDTO> {

	/**
	 * @param int
	 * 
	 * @return ordenTrabajoDTO
	 * 
	 * Método que busca una orden de trabajo por idDetallePedido
	 */
	OrdenTrabajoDTO doFindByIdDetallePedido(int idDetallePedido);
	
	/**
	 * @param objetoDTO
	 * 
	 * @return OrdenTrabajoDTO
	 * 
	 * Método que busca un objeto según alguno de los parámetros que se pasan en el DTO, si existe lo modifica con los datos del DTO. 
	 * Si no existe se crea un nuevo registro con dichos datos y lo devuelve. Además modifica el estado del detallePedido asociando a "EN CONSTRUCCIÓN".
	 */
	OrdenTrabajoDTO doStart(OrdenTrabajoDTO ordenTrabajoDTO);
	
	/**
	 * @param objetoDTO
	 * 
	 * @return OrdenTrabajoDTO
	 * 
	 * Método que busca un objeto según alguno de los parámetros que se pasan en el DTO, si existe lo modifica con los datos del DTO. 
	 * Si no existe se crea un nuevo registro con dichos datos y lo devuelve. Además modifica el estado del detallePedido asociando a "PENDIENTE ENTREGA".
	 */
	OrdenTrabajoDTO doComplete(OrdenTrabajoDTO ordenTrabajoDTO);

	/**
	 * @param objetoDTO
	 * 
	 * @return OrdenTrabajoDTO
	 * 
	 * Método que busca un objeto según alguno de los parámetros que se pasan en el DTO, si existe lo modifica con los datos del DTO. 
	 * Si no existe se crea un nuevo registro con dichos datos y lo devuelve. Además modifica el estado del detallePedido asociando a "SUSPENDIDO".
	 */
	OrdenTrabajoDTO doSuspend(OrdenTrabajoDTO ordenTrabajoDTO);
	
	/**
	 * @param objetoDTO
	 * 
	 * @return OrdenTrabajoDTO
	 * 
	 * Método que busca un objeto según alguno de los parámetros que se pasan en el DTO, si existe lo modifica con los datos del DTO. 
	 * Si no existe se crea un nuevo registro con dichos datos y lo devuelve. Además modifica el estado del detallePedido asociando a "CANCELADO".
	 */
	OrdenTrabajoDTO doCancel(OrdenTrabajoDTO ordenTrabajoDTO);

	/**
	 * @param fechaCreacionDesde
	 * @param fechaCreacionHasta
	 * @param ordenTrabajoEstadoIds
	 * @param asignadaA
	 *  
	 * @return List<OrdenTrabajoDTO>
	 * 
	 * Método que devuelve un listado de objetos OrdenTrabajoDTO de acuerdo a los filtros pasados por parámetro
	 */
	List<OrdenTrabajoDTO> doFindByFilter(Date fechaCreacionDesde, Date fechaCreacionHasta, List<String> ordenTrabajoEstadoIds, UsuarioDTO asignadaA);
}
