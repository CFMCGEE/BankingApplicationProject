package com.bankingapplicationmain.bankingapplicationmain.exceptions;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;

public class SingleBillSuccessfullyFoundException extends RuntimeException{



    public SingleBillSuccessfullyFoundException(String message){
        super(message);

    }

    public SingleBillSuccessfullyFoundException(String message, Throwable cause){
        super(message, cause);
    }


}
