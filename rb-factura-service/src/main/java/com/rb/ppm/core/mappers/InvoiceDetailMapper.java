package com.rb.ppm.core.mappers;

import com.rb.ppm.application.dto.InvoiceDetail;
import com.rb.ppm.core.domain.InvoiceDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( uses = {ProductMapper.class})
public interface InvoiceDetailMapper {

    InvoiceDetailMapper INSTANCE = Mappers.getMapper(InvoiceDetailMapper.class);

    InvoiceDetailEntity toEntity(InvoiceDetail invoiceDetail);

    InvoiceDetail toDTO(InvoiceDetailEntity invoiceDetailEntity);
}
