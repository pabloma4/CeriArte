package com.ceriarte.central.enums;

public enum TicketEstadoEnum {
    DISPONIBLE("dis"), 
    VENDIDO("ven"), 
    RESERVADO("res"), 
    BLOQUEADO("blq"), 
    EN_PROCESO_VENTA("pvt"), 
    PREVENTA("pre"), 
    INVITACION("inv"), 
    VENTA_ELECTRONICA_NO_ENT("ele"), 
    ENTREGADO("ent"), 
    EN_PROCESO_VENTA_IMPRIMIENDO("pim"), 
    ACTUALIZANDO_CAJA("caj"), 
    PEDIDO("ped"), 
    PEDIDO_IMPRESO("pei"), 
    PEDIDO_CONFIRMADO("pec"), 
    RESERVA_INTERNET("rin"), 
    RESERVADO_RETIRO("ret");
    
    private String value;

    private TicketEstadoEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}