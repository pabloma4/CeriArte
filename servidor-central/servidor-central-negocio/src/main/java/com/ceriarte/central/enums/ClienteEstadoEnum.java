package com.ceriarte.central.enums;

public enum ClienteEstadoEnum {
    ACTIVO("act"), 
    INACTIVO("ina");
    
    private String value;

    private ClienteEstadoEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}