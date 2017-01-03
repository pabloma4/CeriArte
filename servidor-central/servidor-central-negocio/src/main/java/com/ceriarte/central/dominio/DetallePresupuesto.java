package com.ceriarte.central.dominio;


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
@Table(name = "detalle_presupuesto", schema = "public")
public class DetallePresupuesto implements java.io.Serializable {
	

	private static final long serialVersionUID = -1204386739823815224L;

	private int idDetallePresupuesto;
	private Producto producto;
	private String nombre;
	private String descripcion;
	private double cantidad;
	private double medida;
	private double precioUnitario;
	private Presupuesto presupuesto;
	private boolean updated;
	
	public DetallePresupuesto() {
	}

	public DetallePresupuesto(Producto producto, double cantidad, double medida, double precioUnitario,
			Presupuesto presupuesto, String nombre, String descripcion) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.medida = medida;
		this.precioUnitario = precioUnitario;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.updated = true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_detalle_presupuesto", unique = true, nullable = false)
	public int getIdDetallePresupuesto() {
		return idDetallePresupuesto;
	}

	public void setIdDetallePresupuesto(int idDetallePresupuesto) {
		this.idDetallePresupuesto = idDetallePresupuesto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", nullable = false)
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "cantidad", nullable = false)
	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "medida", nullable = false)
	public double getMedida() {
		return medida;
	}

	public void setMedida(double medida) {
		this.medida = medida;
	}

	@Column(name = "precio_unitario", nullable = false)
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_presupuesto", nullable = false)
	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
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
		long temp;
		temp = Double.doubleToLongBits(precioUnitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		DetallePresupuesto other = (DetallePresupuesto) obj;
		if (Double.doubleToLongBits(precioUnitario) != Double
				.doubleToLongBits(other.precioUnitario))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}


}
