package com.ceriarte.central.dominio;


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

@Entity
@Table(name = "presupuesto", schema = "public")
public class Presupuesto implements java.io.Serializable {
	
	private static final long serialVersionUID = -6451615037405161626L;

	private int idPresupuesto;
	private Cliente cliente;
	private PresupuestoEstado presupuestoEstado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaValidoHasta;
	private Set<DetallePresupuesto> detalles;
	private boolean borrado;
	
	public Presupuesto() {
	}

	public Presupuesto(Cliente cliente, Date fechaValidoHasta, PresupuestoEstado presupuestoEstado) {
		super();
		this.cliente = cliente;
		this.fechaCreacion = new Date();
		this.fechaValidoHasta = fechaValidoHasta;
		this.detalles = new HashSet<DetallePresupuesto>();
		this.presupuestoEstado = presupuestoEstado;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_presupuesto", unique = true, nullable = false)
	public int getIdPresupuesto() {
		return this.idPresupuesto;
	}

	public void setIdPresupuesto(int idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_presupuesto_estado", nullable = false)
	public PresupuestoEstado getPresupuestoEstado() {
		return this.presupuestoEstado;
	}

	public void setPresupuestoEstado(PresupuestoEstado presupuestoEstado) {
		this.presupuestoEstado = presupuestoEstado;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_valido_hasta", nullable = false, length = 29)
	public Date getFechaValidoHasta() {
		return fechaValidoHasta;
	}

	public void setFechaValidoHasta(Date fechaValidoHasta) {
		this.fechaValidoHasta = fechaValidoHasta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "presupuesto", cascade = {CascadeType.ALL})
	public Set<DetallePresupuesto> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetallePresupuesto> detalles) {
		this.detalles = detalles;
	}

	@Column(name = "borrado")
	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
}
