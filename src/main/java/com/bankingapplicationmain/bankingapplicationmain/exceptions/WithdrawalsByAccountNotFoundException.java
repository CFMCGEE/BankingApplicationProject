package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WithdrawalsByAccountNotFoundException extends RuntimeException {

    public WithdrawalsByAccountNotFoundException() {

    }

    public WithdrawalsByAccountNotFoundException(String message) {
        super(message);
    }

    public WithdrawalsByAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
