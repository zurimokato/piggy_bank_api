package com.zuriapp.piggybank.application.port;

import jakarta.transaction.Transactional;

public interface IRequestHandler<S,T> {

    @Transactional
    T handle(S request) throws Exception;
}
