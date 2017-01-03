package com.ceriarte.central.web.services;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceriarte.central.dominio.dto.PresupuestoDTO;
import com.ceriarte.central.servicios.ServicioGeneric;

@ManagedBean(name="presupuestosService", eager = true)
@ApplicationScoped
public class PresupuestosService implements Serializable {


	private static final long serialVersionUID = 3548138430717934433L;

	private final Logger logger = LoggerFactory.getLogger(PresupuestosService.class);

	@ManagedProperty(value = "#{servicioPresupuestos}")
	private ServicioGeneric<PresupuestoDTO> servicioPresupuestos;


	public PresupuestoDTO doFindOne(int id) {
		logger.debug("Obtengo el presupuesto con id " + id);
		return servicioPresupuestos.doFindOne(id);
	}
	
	public void setServicioPresupuestos(ServicioGeneric<PresupuestoDTO> servicioPresupuestos) {
		this.servicioPresupuestos = servicioPresupuestos;
	}


}
