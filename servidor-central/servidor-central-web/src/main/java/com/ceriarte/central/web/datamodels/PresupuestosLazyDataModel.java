package com.ceriarte.central.web.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.PresupuestoDTO;

public class PresupuestosLazyDataModel extends LazyDataModel<PresupuestoDTO>{
	

	private static final long serialVersionUID = 6773256685774736970L;

	private List<PresupuestoDTO> presupuestos;  
    
    public PresupuestosLazyDataModel(List<PresupuestoDTO> presupuesto) {  
        this.presupuestos = presupuesto;  
    }  
      
    @Override  
    public PresupuestoDTO getRowData(String rowKey) {  
        for(PresupuestoDTO presupuesto : presupuestos) {  
            if(String.valueOf(presupuesto.getId()).equals(rowKey))  
                return presupuesto;  
        }  
        return null;  
    }  
	  
    @Override  
    public Object getRowKey(PresupuestoDTO presupuesto) {  
        return presupuesto.getId();  
    }  
	  
    @Override  
    public List<PresupuestoDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<PresupuestoDTO> data = new ArrayList<PresupuestoDTO>();  
  
        //filter  
        for(PresupuestoDTO presupuesto : presupuestos) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    Object filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(PropertyUtils.getProperty(presupuesto, filterProperty));  
  
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
                data.add(presupuesto);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new PresupuestosLazySorter(sortField, sortOrder));  
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
