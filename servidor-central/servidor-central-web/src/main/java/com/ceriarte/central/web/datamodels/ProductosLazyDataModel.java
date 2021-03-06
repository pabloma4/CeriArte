package com.ceriarte.central.web.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.ProductoDTO;

public class ProductosLazyDataModel extends LazyDataModel<ProductoDTO>{
	
	private static final long serialVersionUID = -2940722604386221907L;

	private List<ProductoDTO> productos;  
    
    public ProductosLazyDataModel(List<ProductoDTO> productos) {  
        this.productos = productos;  
    }  
      
    @Override  
    public ProductoDTO getRowData(String rowKey) {  
        for(ProductoDTO producto : productos) {  
            if(String.valueOf(producto.getId()).equals(rowKey))  
                return producto;  
        }  
        return null;  
    }  
	  
    @Override  
    public Object getRowKey(ProductoDTO producto) {  
        return producto.getId();  
    }  
	  
    @Override  
    public List<ProductoDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<ProductoDTO> data = new ArrayList<ProductoDTO>();  
  
        //filter  
        for(ProductoDTO producto : productos) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    Object filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(PropertyUtils.getProperty(producto, filterProperty));  
  
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
                data.add(producto);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new ProductosLazySorter(sortField, sortOrder));  
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
