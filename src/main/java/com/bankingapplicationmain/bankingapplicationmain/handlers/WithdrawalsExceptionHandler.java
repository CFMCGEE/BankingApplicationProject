package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.error.NotFoundError;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.WithdrawalsByAccountNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.WithdrawalsByIdAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WithdrawalsExceptionHandler {

    @ExceptionHandler(WithdrawalsByAccountNotFoundException.class)
    public ResponseEntity<?> handleWithdrawalsByAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError error = new NotFoundError();
        error.setCode(errorCode);
        error.setMessage("ERROR WHILE TRYING TO FETCH ALL WITHDRAWALS");

        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(WithdrawalsByIdAccountNotFoundException.class)
    public ResponseEntity<?> handleWithdrawalsByIdAccountNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError error = new NotFoundError();
        error.setCode(errorCode);
        error.setMessage("ERROR WHILE TRYING TO FETCH WITHDRAWALS");

        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);

    }

}
