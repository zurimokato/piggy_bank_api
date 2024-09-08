package com.zuriapp.piggybank.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;

@Getter
@Setter
@Builder
public class ErrorResponseDTO {
    private String code;
    private String message;
    private String description;

    public String getDescription() {
        return ObjectUtils.isEmpty(description) ? message : description;
    }
}
