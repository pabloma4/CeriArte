
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
 * Representación de un Detalle de Presupuesto para visualizar en un reporte
 * 
 * <p>Java class for detalleOrdenTrabajoReporteDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="detalleOrdenTrabajoReporteDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcionProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleOrdenTrabajoReporteDTO", propOrder = {

})
public class DetalleOrdenTrabajoReporteDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    protected int idProducto;
    @XmlElement(required = true)
    protected String nombreProducto;
    @XmlElement(required = true)
    protected String descripcionProducto;
    @XmlElement(required = true)
    protected String cantidad;

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
     * Gets the value of the idProducto property.
     * 
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Sets the value of the idProducto property.
     * 
     */
    public void setIdProducto(int value) {
        this.idProducto = value;
    }

    /**
     * Gets the value of the nombreProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Sets the value of the nombreProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProducto(String value) {
        this.nombreProducto = value;
    }

    /**
     * Gets the value of the descripcionProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * Sets the value of the descripcionProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionProducto(String value) {
        this.descripcionProducto = value;
    }

    /**
     * Gets the value of the cantidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantidad(String value) {
        this.cantidad = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DetalleOrdenTrabajoReporteDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DetalleOrdenTrabajoReporteDTO that = ((DetalleOrdenTrabajoReporteDTO) object);
        {
            int lhsId;
            lhsId = this.getId();
            int rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            int lhsIdProducto;
            lhsIdProducto = this.getIdProducto();
            int rhsIdProducto;
            rhsIdProducto = that.getIdProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idProducto", lhsIdProducto), LocatorUtils.property(thatLocator, "idProducto", rhsIdProducto), lhsIdProducto, rhsIdProducto)) {
                return false;
            }
        }
        {
            String lhsNombreProducto;
            lhsNombreProducto = this.getNombreProducto();
            String rhsNombreProducto;
            rhsNombreProducto = that.getNombreProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nombreProducto", lhsNombreProducto), LocatorUtils.property(thatLocator, "nombreProducto", rhsNombreProducto), lhsNombreProducto, rhsNombreProducto)) {
                return false;
            }
        }
        {
            String lhsDescripcionProducto;
            lhsDescripcionProducto = this.getDescripcionProducto();
            String rhsDescripcionProducto;
            rhsDescripcionProducto = that.getDescripcionProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcionProducto", lhsDescripcionProducto), LocatorUtils.property(thatLocator, "descripcionProducto", rhsDescripcionProducto), lhsDescripcionProducto, rhsDescripcionProducto)) {
                return false;
            }
        }
        {
            String lhsCantidad;
            lhsCantidad = this.getCantidad();
            String rhsCantidad;
            rhsCantidad = that.getCantidad();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cantidad", lhsCantidad), LocatorUtils.property(thatLocator, "cantidad", rhsCantidad), lhsCantidad, rhsCantidad)) {
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
            int theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            int theIdProducto;
            theIdProducto = this.getIdProducto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idProducto", theIdProducto), currentHashCode, theIdProducto);
        }
        {
            String theNombreProducto;
            theNombreProducto = this.getNombreProducto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombreProducto", theNombreProducto), currentHashCode, theNombreProducto);
        }
        {
            String theDescripcionProducto;
            theDescripcionProducto = this.getDescripcionProducto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcionProducto", theDescripcionProducto), currentHashCode, theDescripcionProducto);
        }
        {
            String theCantidad;
            theCantidad = this.getCantidad();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cantidad", theCantidad), currentHashCode, theCantidad);
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
            int theIdProducto;
            theIdProducto = this.getIdProducto();
            strategy.appendField(locator, this, "idProducto", buffer, theIdProducto);
        }
        {
            String theNombreProducto;
            theNombreProducto = this.getNombreProducto();
            strategy.appendField(locator, this, "nombreProducto", buffer, theNombreProducto);
        }
        {
            String theDescripcionProducto;
            theDescripcionProducto = this.getDescripcionProducto();
            strategy.appendField(locator, this, "descripcionProducto", buffer, theDescripcionProducto);
        }
        {
            String theCantidad;
            theCantidad = this.getCantidad();
            strategy.appendField(locator, this, "cantidad", buffer, theCantidad);
        }
        return buffer;
    }

}
