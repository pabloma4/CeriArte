package com.ceriarte.central.dominio;

// Generated 11-sep-2013 18:19:09 by Hibernate Tools 4.0.0

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = -123960918866632367L;

	private int idUsuario;
	private String login;
	private String password;
	private String apellido;
	private String nombre;
	private String email;
	private Boolean cambiarPwd;
	private int tiempoLogin;
	private boolean borrado;
	private Set<Rol> roles;

	public Usuario() {
	}

	public Usuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario(int idUsuario, String login, String password, String email,
			int tiempoLogin) {
		this.idUsuario = idUsuario;
		this.login = login;
		this.password = password;
		this.email = email;
		this.tiempoLogin = tiempoLogin;
	}

	public Usuario(int idUsuario, String login, String password,
			String apellido, String nombre, String email, Boolean cambiarPwd,
			int tiempoLogin) {
		this.idUsuario = idUsuario;
		this.login = login;
		this.password = password;
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.cambiarPwd = cambiarPwd;
		this.tiempoLogin = tiempoLogin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "login", nullable = false, length = 64)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false, length = 256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "apellido", length = 64)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "nombre", length = 64)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "email", nullable = false, length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "cambiar_pwd")
	public Boolean getCambiarPwd() {
		return this.cambiarPwd;
	}

	public void setCambiarPwd(Boolean cambiarPwd) {
		this.cambiarPwd = cambiarPwd;
	}

	@Column(name = "tiempo_login", nullable = false)
	public int getTiempoLogin() {
		return this.tiempoLogin;
	}

	public void setTiempoLogin(int tiempoLogin) {
		this.tiempoLogin = tiempoLogin;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "usuario_rol", schema = "public", joinColumns = { @JoinColumn(name = "id_usuario", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_rol", nullable = false, updatable = false) })
	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Column(name = "borrado")
	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	@Transient
	public String getNombreCompleto() {
		return this.nombre + " " + this.apellido;
	}
}
