package com.ceriarte.central.enums;

public enum PermisoEnum {
	VIEW_ONLY_COMPANY_USUARIOS(5),
	VIEW_ALL_USUARIOS(6);
    
    private Integer value;

    private PermisoEnum(Integer value) {
        this.value = value;
    }

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}