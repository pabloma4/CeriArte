package com.ceriarte.central.servicios;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.ParametroConverter;
import com.ceriarte.central.dominio.Parametro;
import com.ceriarte.central.dominio.dto.ParametroDTO;
import com.ceriarte.central.enums.ParametroEnum;
import com.ceriarte.central.repository.ParametroRepository;

/**
 * @author Carolina Olguín
 *
 */
@Service("servicioParametros")
@Repository
@Transactional
public class ServicioParametrosImpl implements ServicioParametros {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ParametroRepository parametroRepository;

	@Override
	public ParametroDTO doObtenerParametro(int idParametro) {
		logger.debug("Inicio doObtenerParametro()");

		Parametro param = parametroRepository.findOne(idParametro);
		ParametroDTO paramDTO = ParametroConverter.toParametroDTO(param);

		logger.debug("Fin doObtenerParametro()");
		return paramDTO;
	}

	@Override
	public int doSaveParametro(ParametroDTO dto) {
		logger.debug("Inicio doSaveParametro()");

		Parametro param = ParametroConverter.toParametro(dto);
		param = parametroRepository.save(param);
    	logger.debug("Se guardó el parámetro " + param.getIdParametro());
    	
		logger.debug("Fin doSaveParametro()");
		return param.getIdParametro();
	}

	@Override
	public boolean doDeleteParametro(int id) {
		logger.debug("Inicio doDeleteParametro()");
		boolean result = false;
		
		parametroRepository.delete(id);
    	logger.debug("Se eliminó el parámetro " + id);
    	result = true;
    	
		logger.debug("Fin doDeleteParametro()");
		return result;
	}

	@Override
	public String doObtenerValorParametro(ParametroEnum parEnum) {
		logger.debug("Inicio doObtenerValorParametro()");

		Parametro param = parametroRepository.findByClave(parEnum.getClave());

		logger.debug("Fin doObtenerValorParametro()");
		return param.getValor();
	}

}
