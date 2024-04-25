package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.PersonRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserRestMapper.class})
public interface PersonRestMapper {
    PersonResponse toResponse(Person person);

    @Mappings({
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "updateTime", ignore = true),
            @Mapping(target = "user", source = "user"),
            @Mapping(target = "counts",ignore = true),
            @Mapping(target = "status",ignore = true)
    })
    Person toDomain(PersonRequest request);

}
