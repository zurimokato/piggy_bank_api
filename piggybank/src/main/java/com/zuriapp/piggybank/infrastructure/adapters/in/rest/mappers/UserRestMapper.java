package com.zuriapp.piggybank.infrastructure.adapters.in.rest.mappers;

import com.zuriapp.piggybank.domain.User;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.request.UserRequest;
import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = PersonRestMapper.class)
public interface UserRestMapper {
    UserResponse toUserResponse(User user);

    @Mappings({
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "updateTime", ignore = true),
    })
    User toDomain(UserRequest request);
}
