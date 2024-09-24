package com.rb.ppm.application.dto;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String identification;
}
