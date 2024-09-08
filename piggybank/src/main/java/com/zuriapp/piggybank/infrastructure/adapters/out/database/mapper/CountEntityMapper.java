package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.models.Count;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class})
public interface CountEntityMapper {

    @Mapping(target = "user", source = "user")
    Count toDomain(CountEntity entity);


    @Mapping(target = "user", source = "user")
    @Mapping(target = "transactions", ignore = true)
    CountEntity toEntity(Count domain);

}
