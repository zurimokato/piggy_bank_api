package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.Count;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountEntityMapper {
    Count toDomain(CountEntity entity);
    CountEntity toEntity(Count domain);

}
