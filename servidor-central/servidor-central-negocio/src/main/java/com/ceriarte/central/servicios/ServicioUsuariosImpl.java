package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.UsuarioConverter;
import com.ceriarte.central.dominio.Usuario;
import com.ceriarte.central.dominio.dto.PermisoDTO;
import com.ceriarte.central.dominio.dto.UsuarioDTO;
import com.ceriarte.central.enums.ErrorCodeEnum;
import com.ceriarte.central.enums.PermisoEnum;
import com.ceriarte.central.enums.UsuarioEnum;
import com.ceriarte.central.excepciones.ServidorCentralBusinessException;
import com.ceriarte.central.repository.UsuarioRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioUsuarios")
@Transactional
public class ServicioUsuariosImpl implements ServicioUsuarios {
	
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioDTO doSaveOrUpdate(UsuarioDTO usuarioDto) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Usuarios");

		if(usuarioDto.getRoles().getRol().size() == 0){
			throw new ServidorCentralBusinessException(ErrorCodeEnum.USUARIO_SIN_ROLES, "No se le asignaron roles al usuario!");
		}
		
		Usuario usuarioByLogin = usuarioRepository.findByLoginAndBorradoIsFalse(usuarioDto.getLogin());
		if (usuarioByLogin != null && usuarioByLogin.getIdUsuario() != usuarioDto.getIdUsuario()) {
			throw new ServidorCentralBusinessException(ErrorCodeEnum.USUARIO_LOGIN_DUPLICADO, "El login ya se encuentra registrado!");
		}
	
		Usuario usuarioByEmail = usuarioRepository.findByEmailAndBorradoIsFalse(usuarioDto.getEmail());
		if (usuarioByEmail != null && usuarioByEmail.getIdUsuario() != usuarioDto.getIdUsuario()) {
			throw new ServidorCentralBusinessException(ErrorCodeEnum.USUARIO_EMAIL_DUPLICADO, "El email ya se encuentra registrado!");
		}
		
		Usuario usuario = usuarioRepository.findOne(usuarioDto.getIdUsuario());
		
		// Realiza el merge del usuarioDTO con el usuario ya almacenado en BD si éste ya existía.
		usuario = UsuarioConverter.merge(usuario, usuarioDto);
		
		usuario = usuarioRepository.save(usuario);
    	logger.debug("Se guardó el usuario " + usuario.getIdUsuario());
    	
		logger.debug("Fin doSaveUsuario() del Servicio de Usuarios");
		return UsuarioConverter.toUsuarioDTO(usuario);
	}
	
	@Override
	public List<UsuarioDTO> doFindAll( ) {
		logger.debug("Inicio doFindAll() del Servicio de Usuarios");
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();

		// Busco todas los usuarios
		Iterable<Usuario> usuarios = usuarioRepository.findByBorradoIsFalse();

		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			UsuarioDTO usuarioDTO = UsuarioConverter.toUsuarioDTO(it.next());
			usuariosDTO.add(usuarioDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Usuarios");
		
		return usuariosDTO;
	}
	
	@Override
	public UsuarioDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Usuarios");
		
		// Busco el usuario por id
		Usuario usuario = usuarioRepository.findOne(id);

		UsuarioDTO usuarioDTO = UsuarioConverter.toUsuarioDTO(usuario);
		
		logger.debug("Fin doFindOne() del Servicio de Usuarios");
		return usuarioDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Usuarios");
		
		Usuario usuario = usuarioRepository.findOne(id);
		usuario.setBorrado(true);
		
		usuarioRepository.save(usuario);
    	logger.debug("Se eliminó el usuario " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Usuarios");
	}

	@Override
	public UsuarioDTO doFindByLogin(String login) {
		logger.debug("Inicio doFindByUsername() del Servicio de Usuarios");
		
		// Busco el usuario por login
		Usuario usuario = usuarioRepository.findByLoginAndBorradoIsFalse(login);

		UsuarioDTO usuarioDTO = UsuarioConverter.toUsuarioDTO(usuario);
		
		logger.debug("Fin doFindByUsername() del Servicio de Usuarios");
		return usuarioDTO;
	}

	@Override
	public List<UsuarioDTO> doFindAllByUserLogged(UsuarioDTO usuarioLogged) {
		logger.debug("Inicio doFindAllByUserLogged() del Servicio de Usuarios");
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		Iterable<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Si el usuario posee el permiso "VIEW_ALL_USUARIOS", entonces retorno todos los usuarios del sistema
		PermisoDTO permisoViewAllUsers = new PermisoDTO();
		permisoViewAllUsers.setIdPermiso(PermisoEnum.VIEW_ALL_USUARIOS.getValue());
		if(usuarioLogged.getPermisos().getPermiso().contains(permisoViewAllUsers)){
			usuarios = usuarioRepository.findByBorradoIsFalse();
		}
		
		// Si el usuario posee el permiso "VIEW_ALL_USUARIOS", entonces retorno todos los usuarios del sistema
		PermisoDTO permisoViewOnlyCompanyUsers = new PermisoDTO();
		permisoViewOnlyCompanyUsers.setIdPermiso(PermisoEnum.VIEW_ONLY_COMPANY_USUARIOS.getValue());
		if(usuarioLogged.getPermisos().getPermiso().contains(permisoViewOnlyCompanyUsers)){
			usuarios = usuarioRepository.findByBorradoIsFalseAndIdUsuarioNot(UsuarioEnum.SIERRA_SOFT_ADMIN.getValue());
		}

		Iterator<Usuario> it = usuarios.iterator();
		while (it.hasNext()) {
			UsuarioDTO usuarioDTO = UsuarioConverter.toUsuarioDTO(it.next());
			usuariosDTO.add(usuarioDTO);
		}
		
		logger.debug("Fin doFindAllByUserLogged() del Servicio de Usuarios");
		
		return usuariosDTO;
	}
}
