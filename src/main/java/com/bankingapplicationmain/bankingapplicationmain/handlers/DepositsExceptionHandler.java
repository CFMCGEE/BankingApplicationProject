package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.error.NotFoundError;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepositsExceptionHandler extends DepositsNotFoundException {

    @ExceptionHandler(DepositsNotFoundException.class)
    public ResponseEntity<?> handleDepositsNotFoundException() {

        NotFoundError depositsError = new NotFoundError();
        depositsError.setCode(HttpStatus.NOT_FOUND.value());
        depositsError.setMessage("ERROR NO DEPOSITS FOUND");

        return new ResponseEntity<>(depositsError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DepositsNotFoundById.class)
    public ResponseEntity<?> handleDepositsNotFoundById() {

        NotFoundError depositsIdError = new NotFoundError();
        depositsIdError.setCode(HttpStatus.NOT_FOUND.value());
        depositsIdError.setMessage("ERROR NO DEPOSIT FOUND BY ID");

        return new ResponseEntity<>(depositsIdError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(SingleDepositNotFoundException.class)
    public ResponseEntity<?> handleSingleDepositNotFoundException() {

        NotFoundError singleDepositError = new NotFoundError();
        singleDepositError.setCode(HttpStatus.NOT_FOUND.value());
        singleDepositError.setMessage("ERROR SINGLE DEPOSIT NOT FOUND");

        return new ResponseEntity<>(singleDepositError, null, HttpStatus.NOT_FOUND);

    }


}
