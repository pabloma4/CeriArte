package com.ceriarte.central.web.datamodels;

import java.util.Comparator;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.PresupuestoDTO;

public class PresupuestosLazySorter implements Comparator<PresupuestoDTO> {

	private String sortField;
    private SortOrder sortOrder;
    
    public PresupuestosLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(PresupuestoDTO presupuesto1, PresupuestoDTO presupuesto2) {
        try {
        	Object value1 = PropertyUtils.getProperty(presupuesto1, this.sortField);
        	Object value2 = PropertyUtils.getProperty(presupuesto2, this.sortField);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
