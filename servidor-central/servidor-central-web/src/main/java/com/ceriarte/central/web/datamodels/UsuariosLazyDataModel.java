package com.ceriarte.central.web.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.UsuarioDTO;

public class UsuariosLazyDataModel extends LazyDataModel<UsuarioDTO>{
	
	private static final long serialVersionUID = -4656039616224621039L;

	private List<UsuarioDTO> usuarios;
    
    public UsuariosLazyDataModel(List<UsuarioDTO> usuarios) {  
    	if(usuarios != null){
    		this.usuarios = usuarios; 
        }else{
        	this.usuarios = new ArrayList<UsuarioDTO>();
        }
    }  
      
    @Override  
    public UsuarioDTO getRowData(String rowKey) {  
        for(UsuarioDTO usuario : usuarios) {  
        	if(String.valueOf(usuario.getIdUsuario()).equals(rowKey))  
                return usuario;  
        }  
        return null;  
    }
	  
    @Override  
    public Object getRowKey(UsuarioDTO usuario) {  
        return String.valueOf(usuario.getIdUsuario());  
    }  
	  
    @Override  
    public List<UsuarioDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<UsuarioDTO> data = new ArrayList<UsuarioDTO>();  
  
        //filter  
        for(UsuarioDTO usuario : usuarios) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    Object filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(PropertyUtils.getProperty(usuario, filterProperty));  
  
                    if(filterValue == null || fieldValue.toUpperCase().startsWith(filterValue.toString().toUpperCase())) {  
                        match = true;  
                    }  
                    else {  
                        match = false;  
                        break;  
                    }  
                } catch(Exception e) {  
                    match = false;  
                }   
            }  
  
            if(match) {  
                data.add(usuario);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new UsuariosLazySorter(sortField, sortOrder));  
        }  
  
        //rowCount  
        int dataSize = data.size();  
        this.setRowCount(dataSize);  
  
        //paginate  
        if(dataSize > pageSize) {  
            try {  
                return data.subList(first, first + pageSize);  
            }  
            catch(IndexOutOfBoundsException e) {  
                return data.subList(first, first + (dataSize % pageSize));  
            }  
        }  
        else {  
            return data;  
        }  
    }  
}
