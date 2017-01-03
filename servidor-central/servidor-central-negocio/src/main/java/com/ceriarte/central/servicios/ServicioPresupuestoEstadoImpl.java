package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.PresupuestoEstadoConverter;
import com.ceriarte.central.dominio.PresupuestoEstado;
import com.ceriarte.central.dominio.dto.PresupuestoEstadoDTO;
import com.ceriarte.central.repository.PresupuestoEstadoRepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioPresupuestoEstado")
@Transactional
public class ServicioPresupuestoEstadoImpl implements ServicioGeneric<PresupuestoEstadoDTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private PresupuestoEstadoRepository presupuestoEstadoRepository;

	@Override
	public PresupuestoEstadoDTO doSaveOrUpdate(PresupuestoEstadoDTO objetoDTO) {
		return null;
	}

	@Override
	public List<PresupuestoEstadoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de PresupuestoEstado");
		
		List<PresupuestoEstadoDTO> presupuestoEstadosDTO = new ArrayList<PresupuestoEstadoDTO>();

		// Busco todos los presupuestoEstados
		Iterable<PresupuestoEstado> presupuestoEstados = presupuestoEstadoRepository.findAll();

		Iterator<PresupuestoEstado> it = presupuestoEstados.iterator();
		while (it.hasNext()) {
			PresupuestoEstadoDTO presupuestoEstadoDTO = PresupuestoEstadoConverter.toPresupuestoEstadoDTO(it.next());
			presupuestoEstadosDTO.add(presupuestoEstadoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de PresupuestoEstado");
		
		return presupuestoEstadosDTO;
	}

	@Override
	public PresupuestoEstadoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Presupuesto Estado");
		
		// Busco el estado del presupuesto por id
		PresupuestoEstado presupuestoEstado = presupuestoEstadoRepository.findOne(id);

		PresupuestoEstadoDTO presupuestoEstadoDTO = PresupuestoEstadoConverter.toPresupuestoEstadoDTO(presupuestoEstado);
		
		logger.debug("Fin doFindOne() del Servicio de Presupuesto Estado");
		return presupuestoEstadoDTO;	}

	@Override
	public void doDelete(int id) {
	}


}
