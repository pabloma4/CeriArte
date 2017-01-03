package com.ceriarte.central.enums;

public enum TipoValorEnum {
    MONTO(1),
    PORCENTAJE(2),
    MONTO_FIJO(3),
    INVITACION(4);
    
    private int value;

    private TipoValorEnum(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}