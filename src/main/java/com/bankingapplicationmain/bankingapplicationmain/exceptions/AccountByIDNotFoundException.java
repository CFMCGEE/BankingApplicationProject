package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountByIDNotFoundException extends RuntimeException {

    public AccountByIDNotFoundException() {

    }

    public AccountByIDNotFoundException(String message) {
        super(message);
    }

    public AccountByIDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
