package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.error.NotFoundError;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.CustomerNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleCustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerNotFoundExceptionHandler extends CustomerNotFoundException {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value(); //404

        NotFoundError customerError = new NotFoundError();
        customerError.setCode(errorCode);
        customerError.setMessage("ERROR FETCHING CUSTOMERS"); //error fetching accounts

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(SingleCustomerNotFoundException.class)
    public ResponseEntity<?> handleSingleAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError customerError = new NotFoundError();
        customerError.setCode(errorCode);
        customerError.setMessage("ERROR FETCHING CUSTOMER");

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }

}