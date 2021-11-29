package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.error.NotFoundError;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BillExceptionHandler extends BillNotFoundException {

    @ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<?> handleBillByAccountIDNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError billError = new NotFoundError();
        billError.setCode(errorCode);
        billError.setMessage("ERROR WHILE TRYING TO FETCH BILL(S) AT THIS ACCOUNT ID");

        return new ResponseEntity<>(billError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(SingleBillNotFoundException.class)
    public ResponseEntity<?> handleSingleBillNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError billError = new NotFoundError();
        billError.setCode(errorCode);
        billError.setMessage("ERROR WHILE TRYING TO FETCH A SINGLE BILL");

        return new ResponseEntity<>(billError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BillByIDNotFoundException.class)
    public ResponseEntity<?> handleBillByCustomerIDNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError billError = new NotFoundError();
        billError.setCode(errorCode);
        billError.setMessage("ERROR WHILE TRYING TO FETCH CUSTOMER BILL(S)");

        return new ResponseEntity<>(billError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UnableToCreateBillException.class)
    public ResponseEntity<?> handleCreatingBillException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError billError = new NotFoundError();
        billError.setCode(errorCode);
        billError.setMessage("ERROR TRYING TO CREATE A BILL");

        return new ResponseEntity<>(billError, null, HttpStatus.NOT_FOUND);

    }


}
