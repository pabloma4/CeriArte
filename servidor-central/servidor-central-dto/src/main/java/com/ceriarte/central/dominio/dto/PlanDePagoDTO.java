
package com.ceriarte.central.dominio.dto;

import java.math.BigDecimal;
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
 * <p>Java class for planDePagoDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planDePagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idTarjetaDeCredito" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="recargo" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="cantidadCuotas" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planDePagoDTO", propOrder = {
    "id",
    "idTarjetaDeCredito",
    "descripcion",
    "recargo",
    "cantidadCuotas"
})
public class PlanDePagoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    protected int idTarjetaDeCredito;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true)
    protected BigDecimal recargo;
    protected int cantidadCuotas;

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
     * Gets the value of the idTarjetaDeCredito property.
     * 
     */
    public int getIdTarjetaDeCredito() {
        return idTarjetaDeCredito;
    }

    /**
     * Sets the value of the idTarjetaDeCredito property.
     * 
     */
    public void setIdTarjetaDeCredito(int value) {
        this.idTarjetaDeCredito = value;
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
     * Gets the value of the recargo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRecargo() {
        return recargo;
    }

    /**
     * Sets the value of the recargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRecargo(BigDecimal value) {
        this.recargo = value;
    }

    /**
     * Gets the value of the cantidadCuotas property.
     * 
     */
    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    /**
     * Sets the value of the cantidadCuotas property.
     * 
     */
    public void setCantidadCuotas(int value) {
        this.cantidadCuotas = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PlanDePagoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PlanDePagoDTO that = ((PlanDePagoDTO) object);
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
            int lhsIdTarjetaDeCredito;
            lhsIdTarjetaDeCredito = this.getIdTarjetaDeCredito();
            int rhsIdTarjetaDeCredito;
            rhsIdTarjetaDeCredito = that.getIdTarjetaDeCredito();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idTarjetaDeCredito", lhsIdTarjetaDeCredito), LocatorUtils.property(thatLocator, "idTarjetaDeCredito", rhsIdTarjetaDeCredito), lhsIdTarjetaDeCredito, rhsIdTarjetaDeCredito)) {
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
            BigDecimal lhsRecargo;
            lhsRecargo = this.getRecargo();
            BigDecimal rhsRecargo;
            rhsRecargo = that.getRecargo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recargo", lhsRecargo), LocatorUtils.property(thatLocator, "recargo", rhsRecargo), lhsRecargo, rhsRecargo)) {
                return false;
            }
        }
        {
            int lhsCantidadCuotas;
            lhsCantidadCuotas = this.getCantidadCuotas();
            int rhsCantidadCuotas;
            rhsCantidadCuotas = that.getCantidadCuotas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cantidadCuotas", lhsCantidadCuotas), LocatorUtils.property(thatLocator, "cantidadCuotas", rhsCantidadCuotas), lhsCantidadCuotas, rhsCantidadCuotas)) {
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
            int theIdTarjetaDeCredito;
            theIdTarjetaDeCredito = this.getIdTarjetaDeCredito();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idTarjetaDeCredito", theIdTarjetaDeCredito), currentHashCode, theIdTarjetaDeCredito);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "descripcion", theDescripcion), currentHashCode, theDescripcion);
        }
        {
            BigDecimal theRecargo;
            theRecargo = this.getRecargo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recargo", theRecargo), currentHashCode, theRecargo);
        }
        {
            int theCantidadCuotas;
            theCantidadCuotas = this.getCantidadCuotas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cantidadCuotas", theCantidadCuotas), currentHashCode, theCantidadCuotas);
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
            int theIdTarjetaDeCredito;
            theIdTarjetaDeCredito = this.getIdTarjetaDeCredito();
            strategy.appendField(locator, this, "idTarjetaDeCredito", buffer, theIdTarjetaDeCredito);
        }
        {
            String theDescripcion;
            theDescripcion = this.getDescripcion();
            strategy.appendField(locator, this, "descripcion", buffer, theDescripcion);
        }
        {
            BigDecimal theRecargo;
            theRecargo = this.getRecargo();
            strategy.appendField(locator, this, "recargo", buffer, theRecargo);
        }
        {
            int theCantidadCuotas;
            theCantidadCuotas = this.getCantidadCuotas();
            strategy.appendField(locator, this, "cantidadCuotas", buffer, theCantidadCuotas);
        }
        return buffer;
    }

}
