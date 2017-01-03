package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.DetallePresupuesto;
import com.ceriarte.central.dominio.dto.DetallePresupuestoDTO;

/**
 * @author pmarengo
 */
public class DetallePresupuestoConverter {

	/**
	 * Convierte un DetallePresupuesto en un DetallePresupuestoDTO
	 * 
	 * @param DetallePresupuesto
	 * @return DetallePresupuestoDTO
	 */
	public static DetallePresupuestoDTO toDetallePresupuestoDTO(DetallePresupuesto detallePresupuesto) {
		if (detallePresupuesto == null) {
			return null;
		} else {
			DetallePresupuestoDTO dto = new DetallePresupuestoDTO();
			dto.setId(detallePresupuesto.getIdDetallePresupuesto());
			dto.setCantidad(detallePresupuesto.getCantidad());
			dto.setMedida(detallePresupuesto.getMedida());
			dto.setPrecioUnitario(detallePresupuesto.getPrecioUnitario());
			dto.setProducto(ProductoConverter.toProductoDTO(detallePresupuesto.getProducto()));
			dto.setNombre(detallePresupuesto.getNombre());
			dto.setDescripcion(detallePresupuesto.getDescripcion());
			return dto;
		}
	}
	
	/**
	 * Convierte un DetallePresupuestoDTO en un DetallePresupuesto
	 * 
	 * @param DetallePresupuestoDTO
	 * @return DetallePresupuesto
	 */
	public static DetallePresupuesto toDetallePresupuesto(DetallePresupuestoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			DetallePresupuesto detallePresupuesto = new DetallePresupuesto();
			detallePresupuesto.setIdDetallePresupuesto(dto.getId());
			detallePresupuesto.setCantidad(dto.getCantidad());
			detallePresupuesto.setMedida(dto.getMedida());
			detallePresupuesto.setPrecioUnitario(dto.getPrecioUnitario());
			detallePresupuesto.setProducto(ProductoConverter.toProducto(dto.getProducto()));
			detallePresupuesto.setNombre(dto.getNombre());
			detallePresupuesto.setDescripcion(dto.getDescripcion());
			return detallePresupuesto;		
		}
	}
	
	/**
     * 
     * @param sourceDTO
     * @param targetDTO
     * 
     * Permite copiar los datos de un objeto DetallePresupuestoDTO en otro
     * 
     * @return DetallePresupuestoDTO
     */
	public static DetallePresupuestoDTO copyDTO(DetallePresupuestoDTO sourceDTO, DetallePresupuestoDTO targetDTO) {
		if (targetDTO == null) {
    		targetDTO = new DetallePresupuestoDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setId(sourceDTO.getId());
        	targetDTO.setCantidad(sourceDTO.getCantidad());
        	targetDTO.setMedida(sourceDTO.getMedida());
        	targetDTO.setMonto(sourceDTO.getMonto());
        	targetDTO.setPrecioUnitario(sourceDTO.getPrecioUnitario());
        	targetDTO.setProducto(sourceDTO.getProducto());
    	}
    	return targetDTO;
	}
}
