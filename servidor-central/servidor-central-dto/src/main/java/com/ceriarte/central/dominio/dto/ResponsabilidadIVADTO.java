
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
 * Representación de la Responsabilidad frente al IVA
 * 
 * <p>Java class for responsabilidadIVADTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responsabilidadIVADTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="idResponsabilidadIVA" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responsabilidadIVADTO", propOrder = {

})
public class ResponsabilidadIVADTO
    implements Equals, HashCode, ToString
{

    protected int idResponsabilidadIVA;
    @XmlElement(required = true)
    protected String descripcion;

    /**
     * Gets the value of the idResponsabilidadIVA property.
     * 
     */
    public int getIdResponsabilidadIVA() {
        return idResponsabilidadIVA;
    }

    /**
     * Sets the value of the idResponsabilidadIVA property.
     * 
     */
    public void setIdResponsabilidadIVA(int value) {
        this.idResponsabilidadIVA = value;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ResponsabilidadIVADTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ResponsabilidadIVADTO that = ((ResponsabilidadIVADTO) object);
        {
            int lhsIdResponsabilidadIVA;
            lhsIdResponsabilidadIVA = this.getIdResponsabilidadIVA();
            int rhsIdResponsabilidadIVA;
            rhsIdResponsabilidadIVA = that.getIdResponsabilidadIVA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idResponsabilidadIVA", lhsIdResponsabilidadIVA), LocatorUtils.property(thatLocator, "idResponsabilidadIVA", rhsIdResponsabilidadIVA), lhsIdResponsabilidadIVA, rhsIdResponsabilidadIVA)) {
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
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theIdResponsabilidadIVA;
            theIdResponsabilidadIVA = this.getIdResponsabilidadIVA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idResponsabilidadIVA", theIdResponsabilidadIVA), currentHashCode, theIdResponsabilidadIVA);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
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
            int theIdResponsabilidadIVA;
            theIdResponsabilidadIVA = this.getIdResponsabilidadIVA();
            strategy.appendField(locator, this, "idResponsabilidadIVA", buffer, theIdResponsabilidadIVA);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            strategy.appendField(locator, this, "descripcion", buffer, theDescripcion);
        }
        return buffer;
    }

}
