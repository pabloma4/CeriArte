package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.dto.DetalleOrdenTrabajoDTO;
import com.ceriarte.central.dominio.dto.DetalleOrdenTrabajoReporteDTO;

/**
 * @author pmarengo
 */
public class DetalleOrdenTrabajoReporteConverter {

	/**
	 * Convierte un DetalleOrdenTrabajoDTO en un DetalleOrdenTrabajoReporteDTO
	 * 
	 * @param DetalleOrdenTrabajoDTO
	 * @return DetalleOrdenTrabajoReporteDTO
	 */
	public static DetalleOrdenTrabajoReporteDTO toDetalleOrdenTrabajoReporteDTO(DetalleOrdenTrabajoDTO detalleOrdenTrabajoDTO) {
		if (detalleOrdenTrabajoDTO == null) {
			return null;
		} else {
			DetalleOrdenTrabajoReporteDTO dto = new DetalleOrdenTrabajoReporteDTO();
			dto.setId(detalleOrdenTrabajoDTO.getId());
			dto.setCantidad(String.valueOf(detalleOrdenTrabajoDTO.getCantidad()) + " ("+detalleOrdenTrabajoDTO.getProducto().getUnidadMedida().getSimbolo()+")");
			dto.setNombreProducto(detalleOrdenTrabajoDTO.getProducto().getNombre());
			dto.setDescripcionProducto(detalleOrdenTrabajoDTO.getProducto().getDescripcion());
			dto.setIdProducto(detalleOrdenTrabajoDTO.getProducto().getId());
			return dto;
		}
	}
}
