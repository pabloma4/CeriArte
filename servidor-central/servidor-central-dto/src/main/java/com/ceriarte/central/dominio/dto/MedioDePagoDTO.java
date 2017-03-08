
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
 * <p>Java class for medioDePagoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="medioDePagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="abreviatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="habilitado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "medioDePagoDTO", propOrder = {
    "id",
    "descripcion",
    "abreviatura",
    "habilitado"
})
public class MedioDePagoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected String descripcion;
    protected String abreviatura;
    protected boolean habilitado;

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
     * Gets the value of the abreviatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Sets the value of the abreviatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbreviatura(String value) {
        this.abreviatura = value;
    }

    /**
     * Gets the value of the habilitado property.
     * 
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * Sets the value of the habilitado property.
     * 
     */
    public void setHabilitado(boolean value) {
        this.habilitado = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof MedioDePagoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final MedioDePagoDTO that = ((MedioDePagoDTO) object);
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
            String lhsDescripcion;
            lhsDescripcion = this.getDescripcion();
            String rhsDescripcion;
            rhsDescripcion = that.getDescripcion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcion", lhsDescripcion), LocatorUtils.property(thatLocator, "descripcion", rhsDescripcion), lhsDescripcion, rhsDescripcion)) {
                return false;
            }
        }
        {
            String lhsAbreviatura;
            lhsAbreviatura = this.getAbreviatura();
            String rhsAbreviatura;
            rhsAbreviatura = that.getAbreviatura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "abreviatura", lhsAbreviatura), LocatorUtils.property(thatLocator, "abreviatura", rhsAbreviatura), lhsAbreviatura, rhsAbreviatura)) {
                return false;
            }
        }
        {
            boolean lhsHabilitado;
            lhsHabilitado = this.isHabilitado();
            boolean rhsHabilitado;
            rhsHabilitado = that.isHabilitado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "habilitado", lhsHabilitado), LocatorUtils.property(thatLocator, "habilitado", rhsHabilitado), lhsHabilitado, rhsHabilitado)) {
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
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
        }
        {
            String theAbreviatura;
            theAbreviatura = this.getAbreviatura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abreviatura", theAbreviatura), currentHashCode, theAbreviatura);
        }
        {
            boolean theHabilitado;
            theHabilitado = this.isHabilitado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "habilitado", theHabilitado), currentHashCode, theHabilitado);
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
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            strategy.appendField(locator, this, "descripcion", buffer, theDescripcion);
        }
        {
            String theAbreviatura;
            theAbreviatura = this.getAbreviatura();
            strategy.appendField(locator, this, "abreviatura", buffer, theAbreviatura);
        }
        {
            boolean theHabilitado;
            theHabilitado = this.isHabilitado();
            strategy.appendField(locator, this, "habilitado", buffer, theHabilitado);
        }
        return buffer;
    }

}
