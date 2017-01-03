package com.ceriarte.central.web.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ceriarte.central.dominio.Permiso;
import com.ceriarte.central.dominio.Rol;
import com.ceriarte.central.dominio.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 7046137609122509747L;
	private final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

	private final Usuario usuario;
	private final Collection<GrantedAuthority> authorities;
	/**
	 * Prefijo necesario para alguna funcionalidad predefinida en Spring Security
	 * (ej. RoleVoter)
	 */
	private final static String ROLE_PREFIX = "ROLE_";

	public UserDetailsImpl(Usuario usuario) {
		super();
		String nombreRol;
		this.usuario = usuario;

		logger.debug("Obteniendo roles para {0} ...", usuario.getLogin());
		Set<Rol> roles = this.usuario.getRoles();
		this.authorities = new HashSet<GrantedAuthority>();

		/*
		 * Obtiene todos los permisos del usuario que corresponden a roles
		 * y los guarda en un Set que Spring Security consulta cada vez que requiere verificar permisos
		 * para habilitar una funcionalidad.
		 * Decidimos NO incluir los valores de la tabla Rol en la lista de 
		 * "authorities" y dejamos solamente los permisos, ya que permiten
		 * un control más "fino" de lo que se habilita/deshabilita y evita
		 * tener que controlar que no se use el mismo nombre para rol y permiso.
		 */
		for (Rol rol : roles) {
			logger.debug("Obteniendo permisos del rol {0} ...", rol.getNombre());
			Set<Permiso> permisos = rol.getPermisos();
			for (Permiso permiso : permisos) {
				nombreRol = permiso.getNombre().toUpperCase();
				logger.debug("Cargando privilegio {0} ...", ROLE_PREFIX + nombreRol);
				authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + nombreRol));		
			}
		}
		logger.debug("Carga de privilegios y detalles finalizada.");
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getLogin();
	}

	public String getCompleteName() {
		return usuario.getApellido() + "," + usuario.getNombre();
	}

	public int getIdUsuario() {
		return usuario.getIdUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
