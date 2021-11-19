package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnableToCreateCustomer extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnableToCreateCustomer() {
    }

    public UnableToCreateCustomer(String message) {
        super(message);
    }

    public UnableToCreateCustomer(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToCreateCustomer(Throwable cause) {
        super(cause);
    }



}
