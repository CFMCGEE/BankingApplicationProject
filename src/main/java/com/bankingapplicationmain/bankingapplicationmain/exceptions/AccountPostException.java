package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountPostException extends RuntimeException{
    public AccountPostException() {

    }

    public AccountPostException(String message) {
        super(message);
    }

    public AccountPostException(String message, Throwable cause) {
        super(message, cause);
    }
}
