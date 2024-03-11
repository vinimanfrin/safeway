package com.vinimanfrin.safeway.infra.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.vinimanfrin.safeway.infra.exceptions.dtos.DataErrorsFormDTO;
import com.vinimanfrin.safeway.infra.exceptions.dtos.ErrorsData;
import com.vinimanfrin.safeway.models.TransactionType;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

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
    public ResponseEntity handleDataIntegrityViolation(DataIntegrityViolationException e) {

        String errorMessage = e.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorsData(errorMessage));
    }

    @ExceptionHandler(TransactionValidationException.class)
    public ResponseEntity handleTransactionValidation(TransactionValidationException e){
        return ResponseEntity.badRequest().body(new ErrorsData(e.getMessage()));
    }

    @ExceptionHandler(InvalidFormatException.class)
    protected ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException e) {
        if (e.getTargetType() == TransactionType.class) {
            return ResponseEntity.badRequest().body(new ErrorsData("O valor fornecido para o campo 'transactionType' é inválido."));
        }
        return ResponseEntity.badRequest().body(new ErrorsData(e.getMessage()));
    }
}
