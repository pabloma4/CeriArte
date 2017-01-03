package com.ceriarte.central.converters;

import com.ceriarte.central.dominio.Cliente;
import com.ceriarte.central.dominio.dto.ClienteDTO;

/**
 * @author pmarengo
 */
public class ClienteConverter {

	/**
	 * Convierte un Cliente en un ClienteDTO
	 * 
	 * @param Cliente
	 * @return ClienteDTO
	 */
	public static ClienteDTO toClienteDTO(Cliente cliente) {
		if (cliente == null) {
			return null;
		} else {
			ClienteDTO dto = new ClienteDTO();
			dto.setId(cliente.getIdCliente());
			dto.setNombre(cliente.getNombre());
			dto.setApellido(cliente.getApellido());
			dto.setDomicilio(cliente.getDomicilio());
			dto.setEmail(cliente.getEmail());
			dto.setTelefono(cliente.getTelefono());
			dto.setLocalidad(LocalidadConverter.toLocalidadDTO(cliente.getLocalidad()));
			dto.setCuit(cliente.getCuit());
			dto.setResponsabilidadIVA(ResponsabilidadIVAConverter.toResponsabilidadIVADTO(cliente.getResponsabilidadIVA()));
			dto.setNombreCompleto(cliente.getNombreCompleto());
			return dto;
		}
	}
	
	
	/**
	 * Convierte un Cliente en un ClienteDTO, pero sólo con datos mínimos
	 * 
	 * @param Cliente
	 * @return ClienteDTO
	 */
	public static ClienteDTO toClienteDTOThin(Cliente cliente) {
		if (cliente == null) {
			return null;
		} else {
			ClienteDTO dto = new ClienteDTO();
			dto.setId(cliente.getIdCliente());
			dto.setNombre(cliente.getNombre());
			dto.setApellido(cliente.getApellido());
			dto.setNombreCompleto(cliente.getNombreCompleto());
			return dto;
		}
	}
	
	/**
	 * Convierte un ClienteDTO en un Cliente
	 * 
	 * @param ClienteDTO
	 * @return Cliente
	 */
	public static Cliente toCliente(ClienteDTO dto) {
		if (dto == null) {
			return null;
		} else {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(dto.getId());
			cliente.setNombre(dto.getNombre());
			cliente.setApellido(dto.getApellido());
			cliente.setDomicilio(dto.getDomicilio());
			cliente.setEmail(dto.getEmail());
			cliente.setTelefono(dto.getTelefono());
			cliente.setLocalidad(LocalidadConverter.toLocalidad(dto.getLocalidad()));
			cliente.setCuit(dto.getCuit());
			cliente.setResponsabilidadIVA(ResponsabilidadIVAConverter.toResponsabilidadIVA(dto.getResponsabilidadIVA()));
			return cliente;		
		}
	}
	
	/**
     * 
     * @param sourceDTO
     * @param targetDTO
     * 
     * Permite copiar los datos de un objeto ClienteDTO en otro
     * 
     * @return ClienteDTO
     */
	public static ClienteDTO copyDTO(ClienteDTO sourceDTO, ClienteDTO targetDTO) {
		if (targetDTO == null) {
    		targetDTO = new ClienteDTO();
    	}
    	
    	if (sourceDTO!=null) {
        	targetDTO.setId(sourceDTO.getId());
        	targetDTO.setNombre(sourceDTO.getNombre());
        	targetDTO.setApellido(sourceDTO.getApellido());
        	targetDTO.setDomicilio(sourceDTO.getDomicilio());
        	targetDTO.setEmail(sourceDTO.getEmail());
        	targetDTO.setLocalidad(sourceDTO.getLocalidad());
        	targetDTO.setTelefono(sourceDTO.getTelefono());
        	targetDTO.setCuit(sourceDTO.getCuit());
        	targetDTO.setResponsabilidadIVA(sourceDTO.getResponsabilidadIVA());
        	targetDTO.setNombreCompleto(sourceDTO.getNombreCompleto());
    	}
    	return targetDTO;
	}
}
