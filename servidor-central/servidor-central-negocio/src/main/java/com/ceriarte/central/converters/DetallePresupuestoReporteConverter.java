package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.dto.DetallePresupuestoDTO;
import com.ceriarte.central.dominio.dto.DetallePresupuestoReporteDTO;

/**
 * @author pmarengo
 */
public class DetallePresupuestoReporteConverter {

	/**
	 * Convierte un DetallePresupuestoDTO en un DetallePresupuestoReporteDTO
	 * 
	 * @param DetallePresupuestoDTO
	 * @return DetallePresupuestoReporteDTO
	 */
	public static DetallePresupuestoReporteDTO toDetallePresupuestoReporteDTO(DetallePresupuestoDTO detallePresupuestoDTO) {
		if (detallePresupuestoDTO == null) {
			return null;
		} else {
			DetallePresupuestoReporteDTO dto = new DetallePresupuestoReporteDTO();
			dto.setId(detallePresupuestoDTO.getId());
			dto.setCantidad(detallePresupuestoDTO.getCantidad());
			dto.setMedida(String.valueOf(detallePresupuestoDTO.getMedida()) + " ("+detallePresupuestoDTO.getProducto().getUnidadMedida().getSimbolo()+")");
			dto.setPrecioUnitario(detallePresupuestoDTO.getPrecioUnitario());
			dto.setMonto(detallePresupuestoDTO.getCantidad() * detallePresupuestoDTO.getMedida() * detallePresupuestoDTO.getPrecioUnitario());
			dto.setNombreProducto(detallePresupuestoDTO.getNombre());
			dto.setDescripcionProducto(detallePresupuestoDTO.getDescripcion());
			dto.setIdProducto(detallePresupuestoDTO.getProducto().getId());
			return dto;
		}
	}
}
