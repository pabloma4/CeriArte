package com.ceriarte.central.converters;

import java.util.HashSet;
import java.util.Set;

import com.ceriarte.central.dominio.DetallePedido;
import com.ceriarte.central.dominio.MovimientoCaja;
import com.ceriarte.central.dominio.Pedido;
import com.ceriarte.central.dominio.dto.DetallePedidoDTO;
import com.ceriarte.central.dominio.dto.DetallesPedido;
import com.ceriarte.central.dominio.dto.PagoPedidoDTO;
import com.ceriarte.central.dominio.dto.PagosPedido;
import com.ceriarte.central.dominio.dto.PedidoDTO;
import com.ceriarte.central.utilidades.XMLGregorianCalendarConverter;

/**
 * @author pmarengo
 */
public class PedidoConverter {

	/**
	 * Convierte un Pedido en un PedidoDTO
	 * 
	 * @param Pedido
	 * @return PedidoDTO
	 */
	public static PedidoDTO toPedidoDTO(Pedido pedido) {
		if (pedido == null) {
			return null;
		} else {
			PedidoDTO dto = new PedidoDTO();
			dto.setId(pedido.getIdPedido());
			dto.setCliente(ClienteConverter.toClienteDTO(pedido.getCliente()));
			dto.setPedidoEstado(PedidoEstadoConverter.toPedidoEstadoDTO(pedido.getPedidoEstado()));
			dto.setPresupuesto(PresupuestoConverter.toPresupuestoDTO(pedido.getPresupuesto()));
			dto.setFechaCreacion(XMLGregorianCalendarConverter.asXMLGregorianCalendar(pedido.getFechaCreacion()));
			
			DetallesPedido detallesPedido = new DetallesPedido();
			for (DetallePedido detallePedido : pedido.getDetalles()) {
				detallesPedido.getDetallePedido().add(DetallePedidoConverter.toDetallePedidoDTO(detallePedido));
			}
			dto.setDetalles(detallesPedido);
			
			PagosPedido pagosPedido = new PagosPedido();
			for (MovimientoCaja pagoPedido : pedido.getPagos()) {
				pagosPedido.getPagoPedido().add(PagoPedidoConverter.toPagoPedidoDTO(pagoPedido));
			}
			dto.setPagos(pagosPedido);
			
			return dto;
		}
	}
	
	/**
	 * Convierte un Pedido en un PedidoDTO, pero sólo con datos mínimos
	 * 
	 * @param Pedido
	 * @return PedidoDTO
	 */
	public static PedidoDTO toPedidoDTOThin(Pedido pedido) {
		if (pedido == null) {
			return null;
		} else {
			PedidoDTO dto = new PedidoDTO();
			dto.setId(pedido.getIdPedido());
			dto.setCliente(ClienteConverter.toClienteDTO(pedido.getCliente()));
			
			return dto;
		}
	}
	
	/**
	 * Convierte un PedidoDTO en un Pedido
	 * 
	 * @param PedidoDTO
	 * @return Pedido
	 */
	public static Pedido toPedido(PedidoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Pedido pedido = new Pedido();
			pedido.setIdPedido(dto.getId());
			pedido.setCliente(ClienteConverter.toCliente(dto.getCliente()));
			pedido.setPresupuesto(PresupuestoConverter.toPresupuesto(dto.getPresupuesto()));
			
			Set<DetallePedido> detalles = new HashSet<DetallePedido>();
			for (DetallePedidoDTO detallePedidoDTO : dto.getDetalles().getDetallePedido()) {
				detalles.add(DetallePedidoConverter.toDetallePedido(detallePedidoDTO));
			}
			pedido.setDetalles(detalles);
			
			Set<MovimientoCaja> pagos = new HashSet<MovimientoCaja>();
			for (PagoPedidoDTO pagoPedidoDTO : dto.getPagos().getPagoPedido()) {
				pagos.add(PagoPedidoConverter.toMovimientoCaja(pagoPedidoDTO));
			}
			pedido.setPagos(pagos);
			
			return pedido;		
		}
	}
	
	/**
	 * Convierte un PedidoDTO en un Pedido, pero sólo con datos mínimos
	 * 
	 * @param PedidoDTO
	 * @return Pedido
	 */
	public static Pedido toPedidoThin(PedidoDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Pedido pedido = new Pedido();
			pedido.setIdPedido(dto.getId());
			
			return pedido;		
		}
	}
	
	/**
     * 
     * @param sourceDTO
     * @param targetDTO
     * 
     * Permite copiar los datos de un objeto PedidoDTO en otro
     * 
     * @return PedidoDTO
     */
	public static PedidoDTO copyDTO(PedidoDTO sourceDTO, PedidoDTO targetDTO) {
		if (targetDTO == null) {
    		targetDTO = new PedidoDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setId(sourceDTO.getId());
        	targetDTO.setCliente(sourceDTO.getCliente());
        	targetDTO.setFechaCreacion(sourceDTO.getFechaCreacion());
        	targetDTO.setPresupuesto(sourceDTO.getPresupuesto());
        	targetDTO.setPedidoEstado(sourceDTO.getPedidoEstado());
        	targetDTO.setDetalles(sourceDTO.getDetalles());
        	targetDTO.setPagos(sourceDTO.getPagos());
    	}
    	return targetDTO;
	}
}
