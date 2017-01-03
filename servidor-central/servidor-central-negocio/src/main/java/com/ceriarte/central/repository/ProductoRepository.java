package com.ceriarte.central.repository;

import org.springframework.data.repository.CrudRepository;

import com.ceriarte.central.dominio.Producto;

/**
 * Interfaz del repository de Producto
 * 
 * @author pmarengo
 *
 */
public interface ProductoRepository extends CrudRepository<Producto, Integer> {


	/**
	 * @param nommbre
	 * @return Producto
	 * 
	 * Metodo que busca un producto por nombre, si lo encuentra lo devuelve. 
	 */
	public Producto findByNombre(String nombre);
	
	/**
	 * @return Producto
	 * 
	 * Metodo que devuelve los productos NO borrados
	 */
	public Iterable<Producto> findByBorradoIsFalse();
	
	/**
	 * @return Producto
	 * 
	 * Metodo que devuelve los productos NO borrados y NO elaborados
	 */
	public Iterable<Producto> findByBorradoIsFalseAndElaboradoIsFalse();
}
