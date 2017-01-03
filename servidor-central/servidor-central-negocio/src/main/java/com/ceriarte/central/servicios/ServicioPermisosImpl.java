package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.PermisoConverter;
import com.ceriarte.central.dominio.Permiso;
import com.ceriarte.central.dominio.dto.PermisoDTO;
import com.ceriarte.central.repository.PermisoRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioPermisos")
@Transactional
public class ServicioPermisosImpl implements ServicioGeneric<PermisoDTO> {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private PermisoRepository permisoRepository;
	
	public PermisoDTO doSaveOrUpdate(PermisoDTO permisoDto) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Permisos");

		Permiso permiso = PermisoConverter.toPermiso(permisoDto);
		
		permiso = permisoRepository.save(permiso);
    	logger.debug("Se guardó el permiso " + permiso.getIdPermiso());
    	
		logger.debug("Fin doSaveOrUpdate() del Servicio de Permisos");
		return PermisoConverter.toPermisoDTO(permiso);
	}
	
	@Override
	public List<PermisoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Permisos");
		
		List<PermisoDTO> permisosDTO = new ArrayList<PermisoDTO>();

		// Busco todos los permisos
		Iterable<Permiso> permisos = permisoRepository.findAll();

		Iterator<Permiso> it = permisos.iterator();
		while (it.hasNext()) {
			PermisoDTO permisoDTO = PermisoConverter.toPermisoDTO(it.next());
			permisosDTO.add(permisoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Permisos");
		
		return permisosDTO;
	}
	
	@Override
	public PermisoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Permisos");
		
		// Busco el permiso por id
		Permiso permiso = permisoRepository.findOne(id);

		PermisoDTO permisoDTO = PermisoConverter.toPermisoDTO(permiso);
		
		logger.debug("Fin doFindOne() del Servicio de Permisos");
		return permisoDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Permisos");
		
		permisoRepository.delete(id);

		logger.debug("Se eliminó el permiso " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Permisos");
	}
}
