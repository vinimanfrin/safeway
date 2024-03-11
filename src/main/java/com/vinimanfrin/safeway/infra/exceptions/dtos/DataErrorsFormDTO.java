package com.vinimanfrin.safeway.infra.exceptions.dtos;

import org.springframework.validation.FieldError;

public record DataErrorsFormDTO(String field, String messsage) {

    public DataErrorsFormDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
