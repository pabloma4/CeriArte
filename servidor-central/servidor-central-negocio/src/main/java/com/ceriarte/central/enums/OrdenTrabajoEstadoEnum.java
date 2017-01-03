package com.ceriarte.central.enums;

public enum OrdenTrabajoEstadoEnum {
    NUEVA(1), 
    EN_CONSTRUCCION(2),
    FINALIZADA(3),
    SUSPENDIDA(4),
    CANCELADA(5);
    private int value;

    private OrdenTrabajoEstadoEnum(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}