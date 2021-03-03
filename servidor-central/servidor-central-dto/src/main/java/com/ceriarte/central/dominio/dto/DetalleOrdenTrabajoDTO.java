
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
 * Representación de un Detalle de Orden Trabajo
 * 
 * <p>Java class for detalleOrdenTrabajoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detalleOrdenTrabajoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="producto" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}productoDTO"/&gt;
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleOrdenTrabajoDTO", propOrder = {

})
public class DetalleOrdenTrabajoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected ProductoDTO producto;
    protected double cantidad;

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DetalleOrdenTrabajoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DetalleOrdenTrabajoDTO that = ((DetalleOrdenTrabajoDTO) object);
        {
            ProductoDTO lhsProducto;
            lhsProducto = this.getProducto();
            ProductoDTO rhsProducto;
            rhsProducto = that.getProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "producto", lhsProducto), LocatorUtils.property(thatLocator, "producto", rhsProducto), lhsProducto, rhsProducto)) {
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
            double theCantidad;
            theCantidad = this.getCantidad();
            strategy.appendField(locator, this, "cantidad", buffer, theCantidad);
        }
        return buffer;
    }

}
