package com.ceriarte.central.utilidades;

import java.math.BigDecimal;

public abstract class Utilidades {

	public static final String TICKET = "Ticket";
	public static final String SERVICE_CHARGE = "Service Charge";
	public static final String COSTO_RESERVA = "Costo Reserva";
	public static final BigDecimal PORCENTAJE_IVA = new BigDecimal(21.00);
	
	public static String getSigno(double valor){
		return valor > 0 ? "+" : "-";
	}
	
	public static String removerGuiones(String str) {
		return str == null ? null : str.replaceAll("\\D", "");
	}
	
	public static double substractIVA(double amount) {
		return redondear3Decimales(amount / ((100 + Utilidades.PORCENTAJE_IVA.doubleValue())/100));
	}
	
	public static double redondear3Decimales(double value){
		return (double)Math.round(value * 1000) / 1000;
	}
}
