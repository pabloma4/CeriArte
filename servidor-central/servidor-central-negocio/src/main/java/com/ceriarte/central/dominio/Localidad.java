package com.ceriarte.central.dominio;

// Generated 11-sep-2013 18:19:09 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Provincia generated by hbm2java
 */
@Entity
@Table(name = "localidad", schema = "public")
public class Localidad implements java.io.Serializable {

	private static final long serialVersionUID = -6549080276292768723L;

	private String idLocalidad;
	private String nombre;

	@Id
	@Column(name = "id_localidad", unique = true, nullable = false, length = 3)
	public String getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(String idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	@Column(name = "nombre", nullable = false, length = 128)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
