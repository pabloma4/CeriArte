package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.RolConverter;
import com.ceriarte.central.dominio.Rol;
import com.ceriarte.central.dominio.dto.RolDTO;
import com.ceriarte.central.repository.RolRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioRoles")
@Transactional
public class ServicioRolesImpl implements ServicioGeneric<RolDTO> {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private RolRepository rolRepository;
	
	public RolDTO doSaveOrUpdate(RolDTO rolDto) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Roles");

		Rol rol = RolConverter.toRol(rolDto);
		
		rol = rolRepository.save(rol);
    	logger.debug("Se guardó el rol " + rol.getIdRol());
    	
		logger.debug("Fin doSaveOrUpdate() del Servicio de Roles");
		return RolConverter.toRolDTO(rol);
	}
	
	@Override
	public List<RolDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Roles");
		
		List<RolDTO> rolesDTO = new ArrayList<RolDTO>();

		// Busco todos los roles
		Iterable<Rol> roles = rolRepository.findAll();

		Iterator<Rol> it = roles.iterator();
		while (it.hasNext()) {
			RolDTO rolDTO = RolConverter.toRolDTO(it.next());
			rolesDTO.add(rolDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Roles");
		
		return rolesDTO;
	}
	
	@Override
	public RolDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Roles");
		
		// Busco el rol por id
		Rol rol = rolRepository.findOne(id);

		RolDTO rolDTO = RolConverter.toRolDTO(rol);
		
		logger.debug("Fin doFindOne() del Servicio de Roles");
		return rolDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Roles");
		
		rolRepository.delete(id);

		logger.debug("Se eliminó el rol " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Roles");
	}
}
