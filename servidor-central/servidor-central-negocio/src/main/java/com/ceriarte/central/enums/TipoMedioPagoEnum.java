package com.ceriarte.central.enums;

public enum TipoMedioPagoEnum {
    EFECTIVO(1),
    TARJETA_CREDITO(2);
    
    private Integer value;

    private TipoMedioPagoEnum(Integer value) {
        this.value = value;
    }

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}