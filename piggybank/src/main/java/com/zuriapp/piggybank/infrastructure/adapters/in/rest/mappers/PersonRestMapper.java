package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.Person;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.PersonRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.PersonResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonRestMapper {
    PersonResponse toResponse(Person person);

    Person toDomain(PersonRequest request);

}
