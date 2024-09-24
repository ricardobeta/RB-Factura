package com.rb.ppm.core.services;

import com.rb.ppm.application.dto.Invoice;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {


    public  byte[] generateInvoiceReportPDF(Invoice invoice) throws JRException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("templates/invoice_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JRBeanCollectionDataSource detailsDataSource = new JRBeanCollectionDataSource(invoice.getInvoiceDetails());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", invoice.getId());
        parameters.put("date", invoice.getDate());
        parameters.put("customerName", invoice.getCustomer().getName());
        parameters.put("subtotal", invoice.getSubtotal());
        parameters.put("iva", invoice.getIva());
        parameters.put("total", invoice.getTotal());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, detailsDataSource);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte.pdf");
        return outputStream.toByteArray();
    }
}
