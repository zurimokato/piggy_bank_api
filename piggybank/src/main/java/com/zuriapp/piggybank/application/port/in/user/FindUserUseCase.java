package com.zuriapp.piggybank.application.port.in.user;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.domain.models.User;

public interface FindUserUseCase {
    User findUserByUsername(String username) throws DomainException;
    User findUserByToken(String token) throws DomainException;
}
