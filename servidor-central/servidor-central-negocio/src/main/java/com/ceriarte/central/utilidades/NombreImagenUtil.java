package com.ceriarte.central.utilidades;

import org.apache.commons.io.FilenameUtils;

public abstract class NombreImagenUtil {
	
	// Entidades para las que se guarda la imagen
	public static final String EVENTO = "evento";
	public static final String SHOW = "show";
	
	// Tipos de Imágenes
	public static final String IMG_PRINCIPAL = "imgPrincipal";
	public static final String IMG_SECUNDARIA = "imgSecundaria";
	public static final String IMG_ALTA_DEFINICION = "imgAltaDefinicion";
	public static final String IMG_PASADOR_PORTAL = "imgPasadorPortal";
	public static final String IMG_PLANO_SECTORES = "imgPlanoSectores";
	
	public static final String SEPARADOR = "_";
	public static final String TEMPORAL = "tmp";
	
	private static String getNombreImg(String entidad, int idEntidad, String tipoImagen, String originalFileName, boolean temp) {
		String nombre = "";
		String extension = FilenameUtils.getExtension(originalFileName);
		if (temp) {
			nombre = TEMPORAL + SEPARADOR;
		}
		nombre = nombre + entidad + SEPARADOR + idEntidad + SEPARADOR + tipoImagen + "." + extension;
		return nombre;
	}

	public static String getNombreEventoImgPrincipal(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_PRINCIPAL, originalFileName, false);
	}

	public static String getNombreEventoImgPrincipalTemp(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_PRINCIPAL, originalFileName, true);
	}

	public static String getNombreEventoImgSecundaria(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_SECUNDARIA, originalFileName, false);
	}

	public static String getNombreEventoImgSecundariaTemp(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_SECUNDARIA, originalFileName, true);
	}

	public static String getNombreEventoImgAltaDefinicion(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_ALTA_DEFINICION, originalFileName, false);
	}

	public static String getNombreEventoImgAltaDefinicionTemp(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_ALTA_DEFINICION, originalFileName, true);
	}

	public static String getNombreEventoImgPasadorPortal(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_PASADOR_PORTAL, originalFileName, false);
	}

	public static String getNombreEventoImgPasadorPortalTemp(int idEvento, String originalFileName) {
		return getNombreImg(EVENTO, idEvento, IMG_PASADOR_PORTAL, originalFileName, true);
	}

	public static String getNombreShowImgPrincipal(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_PRINCIPAL, originalFileName, false);
	}

	public static String getNombreShowImgPrincipalTemp(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_PRINCIPAL, originalFileName, true);
	}

	public static String getNombreShowImgSecundaria(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_SECUNDARIA, originalFileName, false);
	}

	public static String getNombreShowImgSecundariaTemp(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_SECUNDARIA, originalFileName, true);
	}

	public static String getNombreShowImgAltaDefinicion(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_ALTA_DEFINICION, originalFileName, false);
	}

	public static String getNombreShowImgAltaDefinicionTemp(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_ALTA_DEFINICION, originalFileName, true);
	}

	public static String getNombreShowImgPasadorPortal(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_PASADOR_PORTAL, originalFileName, false);
	}

	public static String getNombreShowImgPasadorPortalTemp(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_PASADOR_PORTAL, originalFileName, true);
	}

	public static String getNombreShowImgPlanoSectores(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_PLANO_SECTORES, originalFileName, false);
	}

	public static String getNombreShowImgPlanoSectoresTemp(int idShow, String originalFileName) {
		return getNombreImg(SHOW, idShow, IMG_PLANO_SECTORES, originalFileName, true);
	}
}
