package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDate createTime;
    private LocalDate updateTime;
}
