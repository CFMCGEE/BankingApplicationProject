package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.error.NotFoundError;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleBillNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class BillNotFoundExceptionHandler {
    @ExceptionHandler(SingleBillNotFoundException.class)
    public ResponseEntity<?> handleBillNotFoundException(){
        int errorCode = HttpStatus.NOT_FOUND.value();


        NotFoundError billError = new NotFoundError();
        billError.setCode(errorCode);
        billError.setMessage("error fetching bills");


        return new ResponseEntity<>(billError,null, HttpStatus.NOT_FOUND);
    }
}
