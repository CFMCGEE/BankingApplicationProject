package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class AccountSuccessfullyFoundException extends RuntimeException{

    public AccountSuccessfullyFoundException() {

    }

    public AccountSuccessfullyFoundException(String message) {
        super(message);
    }

    public AccountSuccessfullyFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
