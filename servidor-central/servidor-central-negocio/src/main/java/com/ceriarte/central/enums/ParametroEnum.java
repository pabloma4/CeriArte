package com.ceriarte.central.enums;

public enum ParametroEnum {
	UPLOADS_UBICACION("uploads_ubicacion"),
	UPLOADS_PLANO_SECTORES_UBICACION("uploads_plano_sectores_ubicacion"),
	UPLOADS_CONTEXTO("uploads_contexto"),
	UPLOADS_PLANO_SECTORES_CONTEXTO("uploads_plano_sectores_contexto");
	

	private String clave;

    private ParametroEnum(String clave) {
        this.clave = clave;
    }

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
