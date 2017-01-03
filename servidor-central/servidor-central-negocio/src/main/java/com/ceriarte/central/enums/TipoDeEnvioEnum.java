package com.ceriarte.central.enums;

public enum TipoDeEnvioEnum {
    BOLETERIA(1);
    
    private int value;

    private TipoDeEnvioEnum(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}