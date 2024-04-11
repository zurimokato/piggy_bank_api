package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.Count;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PersonEntity.class})
public interface CountEntityMapper {
    @Mappings({
            @Mapping(target = "person",source = "person")
    })
    Count toDomain(CountEntity entity);
    CountEntity toEntity(Count domain);

}
