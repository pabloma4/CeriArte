
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
 * <p>Java class for clienteDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="clienteDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="domicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="localidad" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}localidadDTO" minOccurs="0"/&gt;
 *         &lt;element name="cuit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responsabilidadIVA" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}responsabilidadIVADTO" minOccurs="0"/&gt;
 *         &lt;element name="nombreCompleto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clienteDTO", propOrder = {
    "id",
    "nombre",
    "apellido",
    "email",
    "telefono",
    "domicilio",
    "localidad",
    "cuit",
    "responsabilidadIVA",
    "nombreCompleto"
})
public class ClienteDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String apellido;
    protected String email;
    protected String telefono;
    protected String domicilio;
    protected LocalidadDTO localidad;
    protected String cuit;
    protected ResponsabilidadIVADTO responsabilidadIVA;
    @XmlElement(required = true)
    protected String nombreCompleto;

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
     * Gets the value of the apellido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Sets the value of the apellido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the telefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Gets the value of the domicilio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Sets the value of the domicilio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomicilio(String value) {
        this.domicilio = value;
    }

    /**
     * Gets the value of the localidad property.
     * 
     * @return
     *     possible object is
     *     {@link LocalidadDTO }
     *     
     */
    public LocalidadDTO getLocalidad() {
        return localidad;
    }

    /**
     * Sets the value of the localidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalidadDTO }
     *     
     */
    public void setLocalidad(LocalidadDTO value) {
        this.localidad = value;
    }

    /**
     * Gets the value of the cuit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuit() {
        return cuit;
    }

    /**
     * Sets the value of the cuit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuit(String value) {
        this.cuit = value;
    }

    /**
     * Gets the value of the responsabilidadIVA property.
     * 
     * @return
     *     possible object is
     *     {@link ResponsabilidadIVADTO }
     *     
     */
    public ResponsabilidadIVADTO getResponsabilidadIVA() {
        return responsabilidadIVA;
    }

    /**
     * Sets the value of the responsabilidadIVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsabilidadIVADTO }
     *     
     */
    public void setResponsabilidadIVA(ResponsabilidadIVADTO value) {
        this.responsabilidadIVA = value;
    }

    /**
     * Gets the value of the nombreCompleto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets the value of the nombreCompleto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCompleto(String value) {
        this.nombreCompleto = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ClienteDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ClienteDTO that = ((ClienteDTO) object);
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
            String lhsApellido;
            lhsApellido = this.getApellido();
            String rhsApellido;
            rhsApellido = that.getApellido();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "apellido", lhsApellido), LocatorUtils.property(thatLocator, "apellido", rhsApellido), lhsApellido, rhsApellido)) {
                return false;
            }
        }
        {
            String lhsEmail;
            lhsEmail = this.getEmail();
            String rhsEmail;
            rhsEmail = that.getEmail();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEmail), LocatorUtils.property(thatLocator, "email", rhsEmail), lhsEmail, rhsEmail)) {
                return false;
            }
        }
        {
            String lhsTelefono;
            lhsTelefono = this.getTelefono();
            String rhsTelefono;
            rhsTelefono = that.getTelefono();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "telefono", lhsTelefono), LocatorUtils.property(thatLocator, "telefono", rhsTelefono), lhsTelefono, rhsTelefono)) {
                return false;
            }
        }
        {
            String lhsDomicilio;
            lhsDomicilio = this.getDomicilio();
            String rhsDomicilio;
            rhsDomicilio = that.getDomicilio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "domicilio", lhsDomicilio), LocatorUtils.property(thatLocator, "domicilio", rhsDomicilio), lhsDomicilio, rhsDomicilio)) {
                return false;
            }
        }
        {
            LocalidadDTO lhsLocalidad;
            lhsLocalidad = this.getLocalidad();
            LocalidadDTO rhsLocalidad;
            rhsLocalidad = that.getLocalidad();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "localidad", lhsLocalidad), LocatorUtils.property(thatLocator, "localidad", rhsLocalidad), lhsLocalidad, rhsLocalidad)) {
                return false;
            }
        }
        {
            String lhsCuit;
            lhsCuit = this.getCuit();
            String rhsCuit;
            rhsCuit = that.getCuit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cuit", lhsCuit), LocatorUtils.property(thatLocator, "cuit", rhsCuit), lhsCuit, rhsCuit)) {
                return false;
            }
        }
        {
            ResponsabilidadIVADTO lhsResponsabilidadIVA;
            lhsResponsabilidadIVA = this.getResponsabilidadIVA();
            ResponsabilidadIVADTO rhsResponsabilidadIVA;
            rhsResponsabilidadIVA = that.getResponsabilidadIVA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "responsabilidadIVA", lhsResponsabilidadIVA), LocatorUtils.property(thatLocator, "responsabilidadIVA", rhsResponsabilidadIVA), lhsResponsabilidadIVA, rhsResponsabilidadIVA)) {
                return false;
            }
        }
        {
            String lhsNombreCompleto;
            lhsNombreCompleto = this.getNombreCompleto();
            String rhsNombreCompleto;
            rhsNombreCompleto = that.getNombreCompleto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nombreCompleto", lhsNombreCompleto), LocatorUtils.property(thatLocator, "nombreCompleto", rhsNombreCompleto), lhsNombreCompleto, rhsNombreCompleto)) {
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
            String theApellido;
            theApellido = this.getApellido();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "apellido", theApellido), currentHashCode, theApellido);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail);
        }
        {
            String theTelefono;
            theTelefono = this.getTelefono();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "telefono", theTelefono), currentHashCode, theTelefono);
        }
        {
            String theDomicilio;
            theDomicilio = this.getDomicilio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "domicilio", theDomicilio), currentHashCode, theDomicilio);
        }
        {
            LocalidadDTO theLocalidad;
            theLocalidad = this.getLocalidad();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "localidad", theLocalidad), currentHashCode, theLocalidad);
        }
        {
            String theCuit;
            theCuit = this.getCuit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cuit", theCuit), currentHashCode, theCuit);
        }
        {
            ResponsabilidadIVADTO theResponsabilidadIVA;
            theResponsabilidadIVA = this.getResponsabilidadIVA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "responsabilidadIVA", theResponsabilidadIVA), currentHashCode, theResponsabilidadIVA);
        }
        {
            String theNombreCompleto;
            theNombreCompleto = this.getNombreCompleto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombreCompleto", theNombreCompleto), currentHashCode, theNombreCompleto);
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
            String theApellido;
            theApellido = this.getApellido();
            strategy.appendField(locator, this, "apellido", buffer, theApellido);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            strategy.appendField(locator, this, "email", buffer, theEmail);
        }
        {
            String theTelefono;
            theTelefono = this.getTelefono();
            strategy.appendField(locator, this, "telefono", buffer, theTelefono);
        }
        {
            String theDomicilio;
            theDomicilio = this.getDomicilio();
            strategy.appendField(locator, this, "domicilio", buffer, theDomicilio);
        }
        {
            LocalidadDTO theLocalidad;
            theLocalidad = this.getLocalidad();
            strategy.appendField(locator, this, "localidad", buffer, theLocalidad);
        }
        {
            String theCuit;
            theCuit = this.getCuit();
            strategy.appendField(locator, this, "cuit", buffer, theCuit);
        }
        {
            ResponsabilidadIVADTO theResponsabilidadIVA;
            theResponsabilidadIVA = this.getResponsabilidadIVA();
            strategy.appendField(locator, this, "responsabilidadIVA", buffer, theResponsabilidadIVA);
        }
        {
            String theNombreCompleto;
            theNombreCompleto = this.getNombreCompleto();
            strategy.appendField(locator, this, "nombreCompleto", buffer, theNombreCompleto);
        }
        return buffer;
    }

}
