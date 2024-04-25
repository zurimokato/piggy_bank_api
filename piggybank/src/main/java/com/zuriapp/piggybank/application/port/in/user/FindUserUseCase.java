package com.zuriapp.piggybank.application.port.in.user;

import com.zuriapp.piggybank.domain.models.User;

public interface FindUserUseCase {
    User findUserByUsername(String username) throws Exception;
    User findUserByToken(String token) throws Exception;
}
