package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String userName;
    private String password;
    private String email;
    private LocalDate createTime;
    private LocalDate updateTime;
    @OneToOne(mappedBy = "user")
    private PersonEntity person;
}
