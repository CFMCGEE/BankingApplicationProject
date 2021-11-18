package com.bankingapplicationmain.bankingapplicationmain.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalsService {
    //Initialize logger
    private static final Logger logger = LoggerFactory.getLogger(WithdrawalsService.class);

    //Declare the withdrawalRepository
    @Autowired
    private WithdrawalsRepository withdrawalsRepository;

    //Get all withdrawals

    //Get withdrawals by id

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