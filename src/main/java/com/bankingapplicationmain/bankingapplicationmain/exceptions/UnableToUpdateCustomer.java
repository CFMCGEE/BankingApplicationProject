package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnableToUpdateCustomer extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnableToUpdateCustomer(String message) {
        super(message);
    }

    public UnableToUpdateCustomer(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToUpdateCustomer(Throwable cause) {
        super(cause);
    }

    public UnableToUpdateCustomer() {
    }
}
