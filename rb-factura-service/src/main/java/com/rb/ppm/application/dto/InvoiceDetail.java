package com.rb.ppm.application.dto;


import lombok.Data;

@Data
public class InvoiceDetail {
    private Long id;
    private Product product;
    private Integer quantity;
}
