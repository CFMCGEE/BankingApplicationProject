package com.bankingapplicationmain.bankingapplicationmain.handlers;


import com.bankingapplicationmain.bankingapplicationmain.details.error.NotFoundError;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerNotFoundExceptionHandler extends CustomerNotFoundException {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException() {

        NotFoundError customerError = new NotFoundError();
        customerError.setCode(HttpStatus.NOT_FOUND.value());
        customerError.setMessage("ERROR FETCHING CUSTOMERS");

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(SingleCustomerNotFoundException.class)
    public ResponseEntity<?> handleSingleCustomerNotFoundException() {

        NotFoundError customerError = new NotFoundError();
        customerError.setCode(HttpStatus.NOT_FOUND.value());
        customerError.setMessage("ERROR FETCHING CUSTOMER");

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CustomerNotFoundById.class)
    public ResponseEntity<?> handleSingleCustomerByIDNotFoundException() {

        NotFoundError customerError = new NotFoundError();
        customerError.setCode(HttpStatus.NOT_FOUND.value());
        customerError.setMessage("ERROR FETCHING CUSTOMER");

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UnableToUpdateCustomer.class)
    public ResponseEntity<?> handleUnableToCreateAccountException() {

        NotFoundError customerError = new NotFoundError();
        customerError.setCode(HttpStatus.NOT_FOUND.value());
        customerError.setMessage("ERROR CREATING CUSTOMER");

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }



}