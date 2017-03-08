
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
 * Representación de un Producto Manufacturado o no
 * 
 * <p>Java class for productoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unidadMedida" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}unidadMedidaDTO"/&gt;
 *         &lt;element name="stock" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="stockMinimo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="medida" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="precioUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="elaborado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="fechaModificacion" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productoDTO", propOrder = {

})
public class ProductoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected String nombre;
    protected String descripcion;
    @XmlElement(required = true)
    protected UnidadMedidaDTO unidadMedida;
    protected Double stock;
    protected Double stockMinimo;
    protected Double medida;
    protected double precio;
    protected double precioUnitario;
    protected boolean elaborado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaCreacion;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaModificacion;

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
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the unidadMedida property.
     * 
     * @return
     *     possible object is
     *     {@link UnidadMedidaDTO }
     *     
     */
    public UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Sets the value of the unidadMedida property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnidadMedidaDTO }
     *     
     */
    public void setUnidadMedida(UnidadMedidaDTO value) {
        this.unidadMedida = value;
    }

    /**
     * Gets the value of the stock property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getStock() {
        return stock;
    }

    /**
     * Sets the value of the stock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setStock(Double value) {
        this.stock = value;
    }

    /**
     * Gets the value of the stockMinimo property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getStockMinimo() {
        return stockMinimo;
    }

    /**
     * Sets the value of the stockMinimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setStockMinimo(Double value) {
        this.stockMinimo = value;
    }

    /**
     * Gets the value of the medida property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMedida() {
        return medida;
    }

    /**
     * Sets the value of the medida property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMedida(Double value) {
        this.medida = value;
    }

    /**
     * Gets the value of the precio property.
     * 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Sets the value of the precio property.
     * 
     */
    public void setPrecio(double value) {
        this.precio = value;
    }

    /**
     * Gets the value of the precioUnitario property.
     * 
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Sets the value of the precioUnitario property.
     * 
     */
    public void setPrecioUnitario(double value) {
        this.precioUnitario = value;
    }

    /**
     * Gets the value of the elaborado property.
     * 
     */
    public boolean isElaborado() {
        return elaborado;
    }

    /**
     * Sets the value of the elaborado property.
     * 
     */
    public void setElaborado(boolean value) {
        this.elaborado = value;
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
     * Gets the value of the fechaModificacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * Sets the value of the fechaModificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaModificacion(XMLGregorianCalendar value) {
        this.fechaModificacion = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProductoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProductoDTO that = ((ProductoDTO) object);
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
            String lhsNombre;
            lhsNombre = this.getNombre();
            String rhsNombre;
            rhsNombre = that.getNombre();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nombre", lhsNombre), LocatorUtils.property(thatLocator, "nombre", rhsNombre), lhsNombre, rhsNombre)) {
                return false;
            }
        }
        {
            String lhsDescripcion;
            lhsDescripcion = this.getDescripcion();
            String rhsDescripcion;
            rhsDescripcion = that.getDescripcion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcion", lhsDescripcion), LocatorUtils.property(thatLocator, "descripcion", rhsDescripcion), lhsDescripcion, rhsDescripcion)) {
                return false;
            }
        }
        {
            UnidadMedidaDTO lhsUnidadMedida;
            lhsUnidadMedida = this.getUnidadMedida();
            UnidadMedidaDTO rhsUnidadMedida;
            rhsUnidadMedida = that.getUnidadMedida();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "unidadMedida", lhsUnidadMedida), LocatorUtils.property(thatLocator, "unidadMedida", rhsUnidadMedida), lhsUnidadMedida, rhsUnidadMedida)) {
                return false;
            }
        }
        {
            Double lhsMedida;
            lhsMedida = this.getMedida();
            Double rhsMedida;
            rhsMedida = that.getMedida();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "medida", lhsMedida), LocatorUtils.property(thatLocator, "medida", rhsMedida), lhsMedida, rhsMedida)) {
                return false;
            }
        }
        {
            double lhsPrecio;
            lhsPrecio = this.getPrecio();
            double rhsPrecio;
            rhsPrecio = that.getPrecio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "precio", lhsPrecio), LocatorUtils.property(thatLocator, "precio", rhsPrecio), lhsPrecio, rhsPrecio)) {
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
            boolean lhsElaborado;
            lhsElaborado = this.isElaborado();
            boolean rhsElaborado;
            rhsElaborado = that.isElaborado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "elaborado", lhsElaborado), LocatorUtils.property(thatLocator, "elaborado", rhsElaborado), lhsElaborado, rhsElaborado)) {
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
            String theNombre;
            theNombre = this.getNombre();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombre", theNombre), currentHashCode, theNombre);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
        }
        {
            UnidadMedidaDTO theUnidadMedida;
            theUnidadMedida = this.getUnidadMedida();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "unidadMedida", theUnidadMedida), currentHashCode, theUnidadMedida);
        }
        {
            Double theMedida;
            theMedida = this.getMedida();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "medida", theMedida), currentHashCode, theMedida);
        }
        {
            double thePrecio;
            thePrecio = this.getPrecio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "precio", thePrecio), currentHashCode, thePrecio);
        }
        {
            double thePrecioUnitario;
            thePrecioUnitario = this.getPrecioUnitario();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "precioUnitario", thePrecioUnitario), currentHashCode, thePrecioUnitario);
        }
        {
            boolean theElaborado;
            theElaborado = this.isElaborado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "elaborado", theElaborado), currentHashCode, theElaborado);
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
            String theNombre;
            theNombre = this.getNombre();
            strategy.appendField(locator, this, "nombre", buffer, theNombre);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            strategy.appendField(locator, this, "descripcion", buffer, theDescripcion);
        }
        {
            UnidadMedidaDTO theUnidadMedida;
            theUnidadMedida = this.getUnidadMedida();
            strategy.appendField(locator, this, "unidadMedida", buffer, theUnidadMedida);
        }
        {
            Double theStock;
            theStock = this.getStock();
            strategy.appendField(locator, this, "stock", buffer, theStock);
        }
        {
            Double theStockMinimo;
            theStockMinimo = this.getStockMinimo();
            strategy.appendField(locator, this, "stockMinimo", buffer, theStockMinimo);
        }
        {
            Double theMedida;
            theMedida = this.getMedida();
            strategy.appendField(locator, this, "medida", buffer, theMedida);
        }
        {
            double thePrecio;
            thePrecio = this.getPrecio();
            strategy.appendField(locator, this, "precio", buffer, thePrecio);
        }
        {
            double thePrecioUnitario;
            thePrecioUnitario = this.getPrecioUnitario();
            strategy.appendField(locator, this, "precioUnitario", buffer, thePrecioUnitario);
        }
        {
            boolean theElaborado;
            theElaborado = this.isElaborado();
            strategy.appendField(locator, this, "elaborado", buffer, theElaborado);
        }
        {
            XMLGregorianCalendar theFechaCreacion;
            theFechaCreacion = this.getFechaCreacion();
            strategy.appendField(locator, this, "fechaCreacion", buffer, theFechaCreacion);
        }
        {
            XMLGregorianCalendar theFechaModificacion;
            theFechaModificacion = this.getFechaModificacion();
            strategy.appendField(locator, this, "fechaModificacion", buffer, theFechaModificacion);
        }
        return buffer;
    }

}
