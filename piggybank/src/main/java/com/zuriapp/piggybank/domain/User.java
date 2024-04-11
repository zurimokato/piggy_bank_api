package com.zuriapp.piggybank.domain;


import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String userName;
    private String password;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
