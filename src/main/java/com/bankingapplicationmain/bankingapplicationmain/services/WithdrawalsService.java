package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingapplicationmain.bankingapplicationmain.details.success.WithdrawalsByAccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.WithdrawalsByIdAccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;
import com.bankingapplicationmain.bankingapplicationmain.repositories.WithdrawalsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class WithdrawalsService {


    //Initialize logger
    private static final Logger logger = LoggerFactory.getLogger(WithdrawalsService.class);

    //Declare the withdrawalRepository
    @Autowired
    private WithdrawalsRepository withdrawalsRepository;

    @Autowired
    private AccountRepository accountRepository;


    //Get all withdrawals
    public WithdrawalsByAccountSuccessfullyFound getAllWithdrawalsByAccountID(Long accountId) {

            if (withdrawalsRepository.findWithdrawalsByAccountId(accountId).isEmpty()) {
                throw new WithdrawalsByAccountNotFoundException();
            }

            int successCode = HttpStatus.OK.value();

            WithdrawalsByAccountSuccessfullyFound withdrawalsByAccountSuccessfullyFound = new WithdrawalsByAccountSuccessfullyFound(successCode, withdrawalsRepository.findWithdrawalsByAccountId(accountId));

            logger.info("All withdrawals successfully found!");
            return withdrawalsByAccountSuccessfullyFound;

    }

    //Get withdrawals by id
    public WithdrawalsByIdAccountSuccessfullyFound getSingleWithdrawals(Long withdrawalsID) {

        Withdrawals singleWithdrawals = withdrawalsRepository.findById(withdrawalsID).orElseThrow(() -> new WithdrawalsByIdAccountNotFoundException());

        logger.info("One withdrawals successfully found!");

        int successCode = HttpStatus.OK.value();

        WithdrawalsByIdAccountSuccessfullyFound withdrawalsByIdAccountSuccessfullyFound = new WithdrawalsByIdAccountSuccessfullyFound(successCode, singleWithdrawals);

        return withdrawalsByIdAccountSuccessfullyFound;

    }

    //Create withdrawals
    public Withdrawals createWithdrawals(Withdrawals withdrawal) {

        Optional<Account> account = accountRepository.findById(withdrawal.getAccount().getId());

        withdrawal.setAccount(account.get());

        Withdrawals newWithdrawal = withdrawalsRepository.save(withdrawal);

        logger.info("Withdrawals created successfully");
        return newWithdrawal;

    }

    //Update withdrawals
    public void updateWithdrawals(Withdrawals withdrawals, Long withdrawalId) {
        withdrawalsRepository.save(withdrawals);
        logger.info("Withdrawals updated successfully");
    }

    //Delete withdrawals
    public void deleteWithdrawals(Long id) {
        withdrawalsRepository.deleteById(id);
        logger.info("Withdrawals deleted successfully");
    }
}
