package com.zuriapp.piggybank.infrastructure.adapters.out.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zuriapp.piggybank.domain.enums.Role;
import com.zuriapp.piggybank.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String userName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDate createTime;
    private LocalDate updateTime;
    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER)
    private PersonEntity person;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<CountEntity> counts;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<BudgetEntity>budgets;

    @Enumerated(EnumType.STRING)
    private Status status;


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
