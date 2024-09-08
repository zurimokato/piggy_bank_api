package com.zuriapp.piggybank.domain.dto;

import lombok.Data;

@Data
public class BaseResponseDTO {
    private String status;
    private String result;
    private ErrorResponseDTO error;

    private static BaseResponseDTO instance;
    protected BaseResponseDTO(){
        this.status = "200";
        this.result = "OK";
    }

    public static BaseResponseDTO getInstance() {
        if (instance == null) {
            instance = new BaseResponseDTO();
        }
        return instance;
    }

}
