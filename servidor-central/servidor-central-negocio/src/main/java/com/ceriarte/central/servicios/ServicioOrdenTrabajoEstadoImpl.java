package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.OrdenTrabajoEstadoConverter;
import com.ceriarte.central.dominio.OrdenTrabajoEstado;
import com.ceriarte.central.dominio.dto.OrdenTrabajoEstadoDTO;
import com.ceriarte.central.repository.OrdenTrabajoEstadoRepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioOrdenTrabajoEstado")
@Transactional
public class ServicioOrdenTrabajoEstadoImpl implements ServicioGeneric<OrdenTrabajoEstadoDTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private OrdenTrabajoEstadoRepository ordenTrabajoEstadoRepository;

	@Override
	public OrdenTrabajoEstadoDTO doSaveOrUpdate(OrdenTrabajoEstadoDTO objetoDTO) {
		return null;
	}

	@Override
	public List<OrdenTrabajoEstadoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de OrdenTrabajoEstado");
		
		List<OrdenTrabajoEstadoDTO> ordenTrabajoEstadosDTO = new ArrayList<OrdenTrabajoEstadoDTO>();

		// Busco todos los ordenTrabajoEstados
		Iterable<OrdenTrabajoEstado> ordenTrabajoEstados = ordenTrabajoEstadoRepository.findAll();

		Iterator<OrdenTrabajoEstado> it = ordenTrabajoEstados.iterator();
		while (it.hasNext()) {
			OrdenTrabajoEstadoDTO ordenTrabajoEstadoDTO = OrdenTrabajoEstadoConverter.toOrdenTrabajoEstadoDTO(it.next());
			ordenTrabajoEstadosDTO.add(ordenTrabajoEstadoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de OrdenTrabajoEstado");
		
		return ordenTrabajoEstadosDTO;
	}

	@Override
	public OrdenTrabajoEstadoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de OrdenTrabajo Estado");
		
		// Busco el estado del ordenTrabajo por id
		OrdenTrabajoEstado ordenTrabajoEstado = ordenTrabajoEstadoRepository.findOne(id);

		OrdenTrabajoEstadoDTO ordenTrabajoEstadoDTO = OrdenTrabajoEstadoConverter.toOrdenTrabajoEstadoDTO(ordenTrabajoEstado);
		
		logger.debug("Fin doFindOne() del Servicio de OrdenTrabajo Estado");
		return ordenTrabajoEstadoDTO;	}

	@Override
	public void doDelete(int id) {
	}


}
