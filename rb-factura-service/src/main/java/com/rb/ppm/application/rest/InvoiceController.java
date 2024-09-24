package com.rb.ppm.application.rest;

import com.rb.ppm.application.dto.Invoice;
import com.rb.ppm.core.services.InvoiceService;
import com.rb.ppm.core.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {


    @Autowired
    InvoiceService invoiceService;

    @Autowired
    ReportService reportService;


    @GetMapping("/{id}/report")
    public ResponseEntity<byte[]> generateInvoiceReport(@PathVariable Long id) {
        try {
            Invoice invoice = invoiceService.getInvoiceById(id);
            byte[] pdfBytes = reportService.generateInvoiceReportPDF(invoice);
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=invoice_" + id + ".pdf");
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_PDF);
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping()
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }


    @GetMapping()
    public ResponseEntity<List<Invoice>> getAllInvoice(){
        return ResponseEntity.ok(invoiceService.getAllInvoice());
    }
}
