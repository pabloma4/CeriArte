package com.ceriarte.central.web.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.ClienteDTO;

public class ClientesLazyDataModel extends LazyDataModel<ClienteDTO>{
	
	private static final long serialVersionUID = 2523932746239797840L;

	private List<ClienteDTO> clientes;  
    
    public ClientesLazyDataModel(List<ClienteDTO> clientes) {  
        this.clientes = clientes;  
    }  
      
    @Override  
    public ClienteDTO getRowData(String rowKey) {  
        for(ClienteDTO cliente : clientes) {  
            if(String.valueOf(cliente.getId()).equals(rowKey))  
                return cliente;  
        }  
        return null;  
    }  
	  
    @Override  
    public Object getRowKey(ClienteDTO cliente) {  
        return cliente.getId();  
    }  
	  
    @Override  
    public List<ClienteDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<ClienteDTO> data = new ArrayList<ClienteDTO>();  
  
        //filter  
        for(ClienteDTO cliente : clientes) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    Object filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(PropertyUtils.getProperty(cliente, filterProperty));  
  
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
                data.add(cliente);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new ClientesLazySorter(sortField, sortOrder));  
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
