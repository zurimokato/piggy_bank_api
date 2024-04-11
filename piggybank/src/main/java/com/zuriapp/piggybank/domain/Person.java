package com.zuriapp.piggybank.domain;

import com.zuriapp.piggybank.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
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
    private User user;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
