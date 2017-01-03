
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
 * <p>Clase Java para detallesPresupuesto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detallesPresupuesto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="detallePresupuesto" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}detallePresupuestoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detallesPresupuesto", propOrder = {
    "detallePresupuesto"
})
public class DetallesPresupuesto
    implements Equals, HashCode, ToString
{

    protected List<DetallePresupuestoDTO> detallePresupuesto;

    /**
     * Gets the value of the detallePresupuesto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detallePresupuesto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetallePresupuesto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetallePresupuestoDTO }
     * 
     * 
     */
    public List<DetallePresupuestoDTO> getDetallePresupuesto() {
        if (detallePresupuesto == null) {
            detallePresupuesto = new ArrayList<DetallePresupuestoDTO>();
        }
        return this.detallePresupuesto;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DetallesPresupuesto)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DetallesPresupuesto that = ((DetallesPresupuesto) object);
        {
            List<DetallePresupuestoDTO> lhsDetallePresupuesto;
            lhsDetallePresupuesto = (((this.detallePresupuesto!= null)&&(!this.detallePresupuesto.isEmpty()))?this.getDetallePresupuesto():null);
            List<DetallePresupuestoDTO> rhsDetallePresupuesto;
            rhsDetallePresupuesto = (((that.detallePresupuesto!= null)&&(!that.detallePresupuesto.isEmpty()))?that.getDetallePresupuesto():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "detallePresupuesto", lhsDetallePresupuesto), LocatorUtils.property(thatLocator, "detallePresupuesto", rhsDetallePresupuesto), lhsDetallePresupuesto, rhsDetallePresupuesto)) {
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
            List<DetallePresupuestoDTO> theDetallePresupuesto;
            theDetallePresupuesto = (((this.detallePresupuesto!= null)&&(!this.detallePresupuesto.isEmpty()))?this.getDetallePresupuesto():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "detallePresupuesto", theDetallePresupuesto), currentHashCode, theDetallePresupuesto);
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
            List<DetallePresupuestoDTO> theDetallePresupuesto;
            theDetallePresupuesto = (((this.detallePresupuesto!= null)&&(!this.detallePresupuesto.isEmpty()))?this.getDetallePresupuesto():null);
            strategy.appendField(locator, this, "detallePresupuesto", buffer, theDetallePresupuesto);
        }
        return buffer;
    }

}
