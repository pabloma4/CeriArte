package com.ceriarte.central.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "presupuesto_estado", schema = "public")
public class PresupuestoEstado implements java.io.Serializable {

	private static final long serialVersionUID = 1975661494838944115L;
	
	private int idPresupuestoEstado;
	private String nombre;
	private String descripcion;

	public PresupuestoEstado() {
	}
	
	public PresupuestoEstado(int idPresupuestoEstado) {
		this.idPresupuestoEstado = idPresupuestoEstado;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_presupuesto_estado", unique = true, nullable = false)
	public int getIdPresupuestoEstado() {
		return this.idPresupuestoEstado;
	}

	public void setIdPresupuestoEstado(int idPresupuestoEstado) {
		this.idPresupuestoEstado = idPresupuestoEstado;
	}

	@Column(name = "nombre", nullable = false, length = 128)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 256)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
