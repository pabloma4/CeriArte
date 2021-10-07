package com.ceriarte.central.converters;

import java.util.HashSet;
import java.util.Set;

import com.ceriarte.central.dominio.DetallePresupuesto;
import com.ceriarte.central.dominio.Presupuesto;
import com.ceriarte.central.dominio.dto.DetallePresupuestoDTO;
import com.ceriarte.central.dominio.dto.DetallesPresupuesto;
import com.ceriarte.central.dominio.dto.PresupuestoDTO;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

/**
 * @author pmarengo
 */
public class PresupuestoConverter {

	/**
	 * Convierte un Presupuesto en un PresupuestoDTO
	 * 
	 * @param Presupuesto
	 * @return PresupuestoDTO
	 */
	public static PresupuestoDTO toPresupuestoDTO(Presupuesto presupuesto) {
		if (presupuesto == null) {
			return null;
		} else {
			PresupuestoDTO dto = new PresupuestoDTO();
			dto.setId(presupuesto.getIdPresupuesto());
			dto.setCliente(ClienteConverter.toClienteDTO(presupuesto.getCliente()));
			dto.setPresupuestoEstado(PresupuestoEstadoConverter.toPresupuestoEstadoDTO(presupuesto.getPresupuestoEstado()));
			dto.setFechaValidoHasta(XMLGregorianCalendarConverter.asXMLGregorianCalendar(presupuesto.getFechaValidoHasta()));
			dto.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(presupuesto.getFechaCreacion()));
			dto.setObservaciones(presupuesto.getObservaciones());
			
			DetallesPresupuesto detallesPresupuesto = new DetallesPresupuesto();
			for (DetallePresupuesto detallePresupuesto : presupuesto.getDetalles()) {
				detallesPresupuesto.getDetallePresupuesto().add(DetallePresupuestoConverter.toDetallePresupuestoDTO(detallePresupuesto));
			}
			dto.setDetalles(detallesPresupuesto);
			
			return dto;
		}
	}
	
	/**
	 * Convierte un PresupuestoDTO en un Presupuesto
	 * 
	 * @param PresupuestoDTO
	 * @return Presupuesto
	 */
	public static Presupuesto toPresupuesto(PresupuestoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Presupuesto presupuesto = new Presupuesto();
			presupuesto.setIdPresupuesto(dto.getId());
			presupuesto.setCliente(ClienteConverter.toCliente(dto.getCliente()));
			presupuesto.setFechaValidoHasta(XMLGregorianCalendarConverter.asDate(dto.getFechaValidoHasta()));
			presupuesto.setPresupuestoEstado(PresupuestoEstadoConverter.toPresupuestoEstado(dto.getPresupuestoEstado()));
			presupuesto.setObservaciones(dto.getObservaciones());
			
			Set<DetallePresupuesto> detalles = new HashSet<DetallePresupuesto>();
			for (DetallePresupuestoDTO detallePresupuestoDTO : dto.getDetalles().getDetallePresupuesto()) {
				detalles.add(DetallePresupuestoConverter.toDetallePresupuesto(detallePresupuestoDTO));
			}
			presupuesto.setDetalles(detalles);
			
			return presupuesto;		
		}
	}
	
	/**
     * 
     * @param sourceDTO
     * @param targetDTO
     * 
     * Permite copiar los datos de un objeto PresupuestoDTO en otro
     * 
     * @return PresupuestoDTO
     */
	public static PresupuestoDTO copyDTO(PresupuestoDTO sourceDTO, PresupuestoDTO targetDTO) {
		if (targetDTO == null) {
    		targetDTO = new PresupuestoDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setId(sourceDTO.getId());
        	targetDTO.setCliente(sourceDTO.getCliente());
        	targetDTO.setFechaCreacion(sourceDTO.getFechaCreacion());
        	targetDTO.setFechaValidoHasta(sourceDTO.getFechaValidoHasta());
        	targetDTO.setPresupuestoEstado(sourceDTO.getPresupuestoEstado());
        	targetDTO.setDetalles(sourceDTO.getDetalles());
        	targetDTO.setObservaciones(sourceDTO.getObservaciones());
    	}
    	return targetDTO;
	}
}
