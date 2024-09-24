package com.rb.ppm.core.mappers;

import com.rb.ppm.application.dto.AuthRq;
import com.rb.ppm.core.domain.OfficerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface OfficerMapper {

    OfficerMapper INSTANCE = Mappers.getMapper(OfficerMapper.class);

    OfficerEntity toEntity(AuthRq authRq);
}
