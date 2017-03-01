package com.ceriarte.central.dominio;

// Generated 11-sep-2013 18:19:09 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pais generated by hbm2java
 */
@Entity
@Table(name = "pais", schema = "public")
public class Pais implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9162982860969145096L;
	private String idPais;
	private String nombre;

	public Pais() {
	}

	public Pais(String idPais, String nombre) {
		this.idPais = idPais;
		this.nombre = nombre;
	}

	@Id
	@Column(name = "id_pais", unique = true, nullable = false, length = 3)
	public String getIdPais() {
		return this.idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	@Column(name = "nombre", nullable = false, length = 128)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}