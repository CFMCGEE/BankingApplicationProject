package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DepositsNotFoundException{

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepositNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DepositNotFoundException(String message) {
        super(message);
    }

    public DepositNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepositNotFoundException() {
    }
}
}

