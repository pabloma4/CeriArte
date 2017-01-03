package com.ceriarte.central.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.ceriarte.central.utilidades.FechaUtil;
import com.ceriarte.central.web.report.DynamicColumnDataSource;
import com.ceriarte.central.web.report.DynamicReportBuilder;
import com.ceriarte.central.web.report.ReportConfigUtil;

public abstract class AbstractReportController extends AbstractController{

	public enum ExportOption {
	    PDF, HTML, EXCEL, RTF
	}
	
	private ExportOption exportOption;
	private JasperPrint jasperPrint;
	private final String COMPILE_DIR = "/WEB-INF/report/design/";
	private String message;
	
	protected void createReport () throws JRException, IOException{	
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    ServletContext context = (ServletContext) externalContext.getContext();
	    ReportConfigUtil.compileReport(context, getCompileDir(), getCompileFileName());
	    File reportFile = new File(ReportConfigUtil.getJasperFilePath(context, getCompileDir(), getCompileFileName() + ".jasper"));
	    jasperPrint = ReportConfigUtil.fillReport(reportFile, getReportParameters(), getJRBeanCollectionDataSource());
	}
	
	protected void createReport (String compileFileName, JRBeanCollectionDataSource jrBeanCollectionDataSource) throws JRException, IOException{	
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    ServletContext context = (ServletContext) externalContext.getContext();
	    ReportConfigUtil.compileReport(context, getCompileDir(), compileFileName);
	    File reportFile = new File(ReportConfigUtil.getJasperFilePath(context, getCompileDir(), compileFileName + ".jasper"));
	    jasperPrint = ReportConfigUtil.fillReport(reportFile, getReportParameters(), jrBeanCollectionDataSource);
	}
	
	public void createReport(String compileFileName, List<String> columnHeaders, List<List<String>> rows) throws JRException { 
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		ServletContext context = (ServletContext) externalContext.getContext();
		File reportFile = new File(ReportConfigUtil.getJasperFilePath(context, getCompileDir(), compileFileName + ".jrxml"));
		try {
			InputStream is = new FileInputStream(reportFile);
			JasperDesign jasperReportDesign = JRXmlLoader.load(is);
			
			DynamicReportBuilder reportBuilder = new DynamicReportBuilder(jasperReportDesign, columnHeaders.size());
			reportBuilder.addDynamicColumns();
			 
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperReportDesign);
			 
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("REPORT_TITLE", "Sample Dynamic Columns Report");
			DynamicColumnDataSource pdfDataSource = new DynamicColumnDataSource(columnHeaders, rows);
			jasperPrint = JasperFillManager.fillReport(jasperReport, params, pdfDataSource);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		 
	}
	
	protected void exportReport() throws JRException, IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

	    if (getExportOption().equals(ExportOption.HTML)) {
	       response.addHeader("Content-disposition","attachment; filename=report.html");
	       ReportConfigUtil.exportReportAsHtml(jasperPrint, response.getWriter(), request);
	    } 
	    if (getExportOption().equals(ExportOption.PDF)) {
	    	String fileName = getCompileFileName() + "_" + FechaUtil.convertDateToString(new Date());
		    response.addHeader("Content-disposition","inline; filename="+fileName+".pdf");
	        response.setContentType("application/pdf");
	        ReportConfigUtil.exportReportAsPDF(jasperPrint, response);
	    }

	    FacesContext.getCurrentInstance().responseComplete();
	}

	public ExportOption getExportOption() {
	    return exportOption;
	}

	public void setExportOption(ExportOption exportOption) {
	    this.exportOption = exportOption;
	}

	protected String getCompileDir() {
	    return COMPILE_DIR;
	}

	public String getMessage() {
	    return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}
	
	abstract String getCompileFileName();

	abstract JRBeanCollectionDataSource getJRBeanCollectionDataSource();
	
	abstract Map<String, Object> getReportParameters();

}
