package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WithdrawalsByAccountNotFound extends RuntimeException {

    public WithdrawalsByAccountNotFound() {

    }

    public WithdrawalsByAccountNotFound(String message) {
        super(message);
    }

    public WithdrawalsByAccountNotFound(String message, Throwable cause) {
        super(message, cause);
    }

}
