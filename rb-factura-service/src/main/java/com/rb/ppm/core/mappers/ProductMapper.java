package com.rb.ppm.core.mappers;

import com.rb.ppm.application.dto.Invoice;
import com.rb.ppm.application.dto.Product;
import com.rb.ppm.core.domain.InvoiceEntity;
import com.rb.ppm.core.domain.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( uses = SupplierMapper.class)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    ProductEntity toEntity(Product product);

    Product toDTO(ProductEntity productEntity);

}
