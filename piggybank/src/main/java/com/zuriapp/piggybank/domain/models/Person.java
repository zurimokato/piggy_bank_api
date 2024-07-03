package com.zuriapp.piggybank.domain.models;

import com.zuriapp.piggybank.domain.enums.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Count> counts;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
