package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDate createTime;
    private LocalDate updateTime;
}
