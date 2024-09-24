package com.rb.ppm.core.services;

import com.rb.ppm.application.dto.Product;
import com.rb.ppm.core.mappers.ProductMapper;
import com.rb.ppm.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductList(){
        return  productRepository.findAll().stream().map(ProductMapper.INSTANCE::toDTO).toList();
    }
}
