package com.ceriarte.central.web.services;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.servicios.ServicioGeneric;

@ManagedBean(name="productosService", eager = true)
@ApplicationScoped
public class ProductosService implements Serializable {

	private static final long serialVersionUID = 5486876071221921399L;

	private final Logger logger = LoggerFactory.getLogger(ProductosService.class);

	@ManagedProperty(value = "#{servicioProductos}")
	private ServicioGeneric<ProductoDTO> servicioProductos;


	public ProductoDTO doFindOne(int id) {
		logger.debug("Obtengo el producto con id " + id);
		return servicioProductos.doFindOne(id);
	}
	
	public void setServicioProductos(ServicioGeneric<ProductoDTO> servicioProductos) {
		this.servicioProductos = servicioProductos;
	}


}
