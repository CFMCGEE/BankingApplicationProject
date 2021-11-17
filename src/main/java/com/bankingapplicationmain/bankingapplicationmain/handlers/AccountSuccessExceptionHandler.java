package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.CustomerAccountSuccessfullyCreated;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleAccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountByIDSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.CustomerAccountSuccessfullyCreatedException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleAccountSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class AccountSuccessExceptionHandler extends AccountSuccessfullyFound {

    @Autowired
    private AccountRepository accountRepository;

    @ExceptionHandler(AccountSuccessfullyFoundException.class)
    public ResponseEntity<?> handleAccountSuccessfullyFoundException() {

        int successCode = HttpStatus.OK.value(); //200

        List<Account> accountList = accountRepository.findAll();

        AccountSuccessfullyFound accountSuccessfullyFound = new AccountSuccessfullyFound();
        accountSuccessfullyFound.setCode(successCode);
        accountSuccessfullyFound.setMessage("Success!"); // Success
        accountSuccessfullyFound.setData(accountList);

        return new ResponseEntity<>(accountSuccessfullyFound, null, HttpStatus.OK);

    }


    @ExceptionHandler(AccountByIDSuccessfullyFoundException.class)
    public ResponseEntity<?> handleAccountByIDSuccessfullyFoundException(long accountID) {

        int successCode = HttpStatus.OK.value();

        List<Account> account = accountRepository.findAllById(Collections.singleton(accountID));

        AccountByIDSuccessfullyFound accountByIDSuccessfullyFound = new AccountByIDSuccessfullyFound();
        accountByIDSuccessfullyFound.setCode(successCode);
        accountByIDSuccessfullyFound.setMessage("Success!");
        accountByIDSuccessfullyFound.setData(account);

        return new ResponseEntity<>(accountByIDSuccessfullyFound, null, HttpStatus.OK);

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
