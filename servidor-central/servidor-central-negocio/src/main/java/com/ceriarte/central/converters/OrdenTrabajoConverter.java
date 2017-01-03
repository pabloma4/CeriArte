package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.DetalleOrdenTrabajo;
import com.ceriarte.central.dominio.OrdenTrabajo;
import com.ceriarte.central.dominio.dto.DetallesOrdenTrabajo;
import com.ceriarte.central.dominio.dto.OrdenTrabajoDTO;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

/**
 * @author pmarengo
 */
public class OrdenTrabajoConverter {

	/**
	 * Convierte una OrdenTrabajo en un OrdenTrabajoDTO
	 * 
	 * @param OrdenTrabajo
	 * @return OrdenTrabajoDTO
	 */
	public static OrdenTrabajoDTO toOrdenTrabajoDTO(OrdenTrabajo ordenTrabajo) {
		if (ordenTrabajo == null) {
			return null;
		} else {
			OrdenTrabajoDTO dto = new OrdenTrabajoDTO();
			dto.setId(ordenTrabajo.getIdOrdenTrabajo());
			dto.setCreadaPor(UsuarioConverter.toUsuarioDTO(ordenTrabajo.getCreadaPor()));
			dto.setAsignadaA(UsuarioConverter.toUsuarioDTO(ordenTrabajo.getAsignadaA()));
			dto.setOrdenTrabajoEstado(OrdenTrabajoEstadoConverter.toOrdenTrabajoEstadoDTO(ordenTrabajo.getOrdenTrabajoEstado()));
			dto.setDetallePedido(DetallePedidoConverter.toDetallePedidoDTOThin(ordenTrabajo.getDetallePedido()));
			dto.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(ordenTrabajo.getFechaCreacion()));
			dto.setFechaEstimadaFin(XMLGregorianCalendarConverter.asXMLGregorianCalendar(ordenTrabajo.getFechaEstimadaFin()));
			
			DetallesOrdenTrabajo detallesOrdenTrabajo = new DetallesOrdenTrabajo();
			for (DetalleOrdenTrabajo detalleOrdenTrabajo : ordenTrabajo.getDetalles()) {
				detallesOrdenTrabajo.getDetalleOrdenTrabajo().add(DetalleOrdenTrabajoConverter.toDetalleOrdenTrabajoDTO(detalleOrdenTrabajo));
			}
			dto.setDetalles(detallesOrdenTrabajo);
			
			return dto;
		}
	}
	
	
	/**
	 * Convierte una OrdenTrabajo en un OrdenTrabajoDTO, pero sólo con datos mínimos
	 * 
	 * @param OrdenTrabajo
	 * @return OrdenTrabajoDTO
	 */
	public static OrdenTrabajoDTO toOrdenTrabajoDTOThin(OrdenTrabajo ordenTrabajo) {
		if (ordenTrabajo == null) {
			return null;
		} else {
			OrdenTrabajoDTO dto = new OrdenTrabajoDTO();
			dto.setId(ordenTrabajo.getIdOrdenTrabajo());
			dto.setCreadaPor(UsuarioConverter.toUsuarioDTOThin(ordenTrabajo.getCreadaPor()));
			dto.setAsignadaA(UsuarioConverter.toUsuarioDTOThin(ordenTrabajo.getAsignadaA()));
			dto.setOrdenTrabajoEstado(OrdenTrabajoEstadoConverter.toOrdenTrabajoEstadoDTOThin(ordenTrabajo.getOrdenTrabajoEstado()));
			dto.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(ordenTrabajo.getFechaCreacion()));
			dto.setFechaEstimadaFin(XMLGregorianCalendarConverter.asXMLGregorianCalendar(ordenTrabajo.getFechaEstimadaFin()));
			dto.setDetallePedido(DetallePedidoConverter.toDetallePedidoDTOThin(ordenTrabajo.getDetallePedido()));
			return dto;
		}
	}
}
