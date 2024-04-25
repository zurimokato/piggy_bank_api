package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.models.Count;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.CountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PersonEntityMapper.class})
public interface CountEntityMapper {
    @Mappings({
            @Mapping(target = "person",source = "person")

    })
    Count toDomain(CountEntity entity);

    @Mappings({
            @Mapping(target = "person",source = "person"),
            @Mapping(target = "transactions", ignore = true)

    })
    CountEntity toEntity(Count domain);

}
