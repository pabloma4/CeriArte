
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
 * <p>Clase Java para tiposMedioDePago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tiposMedioDePago"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipoMedioDePago" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}tipoMedioDePagoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tiposMedioDePago", propOrder = {
    "tipoMedioDePago"
})
public class TiposMedioDePago
    implements Equals, HashCode, ToString
{

    protected List<TipoMedioDePagoDTO> tipoMedioDePago;

    /**
     * Gets the value of the tipoMedioDePago property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoMedioDePago property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoMedioDePago().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoMedioDePagoDTO }
     * 
     * 
     */
    public List<TipoMedioDePagoDTO> getTipoMedioDePago() {
        if (tipoMedioDePago == null) {
            tipoMedioDePago = new ArrayList<TipoMedioDePagoDTO>();
        }
        return this.tipoMedioDePago;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TiposMedioDePago)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TiposMedioDePago that = ((TiposMedioDePago) object);
        {
            List<TipoMedioDePagoDTO> lhsTipoMedioDePago;
            lhsTipoMedioDePago = (((this.tipoMedioDePago!= null)&&(!this.tipoMedioDePago.isEmpty()))?this.getTipoMedioDePago():null);
            List<TipoMedioDePagoDTO> rhsTipoMedioDePago;
            rhsTipoMedioDePago = (((that.tipoMedioDePago!= null)&&(!that.tipoMedioDePago.isEmpty()))?that.getTipoMedioDePago():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tipoMedioDePago", lhsTipoMedioDePago), LocatorUtils.property(thatLocator, "tipoMedioDePago", rhsTipoMedioDePago), lhsTipoMedioDePago, rhsTipoMedioDePago)) {
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
            List<TipoMedioDePagoDTO> theTipoMedioDePago;
            theTipoMedioDePago = (((this.tipoMedioDePago!= null)&&(!this.tipoMedioDePago.isEmpty()))?this.getTipoMedioDePago():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tipoMedioDePago", theTipoMedioDePago), currentHashCode, theTipoMedioDePago);
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
            List<TipoMedioDePagoDTO> theTipoMedioDePago;
            theTipoMedioDePago = (((this.tipoMedioDePago!= null)&&(!this.tipoMedioDePago.isEmpty()))?this.getTipoMedioDePago():null);
            strategy.appendField(locator, this, "tipoMedioDePago", buffer, theTipoMedioDePago);
        }
        return buffer;
    }

}
