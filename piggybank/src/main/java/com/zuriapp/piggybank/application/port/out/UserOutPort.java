package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.application.exceptions.InfrastructureException;
import com.zuriapp.piggybank.domain.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserOutPort {

    User save(User user) throws InfrastructureException;
    User findByUsername(String username);
    UserDetailsService userDetailsService();
    User findByEmail(String email);
    User findUserByName(String userName);
}
