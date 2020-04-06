
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
 * Representación de un Pedido
 * 
 * <p>Java class for pedidoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pedidoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cliente" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}clienteDTO"/&gt;
 *         &lt;element name="pedidoEstado" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}pedidoEstadoDTO"/&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="detalles" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}detallesPedido" minOccurs="0"/&gt;
 *         &lt;element name="pagos" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}pagosPedido" minOccurs="0"/&gt;
 *         &lt;element name="presupuesto" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}presupuestoDTO" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pedidoDTO", propOrder = {

})
public class PedidoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected ClienteDTO cliente;
    @XmlElement(required = true)
    protected PedidoEstadoDTO pedidoEstado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaCreacion;
    protected DetallesPedido detalles;
    protected PagosPedido pagos;
    protected PresupuestoDTO presupuesto;

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
     * Gets the value of the cliente property.
     * 
     * @return
     *     possible object is
     *     {@link ClienteDTO }
     *     
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClienteDTO }
     *     
     */
    public void setCliente(ClienteDTO value) {
        this.cliente = value;
    }

    /**
     * Gets the value of the pedidoEstado property.
     * 
     * @return
     *     possible object is
     *     {@link PedidoEstadoDTO }
     *     
     */
    public PedidoEstadoDTO getPedidoEstado() {
        return pedidoEstado;
    }

    /**
     * Sets the value of the pedidoEstado property.
     * 
     * @param value
     *     allowed object is
     *     {@link PedidoEstadoDTO }
     *     
     */
    public void setPedidoEstado(PedidoEstadoDTO value) {
        this.pedidoEstado = value;
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
     * Gets the value of the detalles property.
     * 
     * @return
     *     possible object is
     *     {@link DetallesPedido }
     *     
     */
    public DetallesPedido getDetalles() {
        return detalles;
    }

    /**
     * Sets the value of the detalles property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetallesPedido }
     *     
     */
    public void setDetalles(DetallesPedido value) {
        this.detalles = value;
    }

    /**
     * Gets the value of the pagos property.
     * 
     * @return
     *     possible object is
     *     {@link PagosPedido }
     *     
     */
    public PagosPedido getPagos() {
        return pagos;
    }

    /**
     * Sets the value of the pagos property.
     * 
     * @param value
     *     allowed object is
     *     {@link PagosPedido }
     *     
     */
    public void setPagos(PagosPedido value) {
        this.pagos = value;
    }

    /**
     * Gets the value of the presupuesto property.
     * 
     * @return
     *     possible object is
     *     {@link PresupuestoDTO }
     *     
     */
    public PresupuestoDTO getPresupuesto() {
        return presupuesto;
    }

    /**
     * Sets the value of the presupuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresupuestoDTO }
     *     
     */
    public void setPresupuesto(PresupuestoDTO value) {
        this.presupuesto = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PedidoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PedidoDTO that = ((PedidoDTO) object);
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
            ClienteDTO lhsCliente;
            lhsCliente = this.getCliente();
            ClienteDTO rhsCliente;
            rhsCliente = that.getCliente();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cliente", lhsCliente), LocatorUtils.property(thatLocator, "cliente", rhsCliente), lhsCliente, rhsCliente)) {
                return false;
            }
        }
        {
            PedidoEstadoDTO lhsPedidoEstado;
            lhsPedidoEstado = this.getPedidoEstado();
            PedidoEstadoDTO rhsPedidoEstado;
            rhsPedidoEstado = that.getPedidoEstado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pedidoEstado", lhsPedidoEstado), LocatorUtils.property(thatLocator, "pedidoEstado", rhsPedidoEstado), lhsPedidoEstado, rhsPedidoEstado)) {
                return false;
            }
        }
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
            DetallesPedido lhsDetalles;
            lhsDetalles = this.getDetalles();
            DetallesPedido rhsDetalles;
            rhsDetalles = that.getDetalles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "detalles", lhsDetalles), LocatorUtils.property(thatLocator, "detalles", rhsDetalles), lhsDetalles, rhsDetalles)) {
                return false;
            }
        }
        {
            PagosPedido lhsPagos;
            lhsPagos = this.getPagos();
            PagosPedido rhsPagos;
            rhsPagos = that.getPagos();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pagos", lhsPagos), LocatorUtils.property(thatLocator, "pagos", rhsPagos), lhsPagos, rhsPagos)) {
                return false;
            }
        }
        {
            PresupuestoDTO lhsPresupuesto;
            lhsPresupuesto = this.getPresupuesto();
            PresupuestoDTO rhsPresupuesto;
            rhsPresupuesto = that.getPresupuesto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "presupuesto", lhsPresupuesto), LocatorUtils.property(thatLocator, "presupuesto", rhsPresupuesto), lhsPresupuesto, rhsPresupuesto)) {
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
            ClienteDTO theCliente;
            theCliente = this.getCliente();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cliente", theCliente), currentHashCode, theCliente);
        }
        {
            PedidoEstadoDTO thePedidoEstado;
            thePedidoEstado = this.getPedidoEstado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pedidoEstado", thePedidoEstado), currentHashCode, thePedidoEstado);
        }
        {
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaCreacion", theFechaCreacion), currentHashCode, theFechaCreacion);
        }
        {
            DetallesPedido theDetalles;
            theDetalles = this.getDetalles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "detalles", theDetalles), currentHashCode, theDetalles);
        }
        {
            PagosPedido thePagos;
            thePagos = this.getPagos();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pagos", thePagos), currentHashCode, thePagos);
        }
        {
            PresupuestoDTO thePresupuesto;
            thePresupuesto = this.getPresupuesto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "presupuesto", thePresupuesto), currentHashCode, thePresupuesto);
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
            ClienteDTO theCliente;
            theCliente = this.getCliente();
            strategy.appendField(locator, this, "cliente", buffer, theCliente);
        }
        {
            PedidoEstadoDTO thePedidoEstado;
            thePedidoEstado = this.getPedidoEstado();
            strategy.appendField(locator, this, "pedidoEstado", buffer, thePedidoEstado);
        }
        {
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            strategy.appendField(locator, this, "fechaCreacion", buffer, theFechaCreacion);
        }
        {
            DetallesPedido theDetalles;
            theDetalles = this.getDetalles();
            strategy.appendField(locator, this, "detalles", buffer, theDetalles);
        }
        {
            PagosPedido thePagos;
            thePagos = this.getPagos();
            strategy.appendField(locator, this, "pagos", buffer, thePagos);
        }
        {
            PresupuestoDTO thePresupuesto;
            thePresupuesto = this.getPresupuesto();
            strategy.appendField(locator, this, "presupuesto", buffer, thePresupuesto);
        }
        return buffer;
    }

}
