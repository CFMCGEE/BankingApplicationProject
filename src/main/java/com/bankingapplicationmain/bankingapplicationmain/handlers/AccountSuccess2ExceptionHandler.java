package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleAccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountByIDSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleAccountSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class AccountSuccess2ExceptionHandler extends SingleAccountSuccessfullyFound {

    @Autowired
    private AccountRepository accountRepository;

    @ExceptionHandler(SingleAccountSuccessfullyFoundException.class)
    public ResponseEntity<?> handleSingleAccountSuccessfullyFoundException(Long accountID) {

        int successCode = HttpStatus.OK.value();

        Account account = accountRepository.findById(accountID).orElse(null);

        SingleAccountSuccessfullyFound singleAccountSuccessfullyFound = new SingleAccountSuccessfullyFound();
        singleAccountSuccessfullyFound.setCode(successCode);
        singleAccountSuccessfullyFound.setMessage("Success!");
        singleAccountSuccessfullyFound.setData(account);

        return new ResponseEntity<>(singleAccountSuccessfullyFound, null, HttpStatus.OK);

    }

//    @ExceptionHandler(CustomerAccountSuccessfullyCreatedException.class)
//    public ResponseEntity<?> handleCustomerAccountSuccessfullyCreatedException(Long accountID) {
//
//        int successCode = HttpStatus.CREATED.value();
//
//        Caccount = accountRepository.findById(accountID).orElse(null);
//
//        CustomerAccountSuccessfullyCreated customerAccountSuccessfullyCreated = new CustomerAccountSuccessfullyCreated();
//        customerAccountSuccessfullyCreated.setCode(successCode);
//        customerAccountSuccessfullyCreated.setMessage("Account created!");
//        customerAccountSuccessfullyCreated.setData(account);
//
//        return new ResponseEntity<>(customerAccountSuccessfullyCreated, null, HttpStatus.CREATED);
//
//    }

}
