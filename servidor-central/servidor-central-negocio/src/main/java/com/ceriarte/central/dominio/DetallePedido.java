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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "detalle_pedido", schema = "public")
public class DetallePedido implements java.io.Serializable {
	

	private static final long serialVersionUID = -1204389399823815224L;

	private int idDetallePedido;
	private Producto producto;
	private String nombre;
	private String descripcion;
	private double cantidad;
	private double medida;
	private double precioUnitario;
	private Pedido pedido;
	private boolean updated;
	private OrdenTrabajo ordenTrabajo;
	private DetallePedidoEstado detallePedidoEstado;
	
	public DetallePedido() {
	}

	public DetallePedido(Producto producto, double medida, double cantidad,  double precioUnitario,
			Pedido pedido, String nombre, String descripcion, DetallePedidoEstado detallePedidoEstado) {
		super();
		this.producto = producto;
		this.medida = medida;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.pedido = pedido;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.updated = true;
		this.detallePedidoEstado = detallePedidoEstado;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_detalle_pedido", unique = true, nullable = false)
	public int getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
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
	@JoinColumn(name = "id_pedido", nullable = false)
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Transient
	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "detallePedido", cascade = {CascadeType.MERGE})
	public OrdenTrabajo getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_detalle_pedido_estado", nullable = false)
	public DetallePedidoEstado getDetallePedidoEstado() {
		return detallePedidoEstado;
	}

	public void setDetallePedidoEstado(DetallePedidoEstado detallePedidoEstado) {
		this.detallePedidoEstado = detallePedidoEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime
				* result
				+ ((detallePedidoEstado == null) ? 0 : detallePedidoEstado
						.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		DetallePedido other = (DetallePedido) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (detallePedidoEstado == null) {
			if (other.detallePedidoEstado != null)
				return false;
		} else if (!detallePedidoEstado.equals(other.detallePedidoEstado))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
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
