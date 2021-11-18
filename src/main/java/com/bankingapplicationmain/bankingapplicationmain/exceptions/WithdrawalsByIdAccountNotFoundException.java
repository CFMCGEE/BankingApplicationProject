package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WithdrawalsByIdAccountNotFoundException extends RuntimeException {

    public WithdrawalsByIdAccountNotFoundException() {

    }

    public WithdrawalsByIdAccountNotFoundException(String message) {
        super(message);
    }

    public WithdrawalsByIdAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
