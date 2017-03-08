
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
 * Representación de una Orden de Trabajo
 * 
 * <p>Java class for ordenTrabajoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ordenTrabajoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="creadaPor" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}usuarioDTO"/&gt;
 *         &lt;element name="asignadaA" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}usuarioDTO" minOccurs="0"/&gt;
 *         &lt;element name="ordenTrabajoEstado" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}ordenTrabajoEstadoDTO"/&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="fechaEstimadaFin" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="detalles" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}detallesOrdenTrabajo"/&gt;
 *         &lt;element name="detallePedido" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}detallePedidoDTO"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ordenTrabajoDTO", propOrder = {

})
public class OrdenTrabajoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected UsuarioDTO creadaPor;
    protected UsuarioDTO asignadaA;
    @XmlElement(required = true)
    protected OrdenTrabajoEstadoDTO ordenTrabajoEstado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaCreacion;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaEstimadaFin;
    @XmlElement(required = true)
    protected DetallesOrdenTrabajo detalles;
    @XmlElement(required = true)
    protected DetallePedidoDTO detallePedido;

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
     * Gets the value of the creadaPor property.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioDTO }
     *     
     */
    public UsuarioDTO getCreadaPor() {
        return creadaPor;
    }

    /**
     * Sets the value of the creadaPor property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioDTO }
     *     
     */
    public void setCreadaPor(UsuarioDTO value) {
        this.creadaPor = value;
    }

    /**
     * Gets the value of the asignadaA property.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioDTO }
     *     
     */
    public UsuarioDTO getAsignadaA() {
        return asignadaA;
    }

    /**
     * Sets the value of the asignadaA property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioDTO }
     *     
     */
    public void setAsignadaA(UsuarioDTO value) {
        this.asignadaA = value;
    }

    /**
     * Gets the value of the ordenTrabajoEstado property.
     * 
     * @return
     *     possible object is
     *     {@link OrdenTrabajoEstadoDTO }
     *     
     */
    public OrdenTrabajoEstadoDTO getOrdenTrabajoEstado() {
        return ordenTrabajoEstado;
    }

    /**
     * Sets the value of the ordenTrabajoEstado property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrdenTrabajoEstadoDTO }
     *     
     */
    public void setOrdenTrabajoEstado(OrdenTrabajoEstadoDTO value) {
        this.ordenTrabajoEstado = value;
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
     * Gets the value of the fechaEstimadaFin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEstimadaFin() {
        return fechaEstimadaFin;
    }

    /**
     * Sets the value of the fechaEstimadaFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEstimadaFin(XMLGregorianCalendar value) {
        this.fechaEstimadaFin = value;
    }

    /**
     * Gets the value of the detalles property.
     * 
     * @return
     *     possible object is
     *     {@link DetallesOrdenTrabajo }
     *     
     */
    public DetallesOrdenTrabajo getDetalles() {
        return detalles;
    }

    /**
     * Sets the value of the detalles property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetallesOrdenTrabajo }
     *     
     */
    public void setDetalles(DetallesOrdenTrabajo value) {
        this.detalles = value;
    }

    /**
     * Gets the value of the detallePedido property.
     * 
     * @return
     *     possible object is
     *     {@link DetallePedidoDTO }
     *     
     */
    public DetallePedidoDTO getDetallePedido() {
        return detallePedido;
    }

    /**
     * Sets the value of the detallePedido property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetallePedidoDTO }
     *     
     */
    public void setDetallePedido(DetallePedidoDTO value) {
        this.detallePedido = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof OrdenTrabajoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final OrdenTrabajoDTO that = ((OrdenTrabajoDTO) object);
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
            UsuarioDTO lhsCreadaPor;
            lhsCreadaPor = this.getCreadaPor();
            UsuarioDTO rhsCreadaPor;
            rhsCreadaPor = that.getCreadaPor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creadaPor", lhsCreadaPor), LocatorUtils.property(thatLocator, "creadaPor", rhsCreadaPor), lhsCreadaPor, rhsCreadaPor)) {
                return false;
            }
        }
        {
            UsuarioDTO lhsAsignadaA;
            lhsAsignadaA = this.getAsignadaA();
            UsuarioDTO rhsAsignadaA;
            rhsAsignadaA = that.getAsignadaA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "asignadaA", lhsAsignadaA), LocatorUtils.property(thatLocator, "asignadaA", rhsAsignadaA), lhsAsignadaA, rhsAsignadaA)) {
                return false;
            }
        }
        {
            OrdenTrabajoEstadoDTO lhsOrdenTrabajoEstado;
            lhsOrdenTrabajoEstado = this.getOrdenTrabajoEstado();
            OrdenTrabajoEstadoDTO rhsOrdenTrabajoEstado;
            rhsOrdenTrabajoEstado = that.getOrdenTrabajoEstado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ordenTrabajoEstado", lhsOrdenTrabajoEstado), LocatorUtils.property(thatLocator, "ordenTrabajoEstado", rhsOrdenTrabajoEstado), lhsOrdenTrabajoEstado, rhsOrdenTrabajoEstado)) {
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
            XMLGregorianCalendar lhsFechaEstimadaFin;
            lhsFechaEstimadaFin = this.getFechaEstimadaFin();
            XMLGregorianCalendar rhsFechaEstimadaFin;
            rhsFechaEstimadaFin = that.getFechaEstimadaFin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechaEstimadaFin", lhsFechaEstimadaFin), LocatorUtils.property(thatLocator, "fechaEstimadaFin", rhsFechaEstimadaFin), lhsFechaEstimadaFin, rhsFechaEstimadaFin)) {
                return false;
            }
        }
        {
            DetallesOrdenTrabajo lhsDetalles;
            lhsDetalles = this.getDetalles();
            DetallesOrdenTrabajo rhsDetalles;
            rhsDetalles = that.getDetalles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "detalles", lhsDetalles), LocatorUtils.property(thatLocator, "detalles", rhsDetalles), lhsDetalles, rhsDetalles)) {
                return false;
            }
        }
        {
            DetallePedidoDTO lhsDetallePedido;
            lhsDetallePedido = this.getDetallePedido();
            DetallePedidoDTO rhsDetallePedido;
            rhsDetallePedido = that.getDetallePedido();
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
            int theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            UsuarioDTO theCreadaPor;
            theCreadaPor = this.getCreadaPor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creadaPor", theCreadaPor), currentHashCode, theCreadaPor);
        }
        {
            UsuarioDTO theAsignadaA;
            theAsignadaA = this.getAsignadaA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "asignadaA", theAsignadaA), currentHashCode, theAsignadaA);
        }
        {
            OrdenTrabajoEstadoDTO theOrdenTrabajoEstado;
            theOrdenTrabajoEstado = this.getOrdenTrabajoEstado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ordenTrabajoEstado", theOrdenTrabajoEstado), currentHashCode, theOrdenTrabajoEstado);
        }
        {
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaCreacion", theFechaCreacion), currentHashCode, theFechaCreacion);
        }
        {
            XMLGregorianCalendar theFechaEstimadaFin;
            theFechaEstimadaFin = this.getFechaEstimadaFin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechaEstimadaFin", theFechaEstimadaFin), currentHashCode, theFechaEstimadaFin);
        }
        {
            DetallesOrdenTrabajo theDetalles;
            theDetalles = this.getDetalles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "detalles", theDetalles), currentHashCode, theDetalles);
        }
        {
            DetallePedidoDTO theDetallePedido;
            theDetallePedido = this.getDetallePedido();
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
            int theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            UsuarioDTO theCreadaPor;
            theCreadaPor = this.getCreadaPor();
            strategy.appendField(locator, this, "creadaPor", buffer, theCreadaPor);
        }
        {
            UsuarioDTO theAsignadaA;
            theAsignadaA = this.getAsignadaA();
            strategy.appendField(locator, this, "asignadaA", buffer, theAsignadaA);
        }
        {
            OrdenTrabajoEstadoDTO theOrdenTrabajoEstado;
            theOrdenTrabajoEstado = this.getOrdenTrabajoEstado();
            strategy.appendField(locator, this, "ordenTrabajoEstado", buffer, theOrdenTrabajoEstado);
        }
        {
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            strategy.appendField(locator, this, "fechaCreacion", buffer, theFechaCreacion);
        }
        {
            XMLGregorianCalendar theFechaEstimadaFin;
            theFechaEstimadaFin = this.getFechaEstimadaFin();
            strategy.appendField(locator, this, "fechaEstimadaFin", buffer, theFechaEstimadaFin);
        }
        {
            DetallesOrdenTrabajo theDetalles;
            theDetalles = this.getDetalles();
            strategy.appendField(locator, this, "detalles", buffer, theDetalles);
        }
        {
            DetallePedidoDTO theDetallePedido;
            theDetallePedido = this.getDetallePedido();
            strategy.appendField(locator, this, "detallePedido", buffer, theDetallePedido);
        }
        return buffer;
    }

}
