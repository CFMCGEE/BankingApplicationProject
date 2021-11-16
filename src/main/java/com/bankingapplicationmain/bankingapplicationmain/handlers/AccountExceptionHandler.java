package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.error.AccountIssueError;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler extends AccountNotFoundException {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> handleAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value(); //404

        AccountIssueError customerError = new AccountIssueError();
        customerError.setCode(errorCode);
        customerError.setMessage("ERROR WHILE TRYING TO FETCH ACCOUNTS"); //error fetching accounts

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(SingleAccountNotFoundException.class)
    public ResponseEntity<?> handleSingleAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        AccountIssueError customerError = new AccountIssueError();
        customerError.setCode(errorCode);
        customerError.setMessage("ERROR FETCHING ACCOUNTS");

        return new ResponseEntity<>(customerError, null, HttpStatus.NOT_FOUND);

    }

}
