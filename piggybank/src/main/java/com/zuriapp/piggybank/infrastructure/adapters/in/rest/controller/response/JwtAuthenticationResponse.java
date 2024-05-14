package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;


import com.zuriapp.piggybank.domain.dto.BaseResponseDTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JwtAuthenticationResponse extends BaseResponseDTO {
    private String token;

}
