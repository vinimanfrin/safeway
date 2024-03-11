package com.vinimanfrin.safeway.infra.exceptions;

public class TransactionValidationException extends RuntimeException{

    public TransactionValidationException(String message){
        super(message);
    }
}
