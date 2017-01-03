package com.ceriarte.central.servicios;

import java.util.List;

/**
 * Interfaz de Servicios. Se implementa Generic
 * 
 * @author pmarengo
 *
 */
public interface ServicioGeneric<T> {

	/**
	 * @param objetoDTO
	 * 
	 * @return int
	 * 
	 * Método que busca un objeto según alguno de los parámetros que se pasan en el DTO, si existe lo modifica con los datos del DTO. 
	 * Si no existe se crea un nuevo registro con dichos datos y lo devuelve.
	 */
	T doSaveOrUpdate(T objetoDTO);
	
	/**
	 * Método que devuelve una lista con todos los objetos DTO.
	 * 
	 * @return List<T>
	 */
	List<T> doFindAll();
	
	/**
	 * @param int
	 *  
	 * @return T
	 * 
	 * Método que devuelve un objeto DTO para el id pasado por parámetro.
	 */
	T doFindOne(int id);
	
	/**
	 * Método que elimina el objeto que corresponde al id recibido
	 * 
	 * @param int id
	 */
	void doDelete(int id);
}
