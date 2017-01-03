package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.DetallePedido;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;

/**
 * @author pmarengo
 */
public class DetallePedidoConverter {

	/**
	 * Convierte un DetallePedido en un DetallePedidoDTO
	 * 
	 * @param DetallePedido
	 * @return DetallePedidoDTO
	 */
	public static DetallePedidoDTO toDetallePedidoDTO(DetallePedido detallePedido) {
		if (detallePedido == null) {
			return null;
		} else {
			DetallePedidoDTO dto = new DetallePedidoDTO();
			dto.setId(detallePedido.getIdDetallePedido());
			dto.setCantidad(detallePedido.getCantidad());
			dto.setMedida(detallePedido.getMedida());
			dto.setPrecioUnitario(detallePedido.getPrecioUnitario());
			dto.setProducto(ProductoConverter.toProductoDTO(detallePedido.getProducto()));
			dto.setNombre(detallePedido.getNombre());
			dto.setDescripcion(detallePedido.getDescripcion());
			dto.setPedido(PedidoConverter.toPedidoDTOThin(detallePedido.getPedido()));
			dto.setOrdenTrabajo(OrdenTrabajoConverter.toOrdenTrabajoDTOThin(detallePedido.getOrdenTrabajo()));
			dto.setDetallePedidoEstado(DetallePedidoEstadoConverter.toDetallePedidoEstadoDTO(detallePedido.getDetallePedidoEstado()));
			return dto;
		}
	}
	
	/**
	 * Convierte un DetallePedido en un DetallePedidoDTO
	 * 
	 * @param DetallePedido
	 * @return DetallePedidoDTO
	 */
	public static DetallePedidoDTO toDetallePedidoDTOThin(DetallePedido detallePedido) {
		if (detallePedido == null) {
			return null;
		} else {
			DetallePedidoDTO dto = new DetallePedidoDTO();
			dto.setId(detallePedido.getIdDetallePedido());
			dto.setMedida(detallePedido.getMedida());
			dto.setCantidad(detallePedido.getCantidad());
			dto.setPrecioUnitario(detallePedido.getPrecioUnitario());
			dto.setProducto(ProductoConverter.toProductoDTO(detallePedido.getProducto()));
			dto.setNombre(detallePedido.getNombre());
			dto.setDescripcion(detallePedido.getDescripcion());
			dto.setPedido(PedidoConverter.toPedidoDTOThin(detallePedido.getPedido()));
			dto.setDetallePedidoEstado(DetallePedidoEstadoConverter.toDetallePedidoEstadoDTO(detallePedido.getDetallePedidoEstado()));
			return dto;
		}
	}
	
	/**
	 * Convierte un DetallePedidoDTO en un DetallePedido
	 * 
	 * @param DetallePedidoDTO
	 * @return DetallePedido
	 */
	public static DetallePedido toDetallePedido(DetallePedidoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			DetallePedido detallePedido = new DetallePedido();
			detallePedido.setIdDetallePedido(dto.getId());
			detallePedido.setMedida(dto.getMedida());
			detallePedido.setCantidad(dto.getCantidad());
			detallePedido.setPrecioUnitario(dto.getPrecioUnitario());
			detallePedido.setProducto(ProductoConverter.toProducto(dto.getProducto()));
			detallePedido.setNombre(dto.getNombre());
			detallePedido.setDescripcion(dto.getDescripcion());
			detallePedido.setDetallePedidoEstado(DetallePedidoEstadoConverter.toDetallePedidoEstado(dto.getDetallePedidoEstado()));
			detallePedido.setPedido(PedidoConverter.toPedidoThin(dto.getPedido()));
			return detallePedido;		
		}
	}
	
	/**
     * 
     * @param sourceDTO
     * @param targetDTO
     * 
     * Permite copiar los datos de un objeto DetallePedidoDTO en otro
     * 
     * @return DetallePedidoDTO
     */
	public static DetallePedidoDTO copyDTO(DetallePedidoDTO sourceDTO, DetallePedidoDTO targetDTO) {
		if (targetDTO == null) {
    		targetDTO = new DetallePedidoDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setId(sourceDTO.getId());
        	targetDTO.setMedida(sourceDTO.getMedida());
        	targetDTO.setCantidad(sourceDTO.getCantidad());
        	targetDTO.setMonto(sourceDTO.getMonto());
        	targetDTO.setPrecioUnitario(sourceDTO.getPrecioUnitario());
        	targetDTO.setProducto(sourceDTO.getProducto());
        	targetDTO.setDescripcion(sourceDTO.getDescripcion());
        	targetDTO.setDetallePedidoEstado(sourceDTO.getDetallePedidoEstado());
        	targetDTO.setNombre(sourceDTO.getNombre());
        	targetDTO.setOrdenTrabajo(sourceDTO.getOrdenTrabajo());
        	targetDTO.setPedido(sourceDTO.getPedido());
    	}
    	return targetDTO;
	}
}
