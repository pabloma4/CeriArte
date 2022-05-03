
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
 * Representación de un Presupuesto
 * 
 * <p>Java class for presupuestoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="presupuestoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cliente" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}clienteDTO"/&gt;
 *         &lt;element name="presupuestoEstado" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}presupuestoEstadoDTO"/&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="fechaValidoHasta" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="detalles" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}detallesPresupuesto"/&gt;
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "presupuestoDTO", propOrder = {

})
public class PresupuestoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected ClienteDTO cliente;
    @XmlElement(required = true)
    protected PresupuestoEstadoDTO presupuestoEstado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaCreacion;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaValidoHasta;
    @XmlElement(required = true)
    protected DetallesPresupuesto detalles;
    @XmlElement(required = true)
    protected String observaciones;

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
     * Gets the value of the presupuestoEstado property.
     * 
     * @return
     *     possible object is
     *     {@link PresupuestoEstadoDTO }
     *     
     */
    public PresupuestoEstadoDTO getPresupuestoEstado() {
        return presupuestoEstado;
    }

    /**
     * Sets the value of the presupuestoEstado property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresupuestoEstadoDTO }
     *     
     */
    public void setPresupuestoEstado(PresupuestoEstadoDTO value) {
        this.presupuestoEstado = value;
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
     * Gets the value of the fechaValidoHasta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaValidoHasta() {
        return fechaValidoHasta;
    }

    /**
     * Sets the value of the fechaValidoHasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaValidoHasta(XMLGregorianCalendar value) {
        this.fechaValidoHasta = value;
    }

    /**
     * Gets the value of the detalles property.
     * 
     * @return
     *     possible object is
     *     {@link DetallesPresupuesto }
     *     
     */
    public DetallesPresupuesto getDetalles() {
        return detalles;
    }

    /**
     * Sets the value of the detalles property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetallesPresupuesto }
     *     
     */
    public void setDetalles(DetallesPresupuesto value) {
        this.detalles = value;
    }

    /**
     * Gets the value of the observaciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Sets the value of the observaciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PresupuestoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PresupuestoDTO that = ((PresupuestoDTO) object);
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
            PresupuestoEstadoDTO lhsPresupuestoEstado;
            lhsPresupuestoEstado = this.getPresupuestoEstado();
            PresupuestoEstadoDTO rhsPresupuestoEstado;
            rhsPresupuestoEstado = that.getPresupuestoEstado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "presupuestoEstado", lhsPresupuestoEstado), LocatorUtils.property(thatLocator, "presupuestoEstado", rhsPresupuestoEstado), lhsPresupuestoEstado, rhsPresupuestoEstado)) {
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
            XMLGregorianCalendar lhsFechaValidoHasta;
            lhsFechaValidoHasta = this.getFechaValidoHasta();
            XMLGregorianCalendar rhsFechaValidoHasta;
            rhsFechaValidoHasta = that.getFechaValidoHasta();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechaValidoHasta", lhsFechaValidoHasta), LocatorUtils.property(thatLocator, "fechaValidoHasta", rhsFechaValidoHasta), lhsFechaValidoHasta, rhsFechaValidoHasta)) {
                return false;
            }
        }
        {
            DetallesPresupuesto lhsDetalles;
            lhsDetalles = this.getDetalles();
            DetallesPresupuesto rhsDetalles;
            rhsDetalles = that.getDetalles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "detalles", lhsDetalles), LocatorUtils.property(thatLocator, "detalles", rhsDetalles), lhsDetalles, rhsDetalles)) {
                return false;
            }
        }
        {
            String lhsObservaciones;
            lhsObservaciones = this.getObservaciones();
            String rhsObservaciones;
            rhsObservaciones = that.getObservaciones();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "observaciones", lhsObservaciones), LocatorUtils.property(thatLocator, "observaciones", rhsObservaciones), lhsObservaciones, rhsObservaciones)) {
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
            PresupuestoEstadoDTO thePresupuestoEstado;
            thePresupuestoEstado = this.getPresupuestoEstado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "presupuestoEstado", thePresupuestoEstado), currentHashCode, thePresupuestoEstado);
        }
        {
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaCreacion", theFechaCreacion), currentHashCode, theFechaCreacion);
        }
        {
            XMLGregorianCalendar theFechaValidoHasta;
            theFechaValidoHasta = this.getFechaValidoHasta();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaValidoHasta", theFechaValidoHasta), currentHashCode, theFechaValidoHasta);
        }
        {
            DetallesPresupuesto theDetalles;
            theDetalles = this.getDetalles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "detalles", theDetalles), currentHashCode, theDetalles);
        }
        {
            String theObservaciones;
            theObservaciones = this.getObservaciones();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "observaciones", theObservaciones), currentHashCode, theObservaciones);
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
            PresupuestoEstadoDTO thePresupuestoEstado;
            thePresupuestoEstado = this.getPresupuestoEstado();
            strategy.appendField(locator, this, "presupuestoEstado", buffer, thePresupuestoEstado);
        }
        {
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            strategy.appendField(locator, this, "fechaCreacion", buffer, theFechaCreacion);
        }
        {
            XMLGregorianCalendar theFechaValidoHasta;
            theFechaValidoHasta = this.getFechaValidoHasta();
            strategy.appendField(locator, this, "fechaValidoHasta", buffer, theFechaValidoHasta);
        }
        {
            DetallesPresupuesto theDetalles;
            theDetalles = this.getDetalles();
            strategy.appendField(locator, this, "detalles", buffer, theDetalles);
        }
        {
            String theObservaciones;
            theObservaciones = this.getObservaciones();
            strategy.appendField(locator, this, "observaciones", buffer, theObservaciones);
        }
        return buffer;
    }

}
