
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
 * <p>Clase Java para tipoMedioDePagoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoMedioDePagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="abreviatura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tieneId" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="tieneVencimiento" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="habilitado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoMedioDePagoDTO", propOrder = {
    "id",
    "descripcion",
    "abreviatura",
    "codigo",
    "tieneId",
    "tieneVencimiento",
    "habilitado"
})
public class TipoMedioDePagoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true)
    protected String abreviatura;
    @XmlElement(required = true)
    protected String codigo;
    protected boolean tieneId;
    protected boolean tieneVencimiento;
    protected boolean habilitado;

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
     * Obtiene el valor de la propiedad descripcion.
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
     * Define el valor de la propiedad descripcion.
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
     * Obtiene el valor de la propiedad abreviatura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Define el valor de la propiedad abreviatura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbreviatura(String value) {
        this.abreviatura = value;
    }

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad tieneId.
     * 
     */
    public boolean isTieneId() {
        return tieneId;
    }

    /**
     * Define el valor de la propiedad tieneId.
     * 
     */
    public void setTieneId(boolean value) {
        this.tieneId = value;
    }

    /**
     * Obtiene el valor de la propiedad tieneVencimiento.
     * 
     */
    public boolean isTieneVencimiento() {
        return tieneVencimiento;
    }

    /**
     * Define el valor de la propiedad tieneVencimiento.
     * 
     */
    public void setTieneVencimiento(boolean value) {
        this.tieneVencimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad habilitado.
     * 
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * Define el valor de la propiedad habilitado.
     * 
     */
    public void setHabilitado(boolean value) {
        this.habilitado = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TipoMedioDePagoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TipoMedioDePagoDTO that = ((TipoMedioDePagoDTO) object);
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
            String lhsDescripcion;
            lhsDescripcion = this.getDescripcion();
            String rhsDescripcion;
            rhsDescripcion = that.getDescripcion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "descripcion", lhsDescripcion), LocatorUtils.property(thatLocator, "descripcion", rhsDescripcion), lhsDescripcion, rhsDescripcion)) {
                return false;
            }
        }
        {
            String lhsAbreviatura;
            lhsAbreviatura = this.getAbreviatura();
            String rhsAbreviatura;
            rhsAbreviatura = that.getAbreviatura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "abreviatura", lhsAbreviatura), LocatorUtils.property(thatLocator, "abreviatura", rhsAbreviatura), lhsAbreviatura, rhsAbreviatura)) {
                return false;
            }
        }
        {
            String lhsCodigo;
            lhsCodigo = this.getCodigo();
            String rhsCodigo;
            rhsCodigo = that.getCodigo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "codigo", lhsCodigo), LocatorUtils.property(thatLocator, "codigo", rhsCodigo), lhsCodigo, rhsCodigo)) {
                return false;
            }
        }
        {
            boolean lhsTieneId;
            lhsTieneId = this.isTieneId();
            boolean rhsTieneId;
            rhsTieneId = that.isTieneId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tieneId", lhsTieneId), LocatorUtils.property(thatLocator, "tieneId", rhsTieneId), lhsTieneId, rhsTieneId)) {
                return false;
            }
        }
        {
            boolean lhsTieneVencimiento;
            lhsTieneVencimiento = this.isTieneVencimiento();
            boolean rhsTieneVencimiento;
            rhsTieneVencimiento = that.isTieneVencimiento();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tieneVencimiento", lhsTieneVencimiento), LocatorUtils.property(thatLocator, "tieneVencimiento", rhsTieneVencimiento), lhsTieneVencimiento, rhsTieneVencimiento)) {
                return false;
            }
        }
        {
            boolean lhsHabilitado;
            lhsHabilitado = this.isHabilitado();
            boolean rhsHabilitado;
            rhsHabilitado = that.isHabilitado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "habilitado", lhsHabilitado), LocatorUtils.property(thatLocator, "habilitado", rhsHabilitado), lhsHabilitado, rhsHabilitado)) {
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
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
        }
        {
            String theAbreviatura;
            theAbreviatura = this.getAbreviatura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "abreviatura", theAbreviatura), currentHashCode, theAbreviatura);
        }
        {
            String theCodigo;
            theCodigo = this.getCodigo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "codigo", theCodigo), currentHashCode, theCodigo);
        }
        {
            boolean theTieneId;
            theTieneId = this.isTieneId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tieneId", theTieneId), currentHashCode, theTieneId);
        }
        {
            boolean theTieneVencimiento;
            theTieneVencimiento = this.isTieneVencimiento();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tieneVencimiento", theTieneVencimiento), currentHashCode, theTieneVencimiento);
        }
        {
            boolean theHabilitado;
            theHabilitado = this.isHabilitado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "habilitado", theHabilitado), currentHashCode, theHabilitado);
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
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            strategy.appendField(locator, this, "descripcion", buffer, theDescripcion);
        }
        {
            String theAbreviatura;
            theAbreviatura = this.getAbreviatura();
            strategy.appendField(locator, this, "abreviatura", buffer, theAbreviatura);
        }
        {
            String theCodigo;
            theCodigo = this.getCodigo();
            strategy.appendField(locator, this, "codigo", buffer, theCodigo);
        }
        {
            boolean theTieneId;
            theTieneId = this.isTieneId();
            strategy.appendField(locator, this, "tieneId", buffer, theTieneId);
        }
        {
            boolean theTieneVencimiento;
            theTieneVencimiento = this.isTieneVencimiento();
            strategy.appendField(locator, this, "tieneVencimiento", buffer, theTieneVencimiento);
        }
        {
            boolean theHabilitado;
            theHabilitado = this.isHabilitado();
            strategy.appendField(locator, this, "habilitado", buffer, theHabilitado);
        }
        return buffer;
    }

}
