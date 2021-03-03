
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
 * Representación del Usuario
 * 
 * <p>Java class for usuarioDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="usuarioDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombreCompleto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="confirmarPassword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="changePassword" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="tiempoLogin" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="roles" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}roles" minOccurs="0"/&gt;
 *         &lt;element name="permisos" type="{http://www.autoentrada.com/ws/schemas/sc/ae/1_0}permisos" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioDTO", propOrder = {

})
public class UsuarioDTO
    implements Equals, HashCode, ToString
{

    protected int idUsuario;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String apellido;
    @XmlElement(required = true)
    protected String nombreCompleto;
    @XmlElement(required = true)
    protected String login;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String confirmarPassword;
    @XmlElement(required = true)
    protected String email;
    protected boolean changePassword;
    protected int tiempoLogin;
    protected Roles roles;
    protected Permisos permisos;

    /**
     * Gets the value of the idUsuario property.
     * 
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Sets the value of the idUsuario property.
     * 
     */
    public void setIdUsuario(int value) {
        this.idUsuario = value;
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

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the confirmarPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    /**
     * Sets the value of the confirmarPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmarPassword(String value) {
        this.confirmarPassword = value;
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
     * Gets the value of the changePassword property.
     * 
     */
    public boolean isChangePassword() {
        return changePassword;
    }

    /**
     * Sets the value of the changePassword property.
     * 
     */
    public void setChangePassword(boolean value) {
        this.changePassword = value;
    }

    /**
     * Gets the value of the tiempoLogin property.
     * 
     */
    public int getTiempoLogin() {
        return tiempoLogin;
    }

    /**
     * Sets the value of the tiempoLogin property.
     * 
     */
    public void setTiempoLogin(int value) {
        this.tiempoLogin = value;
    }

    /**
     * Gets the value of the roles property.
     * 
     * @return
     *     possible object is
     *     {@link Roles }
     *     
     */
    public Roles getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Roles }
     *     
     */
    public void setRoles(Roles value) {
        this.roles = value;
    }

    /**
     * Gets the value of the permisos property.
     * 
     * @return
     *     possible object is
     *     {@link Permisos }
     *     
     */
    public Permisos getPermisos() {
        return permisos;
    }

    /**
     * Sets the value of the permisos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Permisos }
     *     
     */
    public void setPermisos(Permisos value) {
        this.permisos = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UsuarioDTO)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final UsuarioDTO that = ((UsuarioDTO) object);
        {
            int lhsIdUsuario;
            lhsIdUsuario = this.getIdUsuario();
            int rhsIdUsuario;
            rhsIdUsuario = that.getIdUsuario();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idUsuario", lhsIdUsuario), LocatorUtils.property(thatLocator, "idUsuario", rhsIdUsuario), lhsIdUsuario, rhsIdUsuario)) {
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
            String lhsNombreCompleto;
            lhsNombreCompleto = this.getNombreCompleto();
            String rhsNombreCompleto;
            rhsNombreCompleto = that.getNombreCompleto();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nombreCompleto", lhsNombreCompleto), LocatorUtils.property(thatLocator, "nombreCompleto", rhsNombreCompleto), lhsNombreCompleto, rhsNombreCompleto)) {
                return false;
            }
        }
        {
            String lhsLogin;
            lhsLogin = this.getLogin();
            String rhsLogin;
            rhsLogin = that.getLogin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "login", lhsLogin), LocatorUtils.property(thatLocator, "login", rhsLogin), lhsLogin, rhsLogin)) {
                return false;
            }
        }
        {
            String lhsPassword;
            lhsPassword = this.getPassword();
            String rhsPassword;
            rhsPassword = that.getPassword();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "password", lhsPassword), LocatorUtils.property(thatLocator, "password", rhsPassword), lhsPassword, rhsPassword)) {
                return false;
            }
        }
        {
            String lhsConfirmarPassword;
            lhsConfirmarPassword = this.getConfirmarPassword();
            String rhsConfirmarPassword;
            rhsConfirmarPassword = that.getConfirmarPassword();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "confirmarPassword", lhsConfirmarPassword), LocatorUtils.property(thatLocator, "confirmarPassword", rhsConfirmarPassword), lhsConfirmarPassword, rhsConfirmarPassword)) {
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
            boolean lhsChangePassword;
            lhsChangePassword = this.isChangePassword();
            boolean rhsChangePassword;
            rhsChangePassword = that.isChangePassword();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "changePassword", lhsChangePassword), LocatorUtils.property(thatLocator, "changePassword", rhsChangePassword), lhsChangePassword, rhsChangePassword)) {
                return false;
            }
        }
        {
            int lhsTiempoLogin;
            lhsTiempoLogin = this.getTiempoLogin();
            int rhsTiempoLogin;
            rhsTiempoLogin = that.getTiempoLogin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tiempoLogin", lhsTiempoLogin), LocatorUtils.property(thatLocator, "tiempoLogin", rhsTiempoLogin), lhsTiempoLogin, rhsTiempoLogin)) {
                return false;
            }
        }
        {
            Roles lhsRoles;
            lhsRoles = this.getRoles();
            Roles rhsRoles;
            rhsRoles = that.getRoles();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "roles", lhsRoles), LocatorUtils.property(thatLocator, "roles", rhsRoles), lhsRoles, rhsRoles)) {
                return false;
            }
        }
        {
            Permisos lhsPermisos;
            lhsPermisos = this.getPermisos();
            Permisos rhsPermisos;
            rhsPermisos = that.getPermisos();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "permisos", lhsPermisos), LocatorUtils.property(thatLocator, "permisos", rhsPermisos), lhsPermisos, rhsPermisos)) {
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
            int theIdUsuario;
            theIdUsuario = this.getIdUsuario();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idUsuario", theIdUsuario), currentHashCode, theIdUsuario);
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
            String theNombreCompleto;
            theNombreCompleto = this.getNombreCompleto();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombreCompleto", theNombreCompleto), currentHashCode, theNombreCompleto);
        }
        {
            String theLogin;
            theLogin = this.getLogin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "login", theLogin), currentHashCode, theLogin);
        }
        {
            String thePassword;
            thePassword = this.getPassword();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "password", thePassword), currentHashCode, thePassword);
        }
        {
            String theConfirmarPassword;
            theConfirmarPassword = this.getConfirmarPassword();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "confirmarPassword", theConfirmarPassword), currentHashCode, theConfirmarPassword);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail);
        }
        {
            boolean theChangePassword;
            theChangePassword = this.isChangePassword();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "changePassword", theChangePassword), currentHashCode, theChangePassword);
        }
        {
            int theTiempoLogin;
            theTiempoLogin = this.getTiempoLogin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tiempoLogin", theTiempoLogin), currentHashCode, theTiempoLogin);
        }
        {
            Roles theRoles;
            theRoles = this.getRoles();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "roles", theRoles), currentHashCode, theRoles);
        }
        {
            Permisos thePermisos;
            thePermisos = this.getPermisos();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "permisos", thePermisos), currentHashCode, thePermisos);
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
            int theIdUsuario;
            theIdUsuario = this.getIdUsuario();
            strategy.appendField(locator, this, "idUsuario", buffer, theIdUsuario);
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
            String theNombreCompleto;
            theNombreCompleto = this.getNombreCompleto();
            strategy.appendField(locator, this, "nombreCompleto", buffer, theNombreCompleto);
        }
        {
            String theLogin;
            theLogin = this.getLogin();
            strategy.appendField(locator, this, "login", buffer, theLogin);
        }
        {
            String thePassword;
            thePassword = this.getPassword();
            strategy.appendField(locator, this, "password", buffer, thePassword);
        }
        {
            String theConfirmarPassword;
            theConfirmarPassword = this.getConfirmarPassword();
            strategy.appendField(locator, this, "confirmarPassword", buffer, theConfirmarPassword);
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            strategy.appendField(locator, this, "email", buffer, theEmail);
        }
        {
            boolean theChangePassword;
            theChangePassword = this.isChangePassword();
            strategy.appendField(locator, this, "changePassword", buffer, theChangePassword);
        }
        {
            int theTiempoLogin;
            theTiempoLogin = this.getTiempoLogin();
            strategy.appendField(locator, this, "tiempoLogin", buffer, theTiempoLogin);
        }
        {
            Roles theRoles;
            theRoles = this.getRoles();
            strategy.appendField(locator, this, "roles", buffer, theRoles);
        }
        {
            Permisos thePermisos;
            thePermisos = this.getPermisos();
            strategy.appendField(locator, this, "permisos", buffer, thePermisos);
        }
        return buffer;
    }

}
