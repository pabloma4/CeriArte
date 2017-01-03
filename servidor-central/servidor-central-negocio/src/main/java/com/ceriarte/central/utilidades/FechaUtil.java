package com.ceriarte.central.utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class FechaUtil {
	
	private static final String FORMAT = "dd/MM/yyyy HH:mm:ss";
		
	/**
	 * @param fecha
	 * @param min
	 * 
	 * @return Date
	 * 
	 * Devuelve una fecha que surge de restarle, a la fecha pasada por parametro, los minutos pasados por parámetro
	 */
	public static Date restarMinutos(Date fecha, int min){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, -min);
		fecha = c.getTime();

		return fecha;
	}
	
	/**
	 * @param fecha
	 * @param min
	 * 
	 * @return Date
	 * 
	 * Devuelve una fecha que surge de sumarle, a la fecha pasada por parametro, los minutos pasados por parámetro
	 */
	public static Date sumarMinutos(Date fecha, int min){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, min);
		fecha = c.getTime();

		return fecha;
	}
	
	/**
	 * @param date
	 * 
	 * @return Date
	 * 
	 * Devuelve la fecha pasada por parámetro pero con la hora 23:59:59
	 */
	public static Date getFechaFinalDia(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		return cal.getTime();
	}

	/**
	 * @param date
	 * 
	 * @return String
	 * 
	 * Devuelve la fecha pasada por parámetro en String con formato "dd/MM/yyyy HH:mm:ss"
	 */
	public static String convertDateToString(Date fecha){
		DateFormat df = new SimpleDateFormat(FORMAT);
		return df.format(fecha);
	}
}
