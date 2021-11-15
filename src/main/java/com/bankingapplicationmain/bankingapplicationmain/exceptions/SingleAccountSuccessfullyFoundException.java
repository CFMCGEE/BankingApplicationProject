package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class SingleAccountSuccessfullyFoundException extends RuntimeException{

    public SingleAccountSuccessfullyFoundException() {

    }

    public SingleAccountSuccessfullyFoundException(String message) {
        super(message);
    }

    public SingleAccountSuccessfullyFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
