package com.ceriarte.central.web.datamodels;

import java.util.Comparator;

import org.apache.commons.beanutils.PropertyUtils;
import org.primefaces.model.SortOrder;

import com.ceriarte.central.dominio.dto.ProductoDTO;

public class ProductosLazySorter implements Comparator<ProductoDTO> {

	private String sortField;
    private SortOrder sortOrder;
    
    public ProductosLazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(ProductoDTO producto1, ProductoDTO producto2) {
        try {
        	Object value1 = PropertyUtils.getProperty(producto1, this.sortField);
        	Object value2 = PropertyUtils.getProperty(producto2, this.sortField);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
