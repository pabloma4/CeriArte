
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
 * Representación de un Detalle de Presupuesto para visualizar en un reporte
 * 
 * <p>Clase Java para detallePresupuestoReporteDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detallePresupuestoReporteDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcionProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="medida" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="precioUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detallePresupuestoReporteDTO", propOrder = {

})
public class DetallePresupuestoReporteDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    protected int idProducto;
    @XmlElement(required = true)
    protected String nombreProducto;
    @XmlElement(required = true)
    protected String descripcionProducto;
    @XmlElement(required = true)
    protected String medida;
    protected double cantidad;
    protected double precioUnitario;
    protected double monto;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     */
    public void setIdProducto(int value) {
        this.idProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Define el valor de la propiedad nombreProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProducto(String value) {
        this.nombreProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionProducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * Define el valor de la propiedad descripcionProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionProducto(String value) {
        this.descripcionProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad medida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedida() {
        return medida;
    }

    /**
     * Define el valor de la propiedad medida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedida(String value) {
        this.medida = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(double value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad precioUnitario.
     * 
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Define el valor de la propiedad precioUnitario.
     * 
     */
    public void setPrecioUnitario(double value) {
        this.precioUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad monto.
     * 
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     */
    public void setMonto(double value) {
        this.monto = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DetallePresupuestoReporteDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DetallePresupuestoReporteDTO that = ((DetallePresupuestoReporteDTO) object);
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
            int lhsIdProducto;
            lhsIdProducto = this.getIdProducto();
            int rhsIdProducto;
            rhsIdProducto = that.getIdProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idProducto", lhsIdProducto), LocatorUtils.property(thatLocator, "idProducto", rhsIdProducto), lhsIdProducto, rhsIdProducto)) {
                return false;
            }
        }
        {
            String lhsNombreProducto;
            lhsNombreProducto = this.getNombreProducto();
            String rhsNombreProducto;
            rhsNombreProducto = that.getNombreProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nombreProducto", lhsNombreProducto), LocatorUtils.property(thatLocator, "nombreProducto", rhsNombreProducto), lhsNombreProducto, rhsNombreProducto)) {
                return false;
            }
        }
        {
            String lhsDescripcionProducto;
            lhsDescripcionProducto = this.getDescripcionProducto();
            String rhsDescripcionProducto;
            rhsDescripcionProducto = that.getDescripcionProducto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcionProducto", lhsDescripcionProducto), LocatorUtils.property(thatLocator, "descripcionProducto", rhsDescripcionProducto), lhsDescripcionProducto, rhsDescripcionProducto)) {
                return false;
            }
        }
        {
            String lhsMedida;
            lhsMedida = this.getMedida();
            String rhsMedida;
            rhsMedida = that.getMedida();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "medida", lhsMedida), LocatorUtils.property(thatLocator, "medida", rhsMedida), lhsMedida, rhsMedida)) {
                return false;
            }
        }
        {
            double lhsCantidad;
            lhsCantidad = this.getCantidad();
            double rhsCantidad;
            rhsCantidad = that.getCantidad();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cantidad", lhsCantidad), LocatorUtils.property(thatLocator, "cantidad", rhsCantidad), lhsCantidad, rhsCantidad)) {
                return false;
            }
        }
        {
            double lhsPrecioUnitario;
            lhsPrecioUnitario = this.getPrecioUnitario();
            double rhsPrecioUnitario;
            rhsPrecioUnitario = that.getPrecioUnitario();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "precioUnitario", lhsPrecioUnitario), LocatorUtils.property(thatLocator, "precioUnitario", rhsPrecioUnitario), lhsPrecioUnitario, rhsPrecioUnitario)) {
                return false;
            }
        }
        {
            double lhsMonto;
            lhsMonto = this.getMonto();
            double rhsMonto;
            rhsMonto = that.getMonto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "monto", lhsMonto), LocatorUtils.property(thatLocator, "monto", rhsMonto), lhsMonto, rhsMonto)) {
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
            int theIdProducto;
            theIdProducto = this.getIdProducto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idProducto", theIdProducto), currentHashCode, theIdProducto);
        }
        {
            String theNombreProducto;
            theNombreProducto = this.getNombreProducto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombreProducto", theNombreProducto), currentHashCode, theNombreProducto);
        }
        {
            String theDescripcionProducto;
            theDescripcionProducto = this.getDescripcionProducto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcionProducto", theDescripcionProducto), currentHashCode, theDescripcionProducto);
        }
        {
            String theMedida;
            theMedida = this.getMedida();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "medida", theMedida), currentHashCode, theMedida);
        }
        {
            double theCantidad;
            theCantidad = this.getCantidad();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cantidad", theCantidad), currentHashCode, theCantidad);
        }
        {
            double thePrecioUnitario;
            thePrecioUnitario = this.getPrecioUnitario();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "precioUnitario", thePrecioUnitario), currentHashCode, thePrecioUnitario);
        }
        {
            double theMonto;
            theMonto = this.getMonto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "monto", theMonto), currentHashCode, theMonto);
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
            int theIdProducto;
            theIdProducto = this.getIdProducto();
            strategy.appendField(locator, this, "idProducto", buffer, theIdProducto);
        }
        {
            String theNombreProducto;
            theNombreProducto = this.getNombreProducto();
            strategy.appendField(locator, this, "nombreProducto", buffer, theNombreProducto);
        }
        {
            String theDescripcionProducto;
            theDescripcionProducto = this.getDescripcionProducto();
            strategy.appendField(locator, this, "descripcionProducto", buffer, theDescripcionProducto);
        }
        {
            String theMedida;
            theMedida = this.getMedida();
            strategy.appendField(locator, this, "medida", buffer, theMedida);
        }
        {
            double theCantidad;
            theCantidad = this.getCantidad();
            strategy.appendField(locator, this, "cantidad", buffer, theCantidad);
        }
        {
            double thePrecioUnitario;
            thePrecioUnitario = this.getPrecioUnitario();
            strategy.appendField(locator, this, "precioUnitario", buffer, thePrecioUnitario);
        }
        {
            double theMonto;
            theMonto = this.getMonto();
            strategy.appendField(locator, this, "monto", buffer, theMonto);
        }
        return buffer;
    }

}
