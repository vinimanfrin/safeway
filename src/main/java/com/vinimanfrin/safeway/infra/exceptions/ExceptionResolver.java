package com.vinimanfrin.safeway.infra.exceptions;

import com.vinimanfrin.safeway.infra.exceptions.dtos.DataErrorsFormDTO;
import com.vinimanfrin.safeway.infra.exceptions.dtos.ErrorsData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadRequest(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorsFormDTO::new).toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolation(DataIntegrityViolationException ex) {

        String errorMessage = ex.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorsData(errorMessage));
    }
}
