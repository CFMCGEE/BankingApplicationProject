package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnableToCreateDepositException extends RuntimeException{

    public UnableToCreateDepositException(){

    }
    public UnableToCreateDepositException(String message) {
        super(message);
    }

    public UnableToCreateDepositException(String message, Throwable cause) {
        super(message, cause);
    }

}
