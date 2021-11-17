package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class CustomerAccountSuccessfullyCreatedException extends RuntimeException{

    public CustomerAccountSuccessfullyCreatedException() {

    }

    public CustomerAccountSuccessfullyCreatedException(String message) {
        super(message);
    }

    public CustomerAccountSuccessfullyCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

}
