package com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.validation;

import com.zuriapp.piggybank.infrastructure.adapters.in.rest.controller.validation.validator.EmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidation {
    String message() default "Invalid email address"; // Default error message

    Class<?>[] groups() default {}; // Used for grouping constraints

    Class<? extends Payload>[] payload() default {};
}
