package com.ceriarte.central.enums;

public enum TipoMovimientoCajaEnum {
	PAGO("PAG");

	private String value;

	private TipoMovimientoCajaEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}