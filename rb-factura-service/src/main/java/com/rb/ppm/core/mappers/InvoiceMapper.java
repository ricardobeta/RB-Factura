package com.rb.ppm.core.mappers;


import com.rb.ppm.application.dto.Invoice;
import com.rb.ppm.core.domain.InvoiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CustomerMapper.class,InvoiceDetailMapper.class})
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    InvoiceEntity toEntity(Invoice invoice);

    Invoice toDTO(InvoiceEntity invoiceEntity);
}
