
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
 * Representación de la Provincia
 * 
 * <p>Java class for provinciaDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="provinciaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="idProvincia" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pais" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}paisDTO"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "provinciaDTO", propOrder = {

})
public class ProvinciaDTO
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String idProvincia;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected PaisDTO pais;

    /**
     * Gets the value of the idProvincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProvincia() {
        return idProvincia;
    }

    /**
     * Sets the value of the idProvincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProvincia(String value) {
        this.idProvincia = value;
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
     * Gets the value of the pais property.
     * 
     * @return
     *     possible object is
     *     {@link PaisDTO }
     *     
     */
    public PaisDTO getPais() {
        return pais;
    }

    /**
     * Sets the value of the pais property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaisDTO }
     *     
     */
    public void setPais(PaisDTO value) {
        this.pais = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProvinciaDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProvinciaDTO that = ((ProvinciaDTO) object);
        {
            String lhsIdProvincia;
            lhsIdProvincia = this.getIdProvincia();
            String rhsIdProvincia;
            rhsIdProvincia = that.getIdProvincia();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idProvincia", lhsIdProvincia), LocatorUtils.property(thatLocator, "idProvincia", rhsIdProvincia), lhsIdProvincia, rhsIdProvincia)) {
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
            PaisDTO lhsPais;
            lhsPais = this.getPais();
            PaisDTO rhsPais;
            rhsPais = that.getPais();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pais", lhsPais), LocatorUtils.property(thatLocator, "pais", rhsPais), lhsPais, rhsPais)) {
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
            String theIdProvincia;
            theIdProvincia = this.getIdProvincia();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idProvincia", theIdProvincia), currentHashCode, theIdProvincia);
        }
        {
            String theNombre;
            theNombre = this.getNombre();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombre", theNombre), currentHashCode, theNombre);
        }
        {
            PaisDTO thePais;
            thePais = this.getPais();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pais", thePais), currentHashCode, thePais);
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
            String theIdProvincia;
            theIdProvincia = this.getIdProvincia();
            strategy.appendField(locator, this, "idProvincia", buffer, theIdProvincia);
        }
        {
            String theNombre;
            theNombre = this.getNombre();
            strategy.appendField(locator, this, "nombre", buffer, theNombre);
        }
        {
            PaisDTO thePais;
            thePais = this.getPais();
            strategy.appendField(locator, this, "pais", buffer, thePais);
        }
        return buffer;
    }

}
