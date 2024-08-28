package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.validation.validator;

import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.validation.EmailValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {


    private static final String EMAIL_REGEX = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    @Override
    public void initialize(EmailValidation constraintAnnotation) {
        // Any initialization code goes here
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return false; // Null or empty string is not considered valid
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
