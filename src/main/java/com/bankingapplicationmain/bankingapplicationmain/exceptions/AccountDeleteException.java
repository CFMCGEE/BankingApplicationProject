package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AccountDeleteException extends RuntimeException{
    public AccountDeleteException() {
    }

    public AccountDeleteException(String message) {
        super(message);
    }

    public AccountDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

}
