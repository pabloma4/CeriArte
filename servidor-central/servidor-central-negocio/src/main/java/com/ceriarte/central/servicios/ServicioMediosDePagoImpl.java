package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.MedioDePagoConverter;
import com.ceriarte.central.dominio.MedioDePago;
import com.ceriarte.central.dominio.dto.MedioDePagoDTO;
import com.ceriarte.central.repository.MedioDePagoRepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioMediosDePago")
@Repository
@Transactional
public class ServicioMediosDePagoImpl implements ServicioGeneric<MedioDePagoDTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MedioDePagoRepository medioDePagoRepository;


	@Override
	public MedioDePagoDTO doSaveOrUpdate(MedioDePagoDTO objetoDTO) {
		return null;
	}

	@Override
	public List<MedioDePagoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de MediosDePago");
		
		List<MedioDePagoDTO> mediosDePagoDTO = new ArrayList<MedioDePagoDTO>();

		// Busco todos los mediosDePago
		Iterable<MedioDePago> medioDePago = medioDePagoRepository.findByHabilitadoIsFalse();

		Iterator<MedioDePago> it = medioDePago.iterator();
		while (it.hasNext()) {
			MedioDePagoDTO medioDePagoDTO = MedioDePagoConverter.toMedioDePagoDTO(it.next());
			mediosDePagoDTO.add(medioDePagoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de MediosDePago");
		
		return mediosDePagoDTO;
	}

	@Override
	public void doDelete(int id) {
	}

	@Override
	public MedioDePagoDTO doFindOne(int id) {
		return null;
	}
}
