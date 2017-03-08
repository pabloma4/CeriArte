
package com.ceriarte.central.dominio.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 * Representación de un Pago del Pedido
 * 
 * <p>Java class for pagoPedidoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pagoPedidoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="medioDePago" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}medioDePagoDTO"/&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="pedido" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}pedidoDTO"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagoPedidoDTO", propOrder = {

})
public class PagoPedidoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaCreacion;
    @XmlElement(required = true)
    protected MedioDePagoDTO medioDePago;
    protected double monto;
    @XmlElement(required = true)
    protected PedidoDTO pedido;

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
     * Gets the value of the fechaCreacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets the value of the fechaCreacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCreacion(XMLGregorianCalendar value) {
        this.fechaCreacion = value;
    }

    /**
     * Gets the value of the medioDePago property.
     * 
     * @return
     *     possible object is
     *     {@link MedioDePagoDTO }
     *     
     */
    public MedioDePagoDTO getMedioDePago() {
        return medioDePago;
    }

    /**
     * Sets the value of the medioDePago property.
     * 
     * @param value
     *     allowed object is
     *     {@link MedioDePagoDTO }
     *     
     */
    public void setMedioDePago(MedioDePagoDTO value) {
        this.medioDePago = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     */
    public void setMonto(double value) {
        this.monto = value;
    }

    /**
     * Gets the value of the pedido property.
     * 
     * @return
     *     possible object is
     *     {@link PedidoDTO }
     *     
     */
    public PedidoDTO getPedido() {
        return pedido;
    }

    /**
     * Sets the value of the pedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link PedidoDTO }
     *     
     */
    public void setPedido(PedidoDTO value) {
        this.pedido = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PagoPedidoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PagoPedidoDTO that = ((PagoPedidoDTO) object);
        {
            XMLGregorianCalendar lhsFechaCreacion;
            lhsFechaCreacion = this.getFechaCreacion();
            XMLGregorianCalendar rhsFechaCreacion;
            rhsFechaCreacion = that.getFechaCreacion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechaCreacion", lhsFechaCreacion), LocatorUtils.property(thatLocator, "fechaCreacion", rhsFechaCreacion), lhsFechaCreacion, rhsFechaCreacion)) {
                return false;
            }
        }
        {
            MedioDePagoDTO lhsMedioDePago;
            lhsMedioDePago = this.getMedioDePago();
            MedioDePagoDTO rhsMedioDePago;
            rhsMedioDePago = that.getMedioDePago();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "medioDePago", lhsMedioDePago), LocatorUtils.property(thatLocator, "medioDePago", rhsMedioDePago), lhsMedioDePago, rhsMedioDePago)) {
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
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaCreacion", theFechaCreacion), currentHashCode, theFechaCreacion);
        }
        {
            MedioDePagoDTO theMedioDePago;
            theMedioDePago = this.getMedioDePago();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "medioDePago", theMedioDePago), currentHashCode, theMedioDePago);
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
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            strategy.appendField(locator, this, "fechaCreacion", buffer, theFechaCreacion);
        }
        {
            MedioDePagoDTO theMedioDePago;
            theMedioDePago = this.getMedioDePago();
            strategy.appendField(locator, this, "medioDePago", buffer, theMedioDePago);
        }
        {
            double theMonto;
            theMonto = this.getMonto();
            strategy.appendField(locator, this, "monto", buffer, theMonto);
        }
        {
            PedidoDTO thePedido;
            thePedido = this.getPedido();
            strategy.appendField(locator, this, "pedido", buffer, thePedido);
        }
        return buffer;
    }

}
