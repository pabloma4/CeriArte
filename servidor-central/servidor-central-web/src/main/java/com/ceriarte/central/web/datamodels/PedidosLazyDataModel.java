package com.ceriarte.central.web.datamodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.PedidoDTO;

public class PedidosLazyDataModel extends LazyDataModel<PedidoDTO>{
	

	private static final long serialVersionUID = 6837256685774736970L;

	private List<PedidoDTO> pedidos;  
    
    public PedidosLazyDataModel(List<PedidoDTO> pedido) {  
        this.pedidos = pedido;  
    }  
      
    @Override  
    public PedidoDTO getRowData(String rowKey) {  
        for(PedidoDTO pedido : pedidos) {  
            if(String.valueOf(pedido.getId()).equals(rowKey))  
                return pedido;  
        }  
        return null;  
    }  
	  
    @Override  
    public Object getRowKey(PedidoDTO pedido) {  
        return pedido.getId();  
    }  
	  
    @Override  
    public List<PedidoDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<PedidoDTO> data = new ArrayList<PedidoDTO>();  
  
        //filter  
        for(PedidoDTO pedido : pedidos) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    Object filterValue = filters.get(filterProperty);  
                    String fieldValue = String.valueOf(PropertyUtils.getProperty(pedido, filterProperty));  
  
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
                data.add(pedido);  
            }  
        }  
  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new PedidosLazySorter(sortField, sortOrder));  
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
