package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.AccountByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleAccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
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

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

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

    public ResponseEntity<?> deleteAccount(Long id) {
        logger.info("Account deleted");
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> createAccount(Account account) {
        logger.info("Account created");
        accountRepository.save(account);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();
        responseHeaders.setLocation(newAccountUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateAccount(Account account, Long accountId) {

        logger.info("Account updated");
        accountRepository.save(account);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
