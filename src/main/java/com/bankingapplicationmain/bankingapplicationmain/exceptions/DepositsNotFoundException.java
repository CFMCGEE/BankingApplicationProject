package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepositsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;



    public DepositsNotFoundException(String message) {
        super(message);
    }

    public DepositsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepositsNotFoundException() {
    }
}


