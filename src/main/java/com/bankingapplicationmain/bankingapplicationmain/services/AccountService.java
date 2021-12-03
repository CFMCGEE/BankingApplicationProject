package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.*;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import com.bankingapplicationmain.bankingapplicationmain.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//            throw new AccountSuccessfullyFoundException();
            return accounts;
        }

    }

    public Object getSingleAccount(Long id) {

        Account singleAccount = accountRepository.findById(id).orElseThrow(() -> new SingleAccountNotFoundException());

        logger.info("One account successfully found!");

        int successCode = HttpStatus.OK.value();

        SingleAccountSuccessfullyFound singleAccountSuccessfullyFound = new SingleAccountSuccessfullyFound();
        singleAccountSuccessfullyFound.setCode(successCode);
        singleAccountSuccessfullyFound.setMessage("Success!");
        singleAccountSuccessfullyFound.setData(singleAccount);

        return singleAccountSuccessfullyFound;

    }

    public Object getAllAccountsByCustomer(Long customerId) {

            if (accountRepository.findAllByCustomerId(customerId).isEmpty()) {
                throw new AccountByIDNotFoundException();
            }

            logger.info("All customer accounts successfully found!");
            return new AccountByIDSuccessfullyFound(HttpStatus.OK.value(), "Success!", accountRepository.findAllByCustomerId(customerId));

    }

//    public Object createAccount(Account account, long customerId) {
//
//    try {
//        logger.info("Account created!");
//        return accountRepository.save(account);//new AccountPostSuccess(HttpStatus.CREATED.value(), "Account Successfully Created!", accountRepository.save(account));
//    } catch (AccountPostException e) {
//        throw new AccountPostException();
//    }
//
//    }

    public Object createAccount(Account account)  {

        Optional<Customer> customer = customerRepository.findById(account.getCustomer().getId());

        account.setCustomer(customer.get());

        Account newAccount = accountRepository.save(account);

        try {
            logger.info("Account created!");
            return newAccount; //new AccountPostSuccess(HttpStatus.CREATED.value(), "Account Successfully Created!", );
        } catch (AccountPostException e) {
            throw new AccountPostException();
        }

    }

    public Object updateAccount(Long id, Account account) {

        verifyCustomer(id);

        Customer customer = customerRepository.findById(account.getCustomer().getId()).orElse(null);

        Account updateAccount = accountRepository.findById(id).get();
        if (accountRepository.findById(id).isEmpty()) {
            throw new UnableToUpdateCustomer();
        }

        updateAccount.setType(account.getType());
        updateAccount.setNickname(account.getNickname());
        updateAccount.setRewards(account.getRewards());
        updateAccount.setBalance(account.getBalance());
        updateAccount.setCustomer(customer);

        logger.info("Account updated!");
        accountRepository.save(updateAccount);

        //new AccountSuccessfulMethods(HttpStatus.OK.value(),"Customer Account Updated!");
        return updateAccount;

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
