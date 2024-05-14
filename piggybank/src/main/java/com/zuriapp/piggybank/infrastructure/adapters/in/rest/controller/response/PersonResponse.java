package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.response;

import com.zuriapp.piggybank.domain.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PersonResponse {
    private Long id;
    private String firstName;
    private String firstLastName;
    private String secondName;
    private String secondLastName;
    private Integer age;
    private char gender;
    private String nit;
    private String phone;
    private Status status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private UserResponse user;
}
