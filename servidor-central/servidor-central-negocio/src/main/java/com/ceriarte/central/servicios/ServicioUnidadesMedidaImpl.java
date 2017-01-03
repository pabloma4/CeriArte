package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.UnidadMedidaConverter;
import com.ceriarte.central.dominio.UnidadMedida;
import com.ceriarte.central.dominio.dto.UnidadMedidaDTO;
import com.ceriarte.central.repository.UnidadMedidaRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioUnidadesMedida")
@Transactional
public class ServicioUnidadesMedidaImpl implements ServicioGeneric<UnidadMedidaDTO> {
	
	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;
	

	@Override
	public UnidadMedidaDTO doSaveOrUpdate(UnidadMedidaDTO objetoDTO) {
		return null;
	}
	
	@Override
	public List<UnidadMedidaDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Unidades de Medida");
		
		List<UnidadMedidaDTO> unidadesMedidaDTO = new ArrayList<UnidadMedidaDTO>();

		// Busco todos los productos
		Iterable<UnidadMedida> unidadesMedida = unidadMedidaRepository.findAll();

		Iterator<UnidadMedida> it = unidadesMedida.iterator();
		while (it.hasNext()) {
			UnidadMedidaDTO unidadMedidaDTO = UnidadMedidaConverter.toUnidadMedidaDTO(it.next());
			unidadesMedidaDTO.add(unidadMedidaDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Unidades de Medida");
		
		return unidadesMedidaDTO;
	}

	@Override
	public void doDelete(int id) {
	}

	@Override
	public UnidadMedidaDTO doFindOne(int id) {
		return null;
	}


}
