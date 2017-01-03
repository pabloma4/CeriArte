package com.ceriarte.central.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "detalle_pedido_estado", schema = "public")
public class DetallePedidoEstado implements java.io.Serializable {

	private static final long serialVersionUID = 1975661494838654115L;
	
	private int idDetallePedidoEstado;
	private String nombre;
	private String descripcion;

	public DetallePedidoEstado() {
	}
	
	public DetallePedidoEstado(int idDetallePedidoEstado) {
		this.idDetallePedidoEstado = idDetallePedidoEstado;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_detalle_pedido_estado", unique = true, nullable = false)
	public int getIdDetallePedidoEstado() {
		return this.idDetallePedidoEstado;
	}

	public void setIdDetallePedidoEstado(int idDetallePedidoEstado) {
		this.idDetallePedidoEstado = idDetallePedidoEstado;
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
