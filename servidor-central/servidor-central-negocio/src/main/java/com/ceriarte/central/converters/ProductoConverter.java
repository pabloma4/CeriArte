package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.Producto;
import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

/**
 * @author pmarengo
 */
public class ProductoConverter {

	/**
	 * Convierte un Producto en un ProductoDTO
	 * 
	 * @param Producto
	 * @return ProductoDTO
	 */
	public static ProductoDTO toProductoDTO(Producto producto) {
		if (producto == null) {
			return null;
		} else {
			ProductoDTO dto = new ProductoDTO();
			dto.setId(producto.getIdProducto());
			dto.setNombre(producto.getNombre());
			dto.setDescripcion(producto.getDescripcion());
			dto.setPrecio(producto.getPrecio());
			dto.setPrecioUnitario(producto.getPrecioUnitario());
			dto.setMedida(producto.getMedida());
			dto.setUnidadMedida(UnidadMedidaConverter.toUnidadMedidaDTO(producto.getUnidadMedida()));
			dto.setStock(producto.getStock());
			dto.setStockMinimo(producto.getStockMinimo());
			dto.setElaborado(producto.isElaborado());
			dto.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(producto.getFechaCreacion()));
			dto.setFechaModificacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(producto.getFechaModificacion()));
			return dto;
		}
	}
	
	/**
	 * Convierte un ProductoDTO en un Producto
	 * 
	 * @param ProductoDTO
	 * @return Producto
	 */
	public static Producto toProducto(ProductoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Producto producto = new Producto();
			producto.setIdProducto(dto.getId());
			producto.setNombre(dto.getNombre());
			producto.setDescripcion(dto.getDescripcion());
			producto.setPrecio(dto.getPrecio());
			producto.setUnidadMedida(UnidadMedidaConverter.toUnidadMedida(dto.getUnidadMedida()));
			producto.setMedida(dto.getMedida());
			producto.setStock(dto.getStock());
			producto.setStockMinimo(dto.getStockMinimo());
			producto.setElaborado(dto.isElaborado());
			producto.setFechaCreacion(XMLGregorianCalendarConverter.asDate(dto.getFechaCreacion()));
			producto.setFechaModificacion(XMLGregorianCalendarConverter.asDate(dto.getFechaModificacion()));
			
			return producto;		
		}
	}
	
	/**
     * 
     * @param sourceDTO
     * @param targetDTO
     * 
     * Permite copiar los datos de un objeto ProductoDTO en otro
     * 
     * @return ProductoDTO
     */
	public static ProductoDTO copyDTO(ProductoDTO sourceDTO, ProductoDTO targetDTO) {
		if (targetDTO == null) {
    		targetDTO = new ProductoDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setId(sourceDTO.getId());
        	targetDTO.setNombre(sourceDTO.getNombre());
        	targetDTO.setDescripcion(sourceDTO.getDescripcion());
        	targetDTO.setPrecio(sourceDTO.getPrecio());
        	targetDTO.setPrecioUnitario(sourceDTO.getPrecioUnitario());
        	targetDTO.setMedida(sourceDTO.getMedida());
        	targetDTO.setUnidadMedida(sourceDTO.getUnidadMedida());
        	targetDTO.setStock(sourceDTO.getStock());
        	targetDTO.setStockMinimo(sourceDTO.getStockMinimo());
        	targetDTO.setElaborado(sourceDTO.isElaborado());
    	}
    	return targetDTO;
	}
}
