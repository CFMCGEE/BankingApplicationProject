package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SingleDepositNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SingleDepositNotFoundException(){

    }

    public SingleDepositNotFoundException(String message){
        super(message);
    }

    public SingleDepositNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SingleDepositNotFoundException(Throwable cause) {
        super(cause);
    }

}
