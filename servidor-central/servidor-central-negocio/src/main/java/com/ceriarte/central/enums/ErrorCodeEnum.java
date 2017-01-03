package com.ceriarte.central.enums;

public enum ErrorCodeEnum {
	USUARIO_LOGIN_DUPLICADO("3000"),
	USUARIO_EMAIL_DUPLICADO("3001"),
	USUARIO_SIN_ROLES("3002"),
	ORDEN_TRABAJO_SIN_USUARIO_ASIGNADO("3003");
    
    
    private String value;

    private ErrorCodeEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
