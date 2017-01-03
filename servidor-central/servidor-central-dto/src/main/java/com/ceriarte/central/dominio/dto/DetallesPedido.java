
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
 * <p>Clase Java para detallesPedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detallesPedido"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="detallePedido" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}detallePedidoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detallesPedido", propOrder = {
    "detallePedido"
})
public class DetallesPedido
    implements Equals, HashCode, ToString
{

    protected List<DetallePedidoDTO> detallePedido;

    /**
     * Gets the value of the detallePedido property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detallePedido property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetallePedido().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetallePedidoDTO }
     * 
     * 
     */
    public List<DetallePedidoDTO> getDetallePedido() {
        if (detallePedido == null) {
            detallePedido = new ArrayList<DetallePedidoDTO>();
        }
        return this.detallePedido;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DetallesPedido)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DetallesPedido that = ((DetallesPedido) object);
        {
            List<DetallePedidoDTO> lhsDetallePedido;
            lhsDetallePedido = (((this.detallePedido!= null)&&(!this.detallePedido.isEmpty()))?this.getDetallePedido():null);
            List<DetallePedidoDTO> rhsDetallePedido;
            rhsDetallePedido = (((that.detallePedido!= null)&&(!that.detallePedido.isEmpty()))?that.getDetallePedido():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "detallePedido", lhsDetallePedido), LocatorUtils.property(thatLocator, "detallePedido", rhsDetallePedido), lhsDetallePedido, rhsDetallePedido)) {
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
            List<DetallePedidoDTO> theDetallePedido;
            theDetallePedido = (((this.detallePedido!= null)&&(!this.detallePedido.isEmpty()))?this.getDetallePedido():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "detallePedido", theDetallePedido), currentHashCode, theDetallePedido);
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
            List<DetallePedidoDTO> theDetallePedido;
            theDetallePedido = (((this.detallePedido!= null)&&(!this.detallePedido.isEmpty()))?this.getDetallePedido():null);
            strategy.appendField(locator, this, "detallePedido", buffer, theDetallePedido);
        }
        return buffer;
    }

}
