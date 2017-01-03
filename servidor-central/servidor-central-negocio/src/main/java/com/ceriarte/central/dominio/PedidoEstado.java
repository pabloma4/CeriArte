package com.ceriarte.central.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pedido_estado", schema = "public")
public class PedidoEstado implements java.io.Serializable {

	private static final long serialVersionUID = 1975661494837644115L;
	
	private int idPedidoEstado;
	private String nombre;
	private String descripcion;

	public PedidoEstado() {
	}
	
	public PedidoEstado(int idPedidoEstado) {
		this.idPedidoEstado = idPedidoEstado;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_pedido_estado", unique = true, nullable = false)
	public int getIdPedidoEstado() {
		return this.idPedidoEstado;
	}

	public void setIdPedidoEstado(int idPedidoEstado) {
		this.idPedidoEstado = idPedidoEstado;
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
