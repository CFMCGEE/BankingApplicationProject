package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class AccountByIDSuccessfullyFoundException extends RuntimeException {

    public AccountByIDSuccessfullyFoundException() {

    }

    public AccountByIDSuccessfullyFoundException(String message) {
        super(message);
    }

    public AccountByIDSuccessfullyFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
