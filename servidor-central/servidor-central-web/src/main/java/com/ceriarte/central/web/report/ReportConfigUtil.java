package com.ceriarte.central.web.report;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

public class ReportConfigUtil {

	/**
	 * PRIVATE METHODS
	 */
	private static void setCompileTempDir(ServletContext context, String uri) {
	    System.setProperty("jasper.reports.compile.temp", context.getRealPath(uri));
	}

	/**
	 * PUBLIC METHODS
	 */
	public static boolean compileReport(ServletContext context, String compileDir, String filename) throws JRException {
	    String jasperFileName = context.getRealPath(compileDir + filename + ".jasper");
	    File jasperFile = new File(jasperFileName);

	    if (jasperFile.exists()) {
	        return true; // jasper file already exists, do not compile again
	    }
	    try {
	        // jasper file has not been constructed yet, so compile the xml file
	        setCompileTempDir(context, compileDir);

	        String xmlFileName = jasperFileName.substring(0, jasperFileName.indexOf(".jasper")) + ".jrxml";
	        JasperCompileManager.compileReportToFile(xmlFileName);

	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public static JasperPrint fillReport(File reportFile, Map<String, Object> parameters, JRBeanCollectionDataSource beanCollectionDataSource) throws JRException {
	    parameters.put("BaseDir", reportFile.getParentFile());
	    JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile.getPath(), parameters, beanCollectionDataSource);

	    return jasperPrint;
	}

	public static String getJasperFilePath(ServletContext context, String compileDir, String jasperFile) {
	    return context.getRealPath(compileDir + jasperFile);
	}

	public static void exportReport(JRAbstractExporter exporter, JasperPrint jasperPrint, PrintWriter out) throws JRException {
	    try{
	    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	    exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);

	    exporter.exportReport();
	    }catch(Exception e){e.printStackTrace();e.getMessage();}
	}

	public static void exportReportAsHtml(JasperPrint jasperPrint, PrintWriter out, HttpServletRequest request) throws JRException {
		
		JRHtmlExporter exporter = new JRHtmlExporter();
	    exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
	    exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	    request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint); 
	    exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,"http://localhost:8080/servidor-central-web/image?image=");
	    exportReport(exporter, jasperPrint, out);
	}
	
	public static void exportReportAsPDF(JasperPrint jasperPrint,HttpServletResponse response) throws JRException {
		JRExporter exporter = null;
		try {
			exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
			exporter.exportReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}	