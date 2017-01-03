package com.ceriarte.central.web.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ceriarte.central.dominio.dto.ClienteDTO;
import com.ceriarte.central.web.services.ClientesService;
 
@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {
 
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	ClientesService service = (ClientesService) fc.getExternalContext().getApplicationMap().get("clientesService");
                return service.doFindOne(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No es un cliente válido."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((ClienteDTO) object).getId());
        }
        else {
            return null;
        }
    }   
}   