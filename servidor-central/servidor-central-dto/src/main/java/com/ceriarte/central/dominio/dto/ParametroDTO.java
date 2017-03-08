
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
 * Representación de un Parámetro
 * 
 * <p>Java class for parametroDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parametroDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="idParametro" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametroDTO", propOrder = {

})
public class ParametroDTO
    implements Equals, HashCode, ToString
{

    protected int idParametro;
    @XmlElement(required = true)
    protected String clave;
    protected String valor;
    protected String descripcion;

    /**
     * Gets the value of the idParametro property.
     * 
     */
    public int getIdParametro() {
        return idParametro;
    }

    /**
     * Sets the value of the idParametro property.
     * 
     */
    public void setIdParametro(int value) {
        this.idParametro = value;
    }

    /**
     * Gets the value of the clave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Sets the value of the clave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

    /**
     * Gets the value of the valor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValor() {
        return valor;
    }

    /**
     * Sets the value of the valor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValor(String value) {
        this.valor = value;
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
        if (!(object instanceof ParametroDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ParametroDTO that = ((ParametroDTO) object);
        {
            int lhsIdParametro;
            lhsIdParametro = this.getIdParametro();
            int rhsIdParametro;
            rhsIdParametro = that.getIdParametro();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idParametro", lhsIdParametro), LocatorUtils.property(thatLocator, "idParametro", rhsIdParametro), lhsIdParametro, rhsIdParametro)) {
                return false;
            }
        }
        {
            String lhsClave;
            lhsClave = this.getClave();
            String rhsClave;
            rhsClave = that.getClave();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clave", lhsClave), LocatorUtils.property(thatLocator, "clave", rhsClave), lhsClave, rhsClave)) {
                return false;
            }
        }
        {
            String lhsValor;
            lhsValor = this.getValor();
            String rhsValor;
            rhsValor = that.getValor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valor", lhsValor), LocatorUtils.property(thatLocator, "valor", rhsValor), lhsValor, rhsValor)) {
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
            int theIdParametro;
            theIdParametro = this.getIdParametro();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idParametro", theIdParametro), currentHashCode, theIdParametro);
        }
        {
            String theClave;
            theClave = this.getClave();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clave", theClave), currentHashCode, theClave);
        }
        {
            String theValor;
            theValor = this.getValor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valor", theValor), currentHashCode, theValor);
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
            int theIdParametro;
            theIdParametro = this.getIdParametro();
            strategy.appendField(locator, this, "idParametro", buffer, theIdParametro);
        }
        {
            String theClave;
            theClave = this.getClave();
            strategy.appendField(locator, this, "clave", buffer, theClave);
        }
        {
            String theValor;
            theValor = this.getValor();
            strategy.appendField(locator, this, "valor", buffer, theValor);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            strategy.appendField(locator, this, "descripcion", buffer, theDescripcion);
        }
        return buffer;
    }

}
