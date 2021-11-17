package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class AccountSuccessExceptionHandler extends AccountSuccessfullyFound {

    @Autowired
    private AccountRepository accountRepository;

    @ExceptionHandler(AccountSuccessfullyFoundException.class)
    public ResponseEntity<?> handleAccountSuccessfullyFoundException() {

        int successCode = HttpStatus.OK.value(); //200

        List<Account> accountList = accountRepository.findAll();

        AccountSuccessfullyFound accountSuccessfullyFound = new AccountSuccessfullyFound(successCode, "Success!", accountList); // Success

        return new ResponseEntity<>(accountSuccessfullyFound, null, HttpStatus.OK);

    }

}
