package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toDomain(UserEntity source);

    UserEntity toEntity(User source);
}
