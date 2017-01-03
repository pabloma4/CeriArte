package com.ceriarte.central.enums;

public enum TipoOperacionEnum {
    VENTA(1),
    ANULACION(2);
    
    private int value;

    private TipoOperacionEnum(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}