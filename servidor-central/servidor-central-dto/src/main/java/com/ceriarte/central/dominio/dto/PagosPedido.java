
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
 * <p>Java class for pagosPedido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pagosPedido"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pagoPedido" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}pagoPedidoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagosPedido", propOrder = {
    "pagoPedido"
})
public class PagosPedido
    implements Equals, HashCode, ToString
{

    protected List<PagoPedidoDTO> pagoPedido;

    /**
     * Gets the value of the pagoPedido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pagoPedido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPagoPedido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PagoPedidoDTO }
     * 
     * 
     */
    public List<PagoPedidoDTO> getPagoPedido() {
        if (pagoPedido == null) {
            pagoPedido = new ArrayList<PagoPedidoDTO>();
        }
        return this.pagoPedido;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PagosPedido)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PagosPedido that = ((PagosPedido) object);
        {
            List<PagoPedidoDTO> lhsPagoPedido;
            lhsPagoPedido = (((this.pagoPedido!= null)&&(!this.pagoPedido.isEmpty()))?this.getPagoPedido():null);
            List<PagoPedidoDTO> rhsPagoPedido;
            rhsPagoPedido = (((that.pagoPedido!= null)&&(!that.pagoPedido.isEmpty()))?that.getPagoPedido():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pagoPedido", lhsPagoPedido), LocatorUtils.property(thatLocator, "pagoPedido", rhsPagoPedido), lhsPagoPedido, rhsPagoPedido)) {
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
            List<PagoPedidoDTO> thePagoPedido;
            thePagoPedido = (((this.pagoPedido!= null)&&(!this.pagoPedido.isEmpty()))?this.getPagoPedido():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pagoPedido", thePagoPedido), currentHashCode, thePagoPedido);
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
            List<PagoPedidoDTO> thePagoPedido;
            thePagoPedido = (((this.pagoPedido!= null)&&(!this.pagoPedido.isEmpty()))?this.getPagoPedido():null);
            strategy.appendField(locator, this, "pagoPedido", buffer, thePagoPedido);
        }
        return buffer;
    }

}