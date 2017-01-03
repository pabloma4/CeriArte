package com.ceriarte.central.dominio;

// Generated 11-sep-2013 18:19:09 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Provincia generated by hbm2java
 */
@Entity
@Table(name = "provincia", schema = "public")
public class Provincia implements java.io.Serializable {


	private static final long serialVersionUID = -7418152478575617521L;

	private String idProvincia;
	private Pais pais;
	private String nombre;

	public Provincia() {
	}

	public Provincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}
	
	public Provincia(String idProvincia, Pais pais, String nombre) {
		this.idProvincia = idProvincia;
		this.pais = pais;
		this.nombre = nombre;
	}

	@Id
	@Column(name = "id_provincia", unique = true, nullable = false, length = 3)
	public String getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais", nullable = false)
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Column(name = "nombre", nullable = false, length = 128)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
