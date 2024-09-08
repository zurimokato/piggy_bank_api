package com.zuriapp.piggybank.infrastructure.adapters.out.database.mapper;

import com.zuriapp.piggybank.domain.models.User;
import com.zuriapp.piggybank.infrastructure.adapters.out.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PersonEntityMapper.class, BudgetEntityMapper.class})
public interface UserEntityMapper {


    @Mapping(target = "person.user", ignore = true)

    User toDomain(UserEntity source);


    @Mapping(target = "userName", source = "username")
    @Mapping(target = "person.user", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "counts", ignore = true)
    @Mapping(target = "budgets", ignore = true)
    UserEntity toEntity(User source);
}
