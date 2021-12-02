package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnableToUpdateBillException extends RuntimeException {

    public UnableToUpdateBillException(){

    }

    public UnableToUpdateBillException(String message){
        super(message);
    }

    public UnableToUpdateBillException(String message, Throwable cause){
        super(message, cause);
    }
}
