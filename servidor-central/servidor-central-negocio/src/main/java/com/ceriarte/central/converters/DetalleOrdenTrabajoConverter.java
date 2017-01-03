package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.DetalleOrdenTrabajo;
import com.ceriarte.central.dominio.dto.DetalleOrdenTrabajoDTO;

/**
 * @author pmarengo
 */
public class DetalleOrdenTrabajoConverter {

	/**
	 * Convierte un DetalleOrdenTrabajo en un DetalleOrdenTrabajoDTO
	 * 
	 * @param DetalleOrdenTrabajo
	 * @return DetalleOrdenTrabajoDTO
	 */
	public static DetalleOrdenTrabajoDTO toDetalleOrdenTrabajoDTO(DetalleOrdenTrabajo detalleOrdenTrabajo) {
		if (detalleOrdenTrabajo == null) {
			return null;
		} else {
			DetalleOrdenTrabajoDTO dto = new DetalleOrdenTrabajoDTO();
			dto.setId(detalleOrdenTrabajo.getIdDetalleOrdenTrabajo());
			dto.setCantidad(detalleOrdenTrabajo.getCantidad());
			dto.setProducto(ProductoConverter.toProductoDTO(detalleOrdenTrabajo.getProducto()));
			return dto;
		}
	}
	
	/**
	 * Convierte un DetalleOrdenTrabajoDTO en un DetalleOrdenTrabajo
	 * 
	 * @param DetalleOrdenTrabajoDTO
	 * @return DetalleOrdenTrabajo
	 */
	public static DetalleOrdenTrabajo toDetalleOrdenTrabajo(DetalleOrdenTrabajoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			DetalleOrdenTrabajo detalleOrdenTrabajo = new DetalleOrdenTrabajo();
			detalleOrdenTrabajo.setIdDetalleOrdenTrabajo(dto.getId());
			detalleOrdenTrabajo.setCantidad(dto.getCantidad());
			detalleOrdenTrabajo.setProducto(ProductoConverter.toProducto(dto.getProducto()));
			return detalleOrdenTrabajo;		
		}
	}
	
	/**
     * 
     * @param sourceDTO
     * @param targetDTO
     * 
     * Permite copiar los datos de un objeto DetalleOrdenTrabajoDTO en otro
     * 
     * @return DetalleOrdenTrabajoDTO
     */
	public static DetalleOrdenTrabajoDTO copyDTO(DetalleOrdenTrabajoDTO sourceDTO, DetalleOrdenTrabajoDTO targetDTO) {
		if (targetDTO == null) {
    		targetDTO = new DetalleOrdenTrabajoDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setId(sourceDTO.getId());
        	targetDTO.setCantidad(sourceDTO.getCantidad());
        	targetDTO.setProducto(sourceDTO.getProducto());
    	}
    	return targetDTO;
	}
}
