package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepositDeleteException extends RuntimeException {

    public DepositDeleteException(){

    }

    public DepositDeleteException(String message){
        super(message);
    }
    public DepositDeleteException(String message, Throwable cause){
        super(message,cause);
    }

}
