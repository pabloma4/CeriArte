package com.ceriarte.central.dominio;

//Generated 22-jul-2014 by Carolina Olguín

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Parametro
 */
@Entity
@Table(name = "parametro", schema = "public")
public class Parametro implements java.io.Serializable {

	private static final long serialVersionUID = -1400722864789043270L;
	private int idParametro;
	private String clave;
	private String valor;
	private String descripcion;

	public Parametro() {
	}

	public Parametro(int idParametro, String clave) {
		this.idParametro = idParametro;
		this.clave = clave;
	}

	public Parametro(int idParametro, String clave,
			String valor, String descripcion) {
		this.idParametro = idParametro;
		this.clave = clave;
		this.valor = valor;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_parametro", unique = true, nullable = false)
	public int getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	@Column(name = "clave", unique = true, nullable = false, length = 40)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "valor", length = 512)
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Column(name = "descripcion", length = 512)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
