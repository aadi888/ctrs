package dsynhub.ctrs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsynhub.ctrs.dao.ExtraDAO;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;






public class GenerateReport extends HttpServlet {

	private static final long serialVersionUID = -6534192861364923526L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("Genetate Report");
			// Get requested student id from user request
		//	String studentId = request.getParameter("sid");
			
			// Get requested report type from user request
			ExtraDAO dao=new ExtraDAO();
			String reportType = request.getParameter("reportType");
			
			// Setting Default report Type
            if(reportType == null || reportType.trim().length() == 0){
            	reportType = "pdf";
            }
			
			// Get servlet Out put stream to displat report at client side
			ServletOutputStream sos = response.getOutputStream();
			
			// Construct path for your .jrxml file 
			ServletContext application = getServletContext();
			String prefix = application.getRealPath("\\");
			String file = getInitParameter("reportTemplet");
			String path = prefix + file;
			System.out.println("Path : "+path);
			
			// Load that .jrxml file in Jasper Design
			JasperDesign jasperDesign = JRXmlLoader.load(path);
			
			// Compile that .jrxml file into .jasper file 
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			/* Populate data from your database It must contain all the fields used in designing a .jrxml file
			   Here we have used Java Bean Data Source in generating report.
			   So populate ArrayList which contains your collection of your beans.
			*/
			
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dao.selectFeedback(),false);
			
			// Filling the reports using your .jasper file and generated Java Bean Datasource
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, ds);
			
			// Response for generating PDF report
			if(reportType!=null && reportType.equals("pdf")){
				System.out.println("PDF");
				response.setContentType("application/pdf");
				JRPdfExporter expoterPDF = new JRPdfExporter();
				expoterPDF.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				expoterPDF.setParameter(JRExporterParameter.OUTPUT_STREAM, sos);
				expoterPDF.exportReport();
			}
			
            // Response for generating EXCEL report
			if(reportType!=null && reportType.equals("excel")){
				response.setContentType("application/vnd.ms-excel");
				JRXlsExporter exporterXLS = new JRXlsExporter();
				exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
				exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, sos);
				exporterXLS.exportReport();
			}
			
			// Response for generating WORD report
			if(reportType!=null && reportType.equals("word")){
				response.setContentType("application/msword");
				JRRtfExporter exporterRTF = new JRRtfExporter();
				exporterRTF.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporterRTF.setParameter(JRExporterParameter.OUTPUT_STREAM, sos);
				exporterRTF.exportReport();
			}
            
			// Closing all opened streams
			sos.flush();
			sos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
