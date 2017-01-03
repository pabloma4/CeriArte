package com.ceriarte.central.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "orden_trabajo_estado", schema = "public")
public class OrdenTrabajoEstado implements java.io.Serializable {

	private static final long serialVersionUID = 1975661465838944115L;
	
	private int idOrdenTrabajoEstado;
	private String nombre;
	private String descripcion;

	public OrdenTrabajoEstado() {
	}
	
	public OrdenTrabajoEstado(int idPedidoEstado) {
		this.idOrdenTrabajoEstado = idPedidoEstado;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_orden_trabajo_estado", unique = true, nullable = false)
	public int getIdOrdenTrabajoEstado() {
		return this.idOrdenTrabajoEstado;
	}

	public void setIdOrdenTrabajoEstado(int idOrdenTrabajoEstado) {
		this.idOrdenTrabajoEstado = idOrdenTrabajoEstado;
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
