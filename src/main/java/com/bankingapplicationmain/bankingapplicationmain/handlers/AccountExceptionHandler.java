package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.error.NotFoundError;
//import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountByIDNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler extends AccountNotFoundException {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value(); //404

        NotFoundError accountError = new NotFoundError();
        accountError.setCode(errorCode);
        accountError.setMessage("ERROR WHILE TRYING TO FETCH ACCOUNTS"); //error fetching accounts

        return new ResponseEntity<>(accountError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(SingleAccountNotFoundException.class)
    public ResponseEntity<?> handleSingleAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError accountError = new NotFoundError();
        accountError.setCode(errorCode);
        accountError.setMessage("ERROR WHILE TRYING TO FETCH ACCOUNT");

        return new ResponseEntity<>(accountError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AccountByIDNotFoundException.class)
    public ResponseEntity<?> handleAccountByIDNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError accountError = new NotFoundError();
        accountError.setCode(errorCode);
        accountError.setMessage("ERROR WHILE TRYING TO FETCH CUSTOMER'S ACCOUNTS");

        return new ResponseEntity<>(accountError, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnableToCreateAccountException.class)
    public ResponseEntity<?> handleUnableToCreateAccountException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError accountError = new NotFoundError();
        accountError.setCode(errorCode);
        accountError.setMessage("ERROR WHILE TRYING TO FETCH CUSTOMERS ACCOUNT");

        return new ResponseEntity<>(accountError, null, HttpStatus.NOT_FOUND);

    }
    
    @ExceptionHandler(AccountDeleteException.class)
    public ResponseEntity<?> handleAccountDeleteException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError accountError = new NotFoundError();
        accountError.setCode(errorCode);
        accountError.setMessage("Account does not exist");

        return new ResponseEntity<>(accountError, null, HttpStatus.NOT_FOUND);
    }

}
