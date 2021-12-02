package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BillByAccountIDNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BillByAccountIDNotFoundException() {
    }

    public BillByAccountIDNotFoundException(String message) {
        super(message);
    }

    public BillByAccountIDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
