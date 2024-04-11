package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.Person;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {UserEntityMapper.class})
public interface PersonEntityMapper {

    @Mapping(source = "user",target = "user")
    Person toDomain(PersonEntity personEntity);

    @Mapping(source = "user",target = "user")
    PersonEntity toEntity(Person person);
}
