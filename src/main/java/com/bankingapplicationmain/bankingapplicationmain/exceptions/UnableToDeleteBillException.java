package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnableToDeleteBillException extends RuntimeException {

    public UnableToDeleteBillException(){

    }

    public UnableToDeleteBillException(String message){
        super(message);
    }

    public UnableToDeleteBillException(String message, Throwable cause){
        super(message, cause);
    }


}
