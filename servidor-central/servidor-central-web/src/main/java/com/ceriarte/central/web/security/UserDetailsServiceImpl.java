package com.ceriarte.central.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.dominio.Usuario;
import com.ceriarte.central.repository.UsuarioRepository;

/**
 * A custom {@link UserDetailsServiceImpl} where user information
 * is retrieved from a JPA repository
 */
@Service
@Repository
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * The username is first retrieved from the database and then mapped to 
	 * a {@link UserDetails} object.
	 * 
	 * @param login String con el identificador de usuario
	 * @return un objeto {@link UserDetails} cargado con la información del usuario
	 * @throws {@link UsernameNotFoundException}
	 */
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		try {
			logger.debug("Buscando datos del usuario {0} ...", login);
			Usuario usuario = usuarioRepository.findByLoginAndBorradoIsFalse(login);
			UserDetails userDetails = null;
			
			if (usuario == null) {
				logger.debug("No se pudo encontrar datos del usuario {0} ...", login);
	            throw new UsernameNotFoundException("Usuario y/o password incorrectos");
			}

			logger.debug("Cargando userDetails para {0} ...", usuario.getNombre());
			userDetails = new UserDetailsImpl(usuario);
			return userDetails;
		} catch (Exception e) {
			logger.warn("Usuario y/o password incorrectos", e);
            throw new UsernameNotFoundException("Usuario y/o password incorrectos");
		}
	}
}