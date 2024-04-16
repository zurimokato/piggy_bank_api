package com.zuriapp.piggybank.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Page;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageResponseDTO<T> extends BaseResponseDTO{

    private Page<T> data;

}
