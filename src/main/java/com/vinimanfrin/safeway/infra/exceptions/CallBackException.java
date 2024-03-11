package com.vinimanfrin.safeway.infra.exceptions;

public class CallBackException extends RuntimeException{

    public CallBackException(String message){
        super(message);
    }
}
