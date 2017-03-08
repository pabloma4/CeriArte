package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.MedioDePago;
import com.ceriarte.central.dominio.dto.MedioDePagoDTO;

/**
 * @author pmarengo
 */
public class MedioDePagoConverter {

	/**
	 * Convierte un MedioDePago en un MedioDePagoDTO
	 * 
	 * @param MedioDePago
	 * @return MedioDePagoDTO
	 */
	public static MedioDePagoDTO toMedioDePagoDTO(MedioDePago medioDePago) {
		if (medioDePago == null) {
			return null;
		} else {
			MedioDePagoDTO dto = new MedioDePagoDTO();
			dto.setId(medioDePago.getIdMedioDePago());
			dto.setAbreviatura(medioDePago.getAbreviatura());
			dto.setDescripcion(medioDePago.getDescripcion());
			dto.setHabilitado(medioDePago.isHabilitado());
			return dto;
		}
	}

	/**
	 * Convierte una MedioDePagoDTO en una MedioDePago
	 * 
	 * @param MedioDePagoDTO
	 * @return MedioDePago
	 */
	public static MedioDePago toMedioDePago(MedioDePagoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			MedioDePago medioDePago = new MedioDePago();
			medioDePago.setIdMedioDePago(dto.getId());
			medioDePago.setAbreviatura(dto.getAbreviatura());
			medioDePago.setDescripcion(dto.getDescripcion());
			medioDePago.setHabilitado(dto.isHabilitado());
			return medioDePago;
		}
	}
}
