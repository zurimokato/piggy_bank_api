package com.zuriapp.piggybank.domain.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BaseResponseDTO {
    private HttpStatus status;
    private String message;
    private String code;
    private LocalDate transactionDate;
    private LocalTime transactionTime;

    private static BaseResponseDTO instance;
    protected BaseResponseDTO(){
        this.status = HttpStatus.OK;
        this.code = "OK";
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalTime.now();

    }

    public static BaseResponseDTO getInstance() {
        if (instance == null) {
            instance = new BaseResponseDTO();
        }
        return instance;
    }
}
