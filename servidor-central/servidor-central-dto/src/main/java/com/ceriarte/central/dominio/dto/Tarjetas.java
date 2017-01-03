
package com.ceriarte.central.dominio.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Clase Java para tarjetas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tarjetas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tarjeta" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}tarjetaDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tarjetas", propOrder = {
    "tarjeta"
})
public class Tarjetas
    implements Equals, HashCode, ToString
{

    protected List<TarjetaDTO> tarjeta;

    /**
     * Gets the value of the tarjeta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tarjeta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTarjeta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TarjetaDTO }
     * 
     * 
     */
    public List<TarjetaDTO> getTarjeta() {
        if (tarjeta == null) {
            tarjeta = new ArrayList<TarjetaDTO>();
        }
        return this.tarjeta;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Tarjetas)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Tarjetas that = ((Tarjetas) object);
        {
            List<TarjetaDTO> lhsTarjeta;
            lhsTarjeta = (((this.tarjeta!= null)&&(!this.tarjeta.isEmpty()))?this.getTarjeta():null);
            List<TarjetaDTO> rhsTarjeta;
            rhsTarjeta = (((that.tarjeta!= null)&&(!that.tarjeta.isEmpty()))?that.getTarjeta():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tarjeta", lhsTarjeta), LocatorUtils.property(thatLocator, "tarjeta", rhsTarjeta), lhsTarjeta, rhsTarjeta)) {
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
            List<TarjetaDTO> theTarjeta;
            theTarjeta = (((this.tarjeta!= null)&&(!this.tarjeta.isEmpty()))?this.getTarjeta():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tarjeta", theTarjeta), currentHashCode, theTarjeta);
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
            List<TarjetaDTO> theTarjeta;
            theTarjeta = (((this.tarjeta!= null)&&(!this.tarjeta.isEmpty()))?this.getTarjeta():null);
            strategy.appendField(locator, this, "tarjeta", buffer, theTarjeta);
        }
        return buffer;
    }

}
