package com.ceriarte.central.enums;

public enum PresupuestoEstadoEnum {
    CREADO(1), 
    APROBADO(2),
    NO_APROBADO(3),
    CANCELADO(4);
    
    private int value;

    private PresupuestoEstadoEnum(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}