package com.zuriapp.piggybank.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDataResponse<T> extends BaseResponseDTO{
    private T data;
}
