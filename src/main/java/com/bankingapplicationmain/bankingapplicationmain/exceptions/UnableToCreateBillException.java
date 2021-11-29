package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnableToCreateBillException extends RuntimeException {


    public UnableToCreateBillException(){

    }

    public UnableToCreateBillException(String message){
        super(message);

    }

    public UnableToCreateBillException(String message, Throwable cause){
        super(message, cause);
    }
}

