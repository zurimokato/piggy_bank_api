package com.zuriapp.piggybank.infrastructure.adapters.out.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageConfigAdapter {

    private final MessageSource messageSource;


    public String getSuccessMessage(){
        return getMessage("response.success.message", Locale.getDefault());
    }



    private String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }

}
