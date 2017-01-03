package com.ceriarte.central.enums;

public enum UsuarioEnum {
	SIERRA_SOFT_ADMIN(1),
	COMPANY_ADMIN(2);
    
    private Integer value;

    private UsuarioEnum(Integer value) {
        this.value = value;
    }

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}