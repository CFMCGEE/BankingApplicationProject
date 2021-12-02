package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountPostSuccess;
import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountSuccessfulMethods;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleAccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import com.bankingapplicationmain.bankingapplicationmain.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    protected void verifyCustomer(Long customerId) throws AccountPutException {

        Customer customer = customerRepository.findById(customerId).orElse(null);

        if(customer == null) {
           throw new AccountPutException();
        }

    }

    public List<Account> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();

        if (accounts.isEmpty()) {
            throw new AccountNotFoundException();
        } else {
            logger.info("All accounts successfully found!");
            throw new AccountSuccessfullyFoundException();
        }

    }

    public Object getSingleAccount(Long accountID) {

        Account singleAccount = accountRepository.findById(accountID).orElseThrow(() -> new SingleAccountNotFoundException());

        logger.info("One account successfully found!");

        int successCode = HttpStatus.OK.value();

        SingleAccountSuccessfullyFound singleAccountSuccessfullyFound = new SingleAccountSuccessfullyFound();
        singleAccountSuccessfullyFound.setCode(successCode);
        singleAccountSuccessfullyFound.setMessage("Success!");
        singleAccountSuccessfullyFound.setData(singleAccount);

        return singleAccountSuccessfullyFound;

    }

    public Object getAllAccountsByCustomer(Long customerId) {

        try {
            logger.info("All customer accounts successfully found!");
            return new AccountByIDSuccessfullyFound(HttpStatus.OK.value(), "Success!", accountRepository.findAllByCustomerId(customerId));
        } catch (AccountByIDNotFoundException e) {
            throw new AccountByIDNotFoundException();
        }

    }

    public Object createAccount(Account account, long customerId) {

    try {
        logger.info("Account created!");
        return new AccountPostSuccess(HttpStatus.CREATED.value(), "Account Successfully Created!", accountRepository.save(account));
    } catch (AccountPostException e) {
        throw new AccountPostException();
    }

    }

    public Object updateAccount(Long accountId, Account account) {


        verifyCustomer(accountId);

        logger.info("Account updated!");
        accountRepository.save(account);

        return new AccountSuccessfulMethods(HttpStatus.OK.value(),"Customer Account Updated!");

    }

    public Object deleteAccount(Long id) {

        if (accountRepository.findById(id).isEmpty()) {
            throw new AccountDeleteException();
        }

        logger.info("Account deleted!");
        accountRepository.deleteById(id);

        return new AccountSuccessfulMethods(HttpStatus.ACCEPTED.value(), "Account successfully deleted!");

    }


}
