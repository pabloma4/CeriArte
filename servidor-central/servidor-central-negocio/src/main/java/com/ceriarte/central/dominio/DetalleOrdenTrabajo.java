package com.ceriarte.central.dominio;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "detalle_orden_trabajo", schema = "public")
public class DetalleOrdenTrabajo implements java.io.Serializable {
	

	private static final long serialVersionUID = -1204089399823815224L;

	private int idDetalleOrdenTrabajo;
	private Producto producto;
	private double cantidad;
	private OrdenTrabajo ordenTrabajo;
	private boolean updated;
	
	public DetalleOrdenTrabajo() {
	}

	public DetalleOrdenTrabajo(Producto producto, double cantidad, OrdenTrabajo ordenTrabajo) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.ordenTrabajo = ordenTrabajo;
		this.updated = true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_detalle_orden_trabajo", unique = true, nullable = false)
	public int getIdDetalleOrdenTrabajo() {
		return idDetalleOrdenTrabajo;
	}

	public void setIdDetalleOrdenTrabajo(int idDetalleOrdenTrabajo) {
		this.idDetalleOrdenTrabajo = idDetalleOrdenTrabajo;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_producto", nullable = false)
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Column(name = "cantidad", nullable = false)
	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_orden_trabajo", nullable = false)
	public OrdenTrabajo getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	@Transient
	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleOrdenTrabajo other = (DetalleOrdenTrabajo) obj;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
}
