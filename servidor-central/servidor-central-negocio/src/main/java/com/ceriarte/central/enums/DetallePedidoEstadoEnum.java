package com.ceriarte.central.enums;

public enum DetallePedidoEstadoEnum {
    PENDIENTE_ELABORACION(1), 
    PENDIENTE_ENTREGA(2),
    EN_CONSTRUCCION(3),
    ENTREGADO(4),
    CANCELADO(5),
    SUSPENDIDO(6);
    
    private int value;

    private DetallePedidoEstadoEnum(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}