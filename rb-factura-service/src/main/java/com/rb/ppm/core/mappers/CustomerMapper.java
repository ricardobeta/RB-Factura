package com.rb.ppm.core.mappers;

import com.rb.ppm.application.dto.Customer;
import com.rb.ppm.core.domain.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity toEntity(Customer customer);

    Customer toDTO(CustomerEntity customerEntity);
}
