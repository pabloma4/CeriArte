package com.ceriarte.central.enums;

public enum TipoSectorEnum {
    NORMAL("N"),
    UNICO("U");
    
    private String value;

    private TipoSectorEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}