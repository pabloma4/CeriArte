package com.ceriarte.central.servicios;

import com.ceriarte.central.dominio.dto.ParametroDTO;
import com.ceriarte.central.enums.ParametroEnum;

/**
 * Interfaz del servicio de Parámetros de AE
 * 
 * @author Carolina Olguín
 *
 */
public interface ServicioParametros {

	/**
	 * Método que devuelve el valor del parámetro correspondiente a la clave recibida
	 * 
	 * @param ParametroEnum
	 * @return String
	 */
	String doObtenerValorParametro(ParametroEnum parEnum);

	/**
	 * Método que devuelve el parámetro correspondiente al id recibido
	 * 
	 * @param int
	 * @return ParametroDTO
	 */
	ParametroDTO doObtenerParametro(int idParametro);

	/**
	 * Método que guarda un nuevo parametro o uno modificado y retorna el id del mismo.
	 * 
	 * @param ParametroDto
	 * @return int
	 */
	int doSaveParametro(ParametroDTO dto);

	/**
	 * Método que elimina el parámetro que corresponde al id recibido
	 * y retorna un boolean con el resultado de la operación.
	 * 
	 * @param int id
	 * @return boolean
	 */
	boolean doDeleteParametro(int id);

}
