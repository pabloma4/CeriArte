
package com.ceriarte.central.dominio.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * Representación de un Detalle de Presupuesto
 * 
 * <p>Java class for detallePresupuestoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detallePresupuestoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="producto" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}productoDTO"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="medida" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="precioUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detallePresupuestoDTO", propOrder = {

})
public class DetallePresupuestoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected ProductoDTO producto;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String descripcion;
    protected double medida;
    protected double cantidad;
    protected double precioUnitario;
    protected double monto;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the producto property.
     * 
     * @return
     *     possible object is
     *     {@link ProductoDTO }
     *     
     */
    public ProductoDTO getProducto() {
        return producto;
    }

    /**
     * Sets the value of the producto property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductoDTO }
     *     
     */
    public void setProducto(ProductoDTO value) {
        this.producto = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the medida property.
     * 
     */
    public double getMedida() {
        return medida;
    }

    /**
     * Sets the value of the medida property.
     * 
     */
    public void setMedida(double value) {
        this.medida = value;
    }

    /**
     * Gets the value of the cantidad property.
     * 
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     */
    public void setCantidad(double value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the precioUnitario property.
     * 
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Sets the value of the precioUnitario property.
     * 
     */
    public void setPrecioUnitario(double value) {
        this.precioUnitario = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     */
    public void setMonto(double value) {
        this.monto = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DetallePresupuestoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DetallePresupuestoDTO that = ((DetallePresupuestoDTO) object);
        {
            ProductoDTO lhsProducto;
            lhsProducto = this.getProducto();
            ProductoDTO rhsProducto;
            rhsProducto = that.getProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "producto", lhsProducto), LocatorUtils.property(thatLocator, "producto", rhsProducto), lhsProducto, rhsProducto)) {
                return false;
            }
        }
        {
            String lhsNombre;
            lhsNombre = this.getNombre();
            String rhsNombre;
            rhsNombre = that.getNombre();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nombre", lhsNombre), LocatorUtils.property(thatLocator, "nombre", rhsNombre), lhsNombre, rhsNombre)) {
                return false;
            }
        }
        {
            String lhsDescripcion;
            lhsDescripcion = this.getDescripcion();
            String rhsDescripcion;
            rhsDescripcion = that.getDescripcion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcion", lhsDescripcion), LocatorUtils.property(thatLocator, "descripcion", rhsDescripcion), lhsDescripcion, rhsDescripcion)) {
                return false;
            }
        }
        {
            double lhsMedida;
            lhsMedida = this.getMedida();
            double rhsMedida;
            rhsMedida = that.getMedida();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "medida", lhsMedida), LocatorUtils.property(thatLocator, "medida", rhsMedida), lhsMedida, rhsMedida)) {
                return false;
            }
        }
        {
            double lhsPrecioUnitario;
            lhsPrecioUnitario = this.getPrecioUnitario();
            double rhsPrecioUnitario;
            rhsPrecioUnitario = that.getPrecioUnitario();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "precioUnitario", lhsPrecioUnitario), LocatorUtils.property(thatLocator, "precioUnitario", rhsPrecioUnitario), lhsPrecioUnitario, rhsPrecioUnitario)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ProductoDTO theProducto;
            theProducto = this.getProducto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "producto", theProducto), currentHashCode, theProducto);
        }
        {
            String theNombre;
            theNombre = this.getNombre();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombre", theNombre), currentHashCode, theNombre);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
        }
        {
            double theMedida;
            theMedida = this.getMedida();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "medida", theMedida), currentHashCode, theMedida);
        }
        {
            double thePrecioUnitario;
            thePrecioUnitario = this.getPrecioUnitario();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "precioUnitario", thePrecioUnitario), currentHashCode, thePrecioUnitario);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            int theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            ProductoDTO theProducto;
            theProducto = this.getProducto();
            strategy.appendField(locator, this, "producto", buffer, theProducto);
        }
        {
            String theNombre;
            theNombre = this.getNombre();
            strategy.appendField(locator, this, "nombre", buffer, theNombre);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            strategy.appendField(locator, this, "descripcion", buffer, theDescripcion);
        }
        {
            double theMedida;
            theMedida = this.getMedida();
            strategy.appendField(locator, this, "medida", buffer, theMedida);
        }
        {
            double theCantidad;
            theCantidad = this.getCantidad();
            strategy.appendField(locator, this, "cantidad", buffer, theCantidad);
        }
        {
            double thePrecioUnitario;
            thePrecioUnitario = this.getPrecioUnitario();
            strategy.appendField(locator, this, "precioUnitario", buffer, thePrecioUnitario);
        }
        {
            double theMonto;
            theMonto = this.getMonto();
            strategy.appendField(locator, this, "monto", buffer, theMonto);
        }
        return buffer;
    }

}
