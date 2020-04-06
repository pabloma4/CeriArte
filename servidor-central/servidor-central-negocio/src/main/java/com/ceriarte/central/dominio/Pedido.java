package com.ceriarte.central.dominio;

// Generated 11-sep-2013 18:19:09 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pedido generated by hbm2java
 */
@Entity
@Table(name = "pedido", schema = "public")
public class Pedido implements java.io.Serializable {

	private static final long serialVersionUID = 8987926604915469724L;

	private int idPedido;
	private Cliente cliente;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Set<DetallePedido> detalles;
	private boolean borrado;
	private PedidoEstado pedidoEstado;
	private Presupuesto presupuesto;
	private Set<MovimientoCaja> pagos;

	public Pedido() {
	}

	public Pedido(Cliente cliente, Presupuesto presupuesto) {
		super();
		this.cliente = cliente;
		this.presupuesto = presupuesto;
		this.fechaCreacion = new Date();
		this.detalles = new HashSet<DetallePedido>();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_pedido", unique = true, nullable = false)
	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, length = 29)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion", nullable = false, length = 29)
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = {CascadeType.ALL})
	public Set<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	@Column(name = "borrado")
	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido_estado", nullable = false)
	public PedidoEstado getPedidoEstado() {
		return pedidoEstado;
	}

	public void setPedidoEstado(PedidoEstado pedidoEstado) {
		this.pedidoEstado = pedidoEstado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_presupuesto", nullable = true)
	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = {CascadeType.ALL})
	public Set<MovimientoCaja> getPagos() {
		return pagos;
	}

	public void setPagos(Set<MovimientoCaja> pagos) {
		this.pagos = pagos;
	}
	
}
