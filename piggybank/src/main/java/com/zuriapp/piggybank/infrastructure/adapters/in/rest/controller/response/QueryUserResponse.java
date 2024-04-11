package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class QueryUserResponse extends BaseResponseDTO {
    private UserResponse user;
}
