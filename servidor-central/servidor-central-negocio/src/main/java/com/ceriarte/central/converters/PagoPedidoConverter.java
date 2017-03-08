package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.MovimientoCaja;
import com.ceriarte.central.dominio.dto.PagoPedidoDTO;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

/**
 * @author pmarengo
 */
public class PagoPedidoConverter {

	/**
	 * Convierte un MovimientoCaja en un PagoPedidoDTO
	 * 
	 * @param MovimientoCaja
	 * @return PagoPedidoDTO
	 */
	public static PagoPedidoDTO toPagoPedidoDTO(MovimientoCaja movimientoCaja) {
		if (movimientoCaja == null) {
			return null;
		} else {
			PagoPedidoDTO dto = new PagoPedidoDTO();
			dto.setId(movimientoCaja.getIdMovimientoCaja());
			dto.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(movimientoCaja.getFechaHora()));
			dto.setMedioDePago(MedioDePagoConverter.toMedioDePagoDTO(movimientoCaja.getMedioDePago()));
			dto.setMonto(movimientoCaja.getMonto());
			dto.setPedido(PedidoConverter.toPedidoDTOThin(movimientoCaja.getPedido()));
			return dto;
		}
	}

	/**
	 * Convierte un PagoPedidoDTO en un MovimientoCaja
	 * 
	 * @param PagoPedidoDTO
	 * @return MovimientoCaja
	 */
	public static MovimientoCaja toMovimientoCaja(PagoPedidoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			MovimientoCaja movimientoCaja = new MovimientoCaja();
			movimientoCaja.setIdMovimientoCaja(dto.getId());
			movimientoCaja.setFechaHora(XMLGregorianCalendarConverter.asDate(dto.getFechaCreacion()));
			movimientoCaja.setMonto(dto.getMonto());
			movimientoCaja.setPedido(PedidoConverter.toPedidoThin(dto.getPedido()));
			movimientoCaja.setMedioDePago(MedioDePagoConverter.toMedioDePago(dto.getMedioDePago()));
			return movimientoCaja;
		}
	}

	/**
	 * 
	 * @param sourceDTO
	 * @param targetDTO
	 * 
	 *            Permite copiar los datos de un objeto PagoPedidoDTO en otro
	 * 
	 * @return PagoPedidoDTO
	 */
	public static PagoPedidoDTO copyDTO(PagoPedidoDTO sourceDTO, PagoPedidoDTO targetDTO) {
		if (targetDTO == null) {
			targetDTO = new PagoPedidoDTO();
		}

		if (sourceDTO != null) {
			targetDTO.setId(sourceDTO.getId());
			targetDTO.setFechaCreacion(sourceDTO.getFechaCreacion());
			targetDTO.setMedioDePago(sourceDTO.getMedioDePago());
			targetDTO.setMonto(sourceDTO.getMonto());
			targetDTO.setPedido(sourceDTO.getPedido());
		}
		return targetDTO;
	}
}
