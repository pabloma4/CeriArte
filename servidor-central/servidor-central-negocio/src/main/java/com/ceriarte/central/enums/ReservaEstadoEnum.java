package com.ceriarte.central.enums;

public enum ReservaEstadoEnum {
	SOLICITADA("sol"),
	CONFIRMADA("con"), 
    IMPRESA("imp"),
    ANULADA("anu"),
    FINALIZADA("fin");
    
    private String value;

    private ReservaEstadoEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}