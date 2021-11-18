package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BillByIDNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BillByIDNotFoundException() {
    }

    public BillByIDNotFoundException(String message) {
        super(message);
    }

    public BillByIDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
