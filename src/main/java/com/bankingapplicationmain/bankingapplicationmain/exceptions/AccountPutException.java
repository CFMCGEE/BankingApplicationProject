package com.bankingapplicationmain.bankingapplicationmain.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountPutException extends RuntimeException {
    public AccountPutException() {

    }

    public AccountPutException(String message) {
        super(message);
    }

    public AccountPutException(String message, Throwable cause) {
        super(message, cause);
    }

}

