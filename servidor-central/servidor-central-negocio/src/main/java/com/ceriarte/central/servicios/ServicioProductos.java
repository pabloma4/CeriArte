package com.ceriarte.central.servicios;

import java.util.List;

import com.ceriarte.central.dominio.dto.ProductoDTO;


/**
 * Interfaz de ServicioProductos
 * 
 * @author pmarengo
 *
 */
public interface ServicioProductos extends ServicioGeneric<ProductoDTO>{

	/**
	 * 
	 * @return List<ProductoDTO>
	 * 
	 * Método que devuelve todos los productos que no son elaborados 
	 */
	List<ProductoDTO> doFindByElaboradoIsFalse();

}
