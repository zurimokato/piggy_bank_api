package com.zuriapp.piggybank.application.port.out;

import com.zuriapp.piggybank.domain.User;

public interface UserOutPort {

    User save(User user);
    User findByUsername(String username);

}
