package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class SingleCustomerSuccessfullyFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SingleCustomerSuccessfullyFoundException() {
    }

    public SingleCustomerSuccessfullyFoundException(String message) {
        super(message);
    }

    public SingleCustomerSuccessfullyFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SingleCustomerSuccessfullyFoundException(Throwable cause) {
        super(cause);
    }

}
