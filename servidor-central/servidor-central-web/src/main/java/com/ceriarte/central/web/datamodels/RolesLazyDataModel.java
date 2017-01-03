package com.ceriarte.central.web.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.RolDTO;

public class RolesLazyDataModel extends LazyDataModel<RolDTO>{
	
	private static final long serialVersionUID = -4656439616224621039L;

	private List<RolDTO> roles;
    
    public RolesLazyDataModel(List<RolDTO> roles) {  
    	if(roles != null){
    		this.roles = roles; 
        }else{
        	this.roles = new ArrayList<RolDTO>();
        }
    }  
      
    @Override  
    public RolDTO getRowData(String rowKey) {  
        for(RolDTO rol : roles) {  
        	if(String.valueOf(rol.getIdRol()).equals(rowKey))  
                return rol;  
        }  
        return null;  
    }
	  
    @Override  
    public Object getRowKey(RolDTO rol) {  
        return String.valueOf(rol.getIdRol());  
    }  
	  
    @Override  
    public List<RolDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<RolDTO> data = new ArrayList<RolDTO>();  
  
        //filter  
        for(RolDTO rol : roles) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    Object filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(PropertyUtils.getProperty(rol, filterProperty));  
  
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
                data.add(rol);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new RolesLazySorter(sortField, sortOrder));  
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
