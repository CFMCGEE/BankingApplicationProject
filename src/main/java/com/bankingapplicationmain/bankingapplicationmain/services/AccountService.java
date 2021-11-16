package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.AccountNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleAccountNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            logger.info("All accounts successfully grabbed.");
            return accountRepository.findAll();
        }

    }

    public Account getSingleAccount(Long accountID) {

        if (accountRepository.findById(accountID).isPresent()) {
            logger.info("One account successfully grabbed.");
        }

        return accountRepository.findById(accountID).orElseThrow(() -> new SingleAccountNotFoundException());

    }

}
