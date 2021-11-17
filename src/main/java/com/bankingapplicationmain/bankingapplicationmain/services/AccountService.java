package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleAccountNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
            logger.info("All accounts successfully found.");
            return accountRepository.findAll();
        }

    }

    public Account getSingleAccount(Long accountID) {

        if (accountRepository.findById(accountID).isPresent()) {
            logger.info("One account successfully found.");
        }

        return accountRepository.findById(accountID).orElseThrow(()
                -> new SingleAccountNotFoundException());

    }
    
public ResponseEntity<?> deleteAccount(Long id) {
        logger.info("Account deleted");
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {
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
