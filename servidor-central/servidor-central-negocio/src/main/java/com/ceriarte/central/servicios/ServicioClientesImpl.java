package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.ClienteConverter;
import com.ceriarte.central.converters.LocalidadConverter;
import com.ceriarte.central.converters.ResponsabilidadIVAConverter;
import com.ceriarte.central.dominio.Cliente;
import com.ceriarte.central.dominio.ClienteEstado;
import com.ceriarte.central.dominio.Localidad;
import com.ceriarte.central.dominio.ResponsabilidadIVA;
import com.ceriarte.central.dominio.dto.ClienteDTO;
import com.ceriarte.central.enums.ClienteEstadoEnum;
import com.ceriarte.central.repository.ClienteRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioClientes")
@Transactional
public class ServicioClientesImpl implements ServicioGeneric<ClienteDTO> {
	
	private final Logger logger = Logger.getLogger(getClass());

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteDTO doSaveOrUpdate(ClienteDTO clienteDto) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Clientes");
		
		String nombre = clienteDto.getNombre();
		String apellido = clienteDto.getApellido();
		String email = clienteDto.getEmail();
		String telefono = clienteDto.getTelefono();
		String domicilio = clienteDto.getDomicilio();
		String cuit = clienteDto.getCuit();
		Localidad localidad = null != clienteDto.getLocalidad() ? LocalidadConverter.toLocalidad(clienteDto.getLocalidad()) : null; 
		ResponsabilidadIVA respIVA = null != clienteDto.getResponsabilidadIVA() ? ResponsabilidadIVAConverter.toResponsabilidadIVA(clienteDto.getResponsabilidadIVA()) : null; 
		
		// Busco el cliente, sino lo encuentro creo uno nuevo.
		Cliente cliente = clienteRepository.findOne(clienteDto.getId());
		if(null != cliente){
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setLocalidad(localidad);
			cliente.setDomicilio(domicilio);
			cliente.setCuit(cuit);
			cliente.setResponsabilidadIVA(respIVA);
		}else{
			ClienteEstado estado = new ClienteEstado(ClienteEstadoEnum.ACTIVO.getValue());
			// Creo un objeto cliente
			cliente = new Cliente(estado,nombre, apellido, email, domicilio, localidad, telefono, cuit, respIVA);
		}
		
		// Almaceno los datos del cliente
		cliente = clienteRepository.save(cliente);
		
		logger.debug("Fin doSaveOrUpdate() del Servicio de Clientes");
		return ClienteConverter.toClienteDTO(cliente);
	}
	
	@Override
	public List<ClienteDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Clientes");
		
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

		// Busco todas los clientes
		Iterable<Cliente> clientes = clienteRepository.findByBorradoIsFalse();

		Iterator<Cliente> it = clientes.iterator();
		while (it.hasNext()) {
			ClienteDTO clienteDTO = ClienteConverter.toClienteDTO(it.next());
			clientesDTO.add(clienteDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Clientes");
		
		return clientesDTO;
	}
	
	@Override
	public ClienteDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Clientes");
		
		// Busco el cliente por id
		Cliente cliente = clienteRepository.findOne(id);

		ClienteDTO clienteDTO = ClienteConverter.toClienteDTO(cliente);
		
		logger.debug("Fin doFindOne() del Servicio de Clientes");
		return clienteDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Clientes");
		
		Cliente cliente = clienteRepository.findOne(id);
		cliente.setBorrado(true);
		
		clienteRepository.save(cliente);
    	logger.debug("Se eliminó el cliente " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Clientes");
	}
}
