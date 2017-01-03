package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.ResponsabilidadIVAConverter;
import com.ceriarte.central.dominio.ResponsabilidadIVA;
import com.ceriarte.central.dominio.dto.ResponsabilidadIVADTO;
import com.ceriarte.central.repository.ResponsabilidadIVARepository;

/**
 * @author pmarengo
 * 
 */
@Service("servicioResponsabilidadIVA")
@Transactional
public class ServicioResponsabilidadIVAImpl implements ServicioGeneric<ResponsabilidadIVADTO>{

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ResponsabilidadIVARepository responsabilidadIVARepository;

	@Override
	public List<ResponsabilidadIVADTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de ResponsabilidadIVA");
		
		List<ResponsabilidadIVADTO> listResponsabilidadIVADTO = new ArrayList<ResponsabilidadIVADTO>();

		// Busco todas los objetos responsabilidadIVA
		Iterable<ResponsabilidadIVA> list = responsabilidadIVARepository.findAll();

		Iterator<ResponsabilidadIVA> it = list.iterator();
		while (it.hasNext()) {
			ResponsabilidadIVADTO responsabilidadIVADTO = ResponsabilidadIVAConverter.toResponsabilidadIVADTO(it.next());
			listResponsabilidadIVADTO.add(responsabilidadIVADTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de ResponsabilidadIVA");
		
		return listResponsabilidadIVADTO;
	}

	@Override
	public ResponsabilidadIVADTO doSaveOrUpdate(ResponsabilidadIVADTO objetoDTO) {
		return null;
	}

	@Override
	public void doDelete(int id) {		
	}

	@Override
	public ResponsabilidadIVADTO doFindOne(int id) {
		return null;
	}
}
