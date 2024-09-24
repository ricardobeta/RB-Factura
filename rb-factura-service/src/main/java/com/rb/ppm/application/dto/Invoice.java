package com.rb.ppm.application.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class Invoice {
    private Long id;
    private LocalDate date;
    private Customer customer;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal total;
    private List<InvoiceDetail> invoiceDetails;
}
