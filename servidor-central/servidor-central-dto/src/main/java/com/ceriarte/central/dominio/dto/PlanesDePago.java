
package com.ceriarte.central.dominio.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 * <p>Java class for planesDePago complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planesDePago"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="planDePago" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}planDePagoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planesDePago", propOrder = {
    "planDePago"
})
public class PlanesDePago
    implements Equals, HashCode, ToString
{

    protected List<PlanDePagoDTO> planDePago;

    /**
     * Gets the value of the planDePago property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planDePago property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanDePago().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlanDePagoDTO }
     * 
     * 
     */
    public List<PlanDePagoDTO> getPlanDePago() {
        if (planDePago == null) {
            planDePago = new ArrayList<PlanDePagoDTO>();
        }
        return this.planDePago;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PlanesDePago)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PlanesDePago that = ((PlanesDePago) object);
        {
            List<PlanDePagoDTO> lhsPlanDePago;
            lhsPlanDePago = (((this.planDePago!= null)&&(!this.planDePago.isEmpty()))?this.getPlanDePago():null);
            List<PlanDePagoDTO> rhsPlanDePago;
            rhsPlanDePago = (((that.planDePago!= null)&&(!that.planDePago.isEmpty()))?that.getPlanDePago():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "planDePago", lhsPlanDePago), LocatorUtils.property(thatLocator, "planDePago", rhsPlanDePago), lhsPlanDePago, rhsPlanDePago)) {
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
            List<PlanDePagoDTO> thePlanDePago;
            thePlanDePago = (((this.planDePago!= null)&&(!this.planDePago.isEmpty()))?this.getPlanDePago():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "planDePago", thePlanDePago), currentHashCode, thePlanDePago);
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
            List<PlanDePagoDTO> thePlanDePago;
            thePlanDePago = (((this.planDePago!= null)&&(!this.planDePago.isEmpty()))?this.getPlanDePago():null);
            strategy.appendField(locator, this, "planDePago", buffer, thePlanDePago);
        }
        return buffer;
    }

}
