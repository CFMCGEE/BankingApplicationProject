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
    private CustomerRepository customerRepository;


    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    protected void verifyCustomer(Long customerId) throws AccountPutException {

        Customer customer = customerRepository.findById(customerId).orElse(null);

        if(customer == null) {
           throw new AccountPutException();
        }

    }
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();

        if (accounts.isEmpty()) {
            throw new AccountNotFoundException();
        } else {
            logger.info("All accounts successfully found!");
            throw new AccountSuccessfullyFoundException();
        }

    }

    public ResponseEntity<Object> getSingleAccount(Long accountID) {

        Account singleAccount = accountRepository.findById(accountID).orElseThrow(() -> new SingleAccountNotFoundException());

        logger.info("One account successfully found!");

        int successCode = HttpStatus.OK.value();

        SingleAccountSuccessfullyFound singleAccountSuccessfullyFound = new SingleAccountSuccessfullyFound();
        singleAccountSuccessfullyFound.setCode(successCode);
        singleAccountSuccessfullyFound.setMessage("Success!");
        singleAccountSuccessfullyFound.setData(singleAccount);

        return new ResponseEntity<>(singleAccountSuccessfullyFound, HttpStatus.OK);

    }

    public ResponseEntity<Object> getAllAccountsByCustomer(Long accountID) {

        Iterable<Account> accountOfCustomersByID = accountRepository.findAllById(Collections.singleton(accountID));

        try {

            logger.info("All customer accounts successfully found!");

            int successCode = HttpStatus.OK.value();

            AccountByIDSuccessfullyFound accountByIDSuccessfullyFound = new AccountByIDSuccessfullyFound(successCode, "Success!", accountOfCustomersByID);

            return new ResponseEntity<>(accountByIDSuccessfullyFound, HttpStatus.OK);

        } catch (AccountByIDNotFoundException e) {
            throw new AccountByIDNotFoundException();
        }

    }

    public ResponseEntity<?> createAccount(Account account, long customerId) {

        if (customerRepository.findById(customerId).isEmpty()) {
            throw new AccountPostException();
        }

        logger.info("Account created");

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        responseHeaders.setLocation(newAccountUri);

        Customer customer = customerRepository.findById((long) account.getCustomer_id()).orElse(null);


        AccountPostSuccess accountPostSuccess = new AccountPostSuccess(HttpStatus.CREATED.value(), "Account Created", accountRepository.save(account));

        return new ResponseEntity<>(accountPostSuccess, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateAccount(Account account, Long accountId) {

        verifyCustomer(accountId);

        logger.info("Account updated");
        accountRepository.save(account);

        AccountSuccessfulMethods accountSuccessfulMethods = new AccountSuccessfulMethods(HttpStatus.OK.value(),"Customer Account Updated");


        return new ResponseEntity<>(accountSuccessfulMethods,HttpStatus.OK);

    }

    public ResponseEntity<?> deleteAccount(Long id) {

        if (accountRepository.findById(id).isEmpty()) {
            throw new AccountDeleteException();
        }

        logger.info("Account deleted");
        accountRepository.deleteById(id);

        AccountSuccessfulMethods accountSuccessfulMethods = new AccountSuccessfulMethods(HttpStatus.ACCEPTED.value(),"Account successfully deleted");

        return new ResponseEntity<>(accountSuccessfulMethods, HttpStatus.ACCEPTED);

    }


}
