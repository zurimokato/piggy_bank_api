package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.zuriapp.piggybank.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PERSONAS")
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "first_last_name")
    private String firstLastName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "second_last_name")
    private String secondLastName;
    private Integer age;
    private char gender;
    private String nit;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    @JoinColumn(name = "users_id")
    private UserEntity user;
    @OneToMany(mappedBy = "person")
    private List<CountEntity> counts;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
