package com.bankingapplicationmain.bankingapplicationmain.services;

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

@Service
public class gitWithdrawalsService {


    //Initialize logger
    private static final Logger logger = LoggerFactory.getLogger(WithdrawalsService.class);

    //Declare the withdrawalRepository
    @Autowired
    private WithdrawalsRepository withdrawalsRepository;

    //Get all withdrawals
    public ResponseEntity<Object> getAllWithdrawals() {

        List<Withdrawals> withdrawals = withdrawalsRepository.findAll();

        try {

            logger.info("All withdrawals successfully found!");

            int successCode = HttpStatus.OK.value();

            WithdrawalsByAccountSuccessfullyFound withdrawalsByAccountSuccessfullyFound = new WithdrawalsByAccountSuccessfullyFound(successCode, withdrawals);

            return new ResponseEntity<>(withdrawalsByAccountSuccessfullyFound, HttpStatus.OK);

        } catch (WithdrawalsByAccountNotFoundException e) {
            throw new WithdrawalsByAccountNotFoundException();
        }

    }

    //Get withdrawals by id
    public ResponseEntity<Object> getSingleWithdrawals(Long withdrawalsID) {

        Withdrawals singleWithdrawals = withdrawalsRepository.findById(withdrawalsID).orElseThrow(() -> new WithdrawalsByIdAccountNotFoundException());

        logger.info("One withdrawals successfully found!");

        int successCode = HttpStatus.OK.value();

        WithdrawalsByIdAccountSuccessfullyFound withdrawalsByIdAccountSuccessfullyFound = new WithdrawalsByIdAccountSuccessfullyFound(successCode, singleWithdrawals);

        return new ResponseEntity<>(withdrawalsByIdAccountSuccessfullyFound, HttpStatus.OK);

    }

    //Create withdrawals
    public void createWithdrawals(Withdrawals withdrawals) {
        withdrawalsRepository.save(withdrawals);
        logger.info("Withdrawals created successfully");
    }

    //Update withdrawals
    public void updateWithdrawals(Long withdrawalId, Withdrawals withdrawals) {
        withdrawalsRepository.save(withdrawals);
        logger.info("Withdrawals updated successfully");
    }

    //Delete withdrawals
    public void deleteWithdrawals(Long withdrawalId) {
        withdrawalsRepository.deleteById(withdrawalId);
        logger.info("Withdrawals deleted successfully");
    }
}
