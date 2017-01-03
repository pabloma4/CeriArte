package com.ceriarte.central.web.datamodels;

import java.util.Comparator;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.RolDTO;

public class RolesLazySorter implements Comparator<RolDTO> {

	private String sortField;
    private SortOrder sortOrder;
    
    public RolesLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

	@SuppressWarnings("unchecked")
	public int compare(RolDTO rol1, RolDTO rol2) {
        try {
        	Object value1 = PropertyUtils.getProperty(rol1, this.sortField);
        	Object value2 = PropertyUtils.getProperty(rol2, this.sortField);

            int value = ((Comparable<Object>)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
