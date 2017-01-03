package com.ceriarte.central.dominio;

// Generated 11-sep-2013 18:19:09 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "responsabilidad_iva", schema = "public")
public class ResponsabilidadIVA implements java.io.Serializable {


	private static final long serialVersionUID = -5464619423538247114L;

	private int idResponsabilidadIVA;
	private String descripcion;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_responsabilidad_iva", unique = true, nullable = false)
	public int getIdResponsabilidadIVA() {
		return this.idResponsabilidadIVA;
	}

	public void setIdResponsabilidadIVA(int idResponsabilidadIVA) {
		this.idResponsabilidadIVA = idResponsabilidadIVA;
	}

	@Column(name = "descripcion", length = 256)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
