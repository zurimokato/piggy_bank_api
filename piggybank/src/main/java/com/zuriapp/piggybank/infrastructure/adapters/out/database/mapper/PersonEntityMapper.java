package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.models.Person;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {UserEntityMapper.class})
public interface PersonEntityMapper {


    @Mappings({
            @Mapping(source = "user", target = "user"),
            @Mapping(target = "user.person", ignore = true)
    })
    Person toDomain(PersonEntity personEntity);


    @Mappings({
            @Mapping(source = "user", target = "user"),
            @Mapping(target = "user.person", ignore = true),
            @Mapping(target = "user.authorities", ignore = true),
            @Mapping(target = "user.userName", ignore = true),
    })
    PersonEntity toEntity(Person person);
}
