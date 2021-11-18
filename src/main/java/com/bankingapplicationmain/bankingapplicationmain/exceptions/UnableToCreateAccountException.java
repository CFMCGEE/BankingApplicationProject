package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnableToCreateAccountException extends RuntimeException {

    public UnableToCreateAccountException() {

    }

    public UnableToCreateAccountException(String message) {
        super(message);
    }

    public UnableToCreateAccountException(String message, Throwable cause) {
        super(message, cause);
    }

}