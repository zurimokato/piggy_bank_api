package com.zuriapp.piggybank.domain.service;

import com.zuriapp.piggybank.application.exceptions.DomainException;
import com.zuriapp.piggybank.application.port.in.count.CreateCountUseCase;
import com.zuriapp.piggybank.application.port.in.count.FindCountUseCase;
import com.zuriapp.piggybank.application.port.out.CountOutPort;
import com.zuriapp.piggybank.domain.models.Count;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountService implements CreateCountUseCase, FindCountUseCase {
    private final CountOutPort port;

    @Override
    public Count createCount(Count count) throws DomainException {
        try {
            count.setCreateTime(LocalDateTime.now());
            return port.save(count);
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }

    }

    @Override
    public Page<Count> findCountUseCase(Long userId, Pageable pageable) throws DomainException {
        try {
            return port.getAllCountsByPerson(userId, pageable);
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }

    }

    @Override
    public Count findCountById(Long id) throws DomainException {
        try {
            return port.getCountById(id);
        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }

    }
}
