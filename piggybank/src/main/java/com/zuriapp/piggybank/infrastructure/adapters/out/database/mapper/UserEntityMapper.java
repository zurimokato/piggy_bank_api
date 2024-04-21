package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {


    @Mappings({
            @Mapping(target = "person.user", ignore = true),
    })
    User toDomain(UserEntity source);


    @Mappings({
            @Mapping(target = "userName", source = "username"),
            @Mapping(target = "person.user", ignore = true),
            @Mapping(target = "authorities", ignore = true)

    })
    UserEntity toEntity(User source);
}
