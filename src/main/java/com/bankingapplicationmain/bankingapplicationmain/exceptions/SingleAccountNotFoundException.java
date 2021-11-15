package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SingleAccountNotFoundException extends RuntimeException {

    public SingleAccountNotFoundException() {

    }

    public SingleAccountNotFoundException(String message) {
        super(message);
    }

    public SingleAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
