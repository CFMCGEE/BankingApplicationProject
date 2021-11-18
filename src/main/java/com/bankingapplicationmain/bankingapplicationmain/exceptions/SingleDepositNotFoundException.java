package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SingleDepositNotFoundException extends RuntimeException {

    public SingleDepositNotFoundException(){

    }

    public SingleDepositNotFoundException(String message){
        super(message);
    }
    
    public SingleDepositNotFoundException(Throwable cause) {
        super(cause);
    }

    public SingleDepositNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }



}
