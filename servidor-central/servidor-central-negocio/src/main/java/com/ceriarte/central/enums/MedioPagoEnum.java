package com.ceriarte.central.enums;

public enum MedioPagoEnum {
    EFECTIVO(1);
    
    private Integer value;

    private MedioPagoEnum(Integer value) {
        this.value = value;
    }

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}