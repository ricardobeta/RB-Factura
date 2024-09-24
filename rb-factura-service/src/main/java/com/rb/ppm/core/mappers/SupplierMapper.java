package com.rb.ppm.core.mappers;

import com.rb.ppm.application.dto.Invoice;
import com.rb.ppm.application.dto.Supplier;
import com.rb.ppm.core.domain.InvoiceEntity;
import com.rb.ppm.core.domain.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface SupplierMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "businessName", target = "businessName")
    SupplierEntity toEntity(Supplier supplier);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "businessName", target = "businessName")
    Supplier toDTO(SupplierEntity supplier);

}
