package com.rb.ppm.application.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private Supplier supplier;
    private Integer stock;
}
