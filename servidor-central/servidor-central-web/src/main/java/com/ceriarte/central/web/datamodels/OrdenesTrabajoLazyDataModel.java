package com.ceriarte.central.web.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.OrdenTrabajoDTO;

public class OrdenesTrabajoLazyDataModel extends LazyDataModel<OrdenTrabajoDTO>{
	

	private static final long serialVersionUID = 6837256685544216970L;

	private List<OrdenTrabajoDTO> ordenesTrabajo;  
    
    public OrdenesTrabajoLazyDataModel(List<OrdenTrabajoDTO> ordenesTrabajo) {  
        this.ordenesTrabajo = ordenesTrabajo;  
    }  
      
    @Override  
    public OrdenTrabajoDTO getRowData(String rowKey) {  
        for(OrdenTrabajoDTO ordenTrabajo : ordenesTrabajo) {  
            if(String.valueOf(ordenTrabajo.getId()).equals(rowKey))  
                return ordenTrabajo;  
        }  
        return null;  
    }  
	  
    @Override  
    public Object getRowKey(OrdenTrabajoDTO ordenTrabajo) {  
        return ordenTrabajo.getId();  
    }  
	  
    @Override  
    public List<OrdenTrabajoDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<OrdenTrabajoDTO> data = new ArrayList<OrdenTrabajoDTO>();  
  
        //filter  
        for(OrdenTrabajoDTO ordenTrabajo : ordenesTrabajo) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    Object filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(PropertyUtils.getProperty(ordenTrabajo, filterProperty));  
  
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
                data.add(ordenTrabajo);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new OrdenesTrabajoLazySorter(sortField, sortOrder));  
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
