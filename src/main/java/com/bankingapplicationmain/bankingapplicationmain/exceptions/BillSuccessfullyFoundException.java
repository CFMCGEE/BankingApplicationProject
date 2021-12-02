package com.bankingapplicationmain.bankingapplicationmain.exceptions;

public class BillSuccessfullyFoundException extends RuntimeException{
    public BillSuccessfullyFoundException(){

    }

    public BillSuccessfullyFoundException(String message){
        super(message);
    }


    public BillSuccessfullyFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
