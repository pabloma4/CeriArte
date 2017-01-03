package com.ceriarte.central.web.datamodels;

import java.util.Comparator;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.ClienteDTO;

public class ClientesLazySorter implements Comparator<ClienteDTO> {

	private String sortField;
    private SortOrder sortOrder;
    
    public ClientesLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(ClienteDTO cliente1, ClienteDTO cliente2) {
        try {
        	Object value1 = PropertyUtils.getProperty(cliente1, this.sortField);
        	Object value2 = PropertyUtils.getProperty(cliente2, this.sortField);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
