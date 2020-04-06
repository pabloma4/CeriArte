
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
 * <p>Java class for permisos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="permisos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="permiso" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}permisoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permisos", propOrder = {
    "permiso"
})
public class Permisos
    implements Equals, HashCode, ToString
{

    protected List<PermisoDTO> permiso;

    /**
     * Gets the value of the permiso property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permiso property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermiso().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PermisoDTO }
     * 
     * 
     */
    public List<PermisoDTO> getPermiso() {
        if (permiso == null) {
            permiso = new ArrayList<PermisoDTO>();
        }
        return this.permiso;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Permisos)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Permisos that = ((Permisos) object);
        {
            List<PermisoDTO> lhsPermiso;
            lhsPermiso = (((this.permiso!= null)&&(!this.permiso.isEmpty()))?this.getPermiso():null);
            List<PermisoDTO> rhsPermiso;
            rhsPermiso = (((that.permiso!= null)&&(!that.permiso.isEmpty()))?that.getPermiso():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "permiso", lhsPermiso), LocatorUtils.property(thatLocator, "permiso", rhsPermiso), lhsPermiso, rhsPermiso)) {
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
            List<PermisoDTO> thePermiso;
            thePermiso = (((this.permiso!= null)&&(!this.permiso.isEmpty()))?this.getPermiso():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "permiso", thePermiso), currentHashCode, thePermiso);
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
            List<PermisoDTO> thePermiso;
            thePermiso = (((this.permiso!= null)&&(!this.permiso.isEmpty()))?this.getPermiso():null);
            strategy.appendField(locator, this, "permiso", buffer, thePermiso);
        }
        return buffer;
    }

}
