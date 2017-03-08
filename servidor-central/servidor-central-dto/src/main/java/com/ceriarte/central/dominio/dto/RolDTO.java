
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
 * Representación del Rol
 * 
 * <p>Java class for rolDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rolDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="idRol" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="permisos" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}permisos" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rolDTO", propOrder = {

})
public class RolDTO
    implements Equals, HashCode, ToString
{

    protected int idRol;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String descripcion;
    protected Permisos permisos;

    /**
     * Gets the value of the idRol property.
     * 
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * Sets the value of the idRol property.
     * 
     */
    public void setIdRol(int value) {
        this.idRol = value;
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
     * Gets the value of the permisos property.
     * 
     * @return
     *     possible object is
     *     {@link Permisos }
     *     
     */
    public Permisos getPermisos() {
        return permisos;
    }

    /**
     * Sets the value of the permisos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Permisos }
     *     
     */
    public void setPermisos(Permisos value) {
        this.permisos = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RolDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RolDTO that = ((RolDTO) object);
        {
            int lhsIdRol;
            lhsIdRol = this.getIdRol();
            int rhsIdRol;
            rhsIdRol = that.getIdRol();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idRol", lhsIdRol), LocatorUtils.property(thatLocator, "idRol", rhsIdRol), lhsIdRol, rhsIdRol)) {
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
            int theIdRol;
            theIdRol = this.getIdRol();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idRol", theIdRol), currentHashCode, theIdRol);
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
            int theIdRol;
            theIdRol = this.getIdRol();
            strategy.appendField(locator, this, "idRol", buffer, theIdRol);
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
            Permisos thePermisos;
            thePermisos = this.getPermisos();
            strategy.appendField(locator, this, "permisos", buffer, thePermisos);
        }
        return buffer;
    }

}
