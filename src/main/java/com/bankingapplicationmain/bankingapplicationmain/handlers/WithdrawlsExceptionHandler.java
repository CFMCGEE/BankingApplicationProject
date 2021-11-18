package com.bankingapplicationmain.bankingapplicationmain.handlers;


import com.bankingapplicationmain.bankingapplicationmain.exceptions.WithdrawlsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class WithdrawlsExceptionHandler {
    @ExceptionHandler(WithdrawlsNotFoundException.class)
    public ResponseEntity<?> handleWithdrawalsNotFoundException() {

        int errorCode = HttpStatus.NOT_FOUND.value();

        NotFoundError error = new NotFoundError();
        error.setCode(errorCode);
        error.setMessage("ERROR WHILE TRYING TO FETCH ALL WITHDRAWALS");

        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);

    }
}
