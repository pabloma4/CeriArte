
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
 * <p>Clase Java para medioDePagoDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="medioDePagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tipoMedioDePago" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}tipoMedioDePagoDTO"/&gt;
 *         &lt;element name="planDePago" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}planDePagoDTO" minOccurs="0"/&gt;
 *         &lt;element name="informacionAdicional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "medioDePagoDTO", propOrder = {
    "id",
    "tipoMedioDePago",
    "planDePago",
    "informacionAdicional",
    "habilitado"
})
public class MedioDePagoDTO
    implements Equals, HashCode, ToString
{

    protected int id;
    @XmlElement(required = true)
    protected TipoMedioDePagoDTO tipoMedioDePago;
    protected PlanDePagoDTO planDePago;
    protected String informacionAdicional;
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
     * Obtiene el valor de la propiedad tipoMedioDePago.
     * 
     * @return
     *     possible object is
     *     {@link TipoMedioDePagoDTO }
     *     
     */
    public TipoMedioDePagoDTO getTipoMedioDePago() {
        return tipoMedioDePago;
    }

    /**
     * Define el valor de la propiedad tipoMedioDePago.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoMedioDePagoDTO }
     *     
     */
    public void setTipoMedioDePago(TipoMedioDePagoDTO value) {
        this.tipoMedioDePago = value;
    }

    /**
     * Obtiene el valor de la propiedad planDePago.
     * 
     * @return
     *     possible object is
     *     {@link PlanDePagoDTO }
     *     
     */
    public PlanDePagoDTO getPlanDePago() {
        return planDePago;
    }

    /**
     * Define el valor de la propiedad planDePago.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanDePagoDTO }
     *     
     */
    public void setPlanDePago(PlanDePagoDTO value) {
        this.planDePago = value;
    }

    /**
     * Obtiene el valor de la propiedad informacionAdicional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    /**
     * Define el valor de la propiedad informacionAdicional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformacionAdicional(String value) {
        this.informacionAdicional = value;
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
        if (!(object instanceof MedioDePagoDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final MedioDePagoDTO that = ((MedioDePagoDTO) object);
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
            TipoMedioDePagoDTO lhsTipoMedioDePago;
            lhsTipoMedioDePago = this.getTipoMedioDePago();
            TipoMedioDePagoDTO rhsTipoMedioDePago;
            rhsTipoMedioDePago = that.getTipoMedioDePago();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tipoMedioDePago", lhsTipoMedioDePago), LocatorUtils.property(thatLocator, "tipoMedioDePago", rhsTipoMedioDePago), lhsTipoMedioDePago, rhsTipoMedioDePago)) {
                return false;
            }
        }
        {
            PlanDePagoDTO lhsPlanDePago;
            lhsPlanDePago = this.getPlanDePago();
            PlanDePagoDTO rhsPlanDePago;
            rhsPlanDePago = that.getPlanDePago();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "planDePago", lhsPlanDePago), LocatorUtils.property(thatLocator, "planDePago", rhsPlanDePago), lhsPlanDePago, rhsPlanDePago)) {
                return false;
            }
        }
        {
            String lhsInformacionAdicional;
            lhsInformacionAdicional = this.getInformacionAdicional();
            String rhsInformacionAdicional;
            rhsInformacionAdicional = that.getInformacionAdicional();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "informacionAdicional", lhsInformacionAdicional), LocatorUtils.property(thatLocator, "informacionAdicional", rhsInformacionAdicional), lhsInformacionAdicional, rhsInformacionAdicional)) {
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
            TipoMedioDePagoDTO theTipoMedioDePago;
            theTipoMedioDePago = this.getTipoMedioDePago();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tipoMedioDePago", theTipoMedioDePago), currentHashCode, theTipoMedioDePago);
        }
        {
            PlanDePagoDTO thePlanDePago;
            thePlanDePago = this.getPlanDePago();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "planDePago", thePlanDePago), currentHashCode, thePlanDePago);
        }
        {
            String theInformacionAdicional;
            theInformacionAdicional = this.getInformacionAdicional();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "informacionAdicional", theInformacionAdicional), currentHashCode, theInformacionAdicional);
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
            TipoMedioDePagoDTO theTipoMedioDePago;
            theTipoMedioDePago = this.getTipoMedioDePago();
            strategy.appendField(locator, this, "tipoMedioDePago", buffer, theTipoMedioDePago);
        }
        {
            PlanDePagoDTO thePlanDePago;
            thePlanDePago = this.getPlanDePago();
            strategy.appendField(locator, this, "planDePago", buffer, thePlanDePago);
        }
        {
            String theInformacionAdicional;
            theInformacionAdicional = this.getInformacionAdicional();
            strategy.appendField(locator, this, "informacionAdicional", buffer, theInformacionAdicional);
        }
        {
            boolean theHabilitado;
            theHabilitado = this.isHabilitado();
            strategy.appendField(locator, this, "habilitado", buffer, theHabilitado);
        }
        return buffer;
    }

}
