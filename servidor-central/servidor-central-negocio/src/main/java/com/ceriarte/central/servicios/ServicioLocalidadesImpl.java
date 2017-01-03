package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.LocalidadConverter;
import com.ceriarte.central.dominio.Localidad;
import com.ceriarte.central.dominio.dto.LocalidadDTO;
import com.ceriarte.central.repository.LocalidadRepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioLocalidades")
@Repository
@Transactional
public class ServicioLocalidadesImpl implements ServicioGeneric<LocalidadDTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LocalidadRepository localidadRepository;


	@Override
	public LocalidadDTO doSaveOrUpdate(LocalidadDTO objetoDTO) {
		return null;
	}

	@Override
	public List<LocalidadDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Localidades");
		
		List<LocalidadDTO> localidadesDTO = new ArrayList<LocalidadDTO>();

		// Busco todas las localidades
		Iterable<Localidad> localidades = localidadRepository.findAll();

		Iterator<Localidad> it = localidades.iterator();
		while (it.hasNext()) {
			LocalidadDTO localidadDTO = LocalidadConverter.toLocalidadDTO(it.next());
			localidadesDTO.add(localidadDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Localidades");
		
		return localidadesDTO;
	}

	@Override
	public void doDelete(int id) {
	}

	@Override
	public LocalidadDTO doFindOne(int id) {
		return null;
	}
}
