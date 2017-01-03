package com.ceriarte.central.web.services;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceriarte.central.dominio.dto.ClienteDTO;
import com.ceriarte.central.servicios.ServicioGeneric;

@ManagedBean(name="clientesService", eager = true)
@ApplicationScoped
public class ClientesService implements Serializable {


	private static final long serialVersionUID = 3548138430717932243L;

	private final Logger logger = LoggerFactory.getLogger(ClientesService.class);

	@ManagedProperty(value = "#{servicioClientes}")
	private ServicioGeneric<ClienteDTO> servicioClientes;


	public ClienteDTO doFindOne(int id) {
		logger.debug("Obtengo el cliente con id " + id);
		return servicioClientes.doFindOne(id);
	}
	
	public void setServicioClientes(ServicioGeneric<ClienteDTO> servicioClientes) {
		this.servicioClientes = servicioClientes;
	}


}
