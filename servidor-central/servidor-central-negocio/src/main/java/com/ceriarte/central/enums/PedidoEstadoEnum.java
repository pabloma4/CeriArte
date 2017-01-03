package com.ceriarte.central.enums;

public enum PedidoEstadoEnum {
	NUEVO(1),
	PENDIENTE_ENTREGA(2),
    ENTREGADO_PARCIAL(3),
    ENTREGADO(4),
    CANCELADO(5);
    
    private int value;

    private PedidoEstadoEnum(int value) {
        this.value = value;
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}