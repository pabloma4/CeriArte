package com.ceriarte.central.web.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.web.services.ProductosService;
 
@FacesConverter("productoConverter")
public class ProductoConverter implements Converter {
 
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ProductosService service = (ProductosService) fc.getExternalContext().getApplicationMap().get("productosService");
                return service.doFindOne(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "No es un producto válido."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((ProductoDTO) object).getId());
        }
        else {
            return null;
        }
    }   
}   