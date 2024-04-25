package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserOutPort {

    User save(User user) throws Exception;
    User findByUsername(String username);
    UserDetailsService userDetailsService();
    User findByEmail(String email);
    User findByUserName(String userName);
}
