package com.bankingapplicationmain.bankingapplicationmain.services;


import com.bankingapplicationmain.bankingapplicationmain.exceptions.DepositsNotFoundById;
import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.repositories.DepositsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepositsService {

    private static final Logger logger = LoggerFactory.getLogger(DepositsService.class);

    @Autowired
    private DepositsRepository depositsRepository;

    public Deposits getDepositById(Long id) {

        if(depositsRepository.findById(id).isEmpty()){
            logger.info("Deposit not found");
           throw new DepositsNotFoundById();
        }
        logger.info("Deposits successfully found");
        return depositsRepository.getById(id);
    }
    public List<Deposits> getDepositsByAccountId(Long id) {

        if(depositsRepository.findByAccountID(id).isEmpty()){
            logger.info("Deposits not found");
           throw new DepositsNotFoundById();
        }
        logger.info("Account Deposits successfully found");
        return depositsRepository.findByAccountID(id);

    }

    //we need a post method
    public void createDeposit(Deposits deposits){

        depositsRepository.save(deposits);
        logger.info("Deposit successfully completed");
    }

    //a put method as well

    public void editDeposit(Long depositId, Deposits deposits){
        deposits.setId(depositId);
        depositsRepository.save(deposits);
        logger.info("Deposit successfully edited");

    }
  
    public void updateDeposit(Long depositId, Deposits deposits){

        depositsRepository.save(deposits);
        logger.info("Deposit successfully Updated");
    }

    //delete method
    public void deleteDeposit(Long depositId){
        depositsRepository.delete(depositsRepository.getById(depositId));
        logger.info("Deposit successfully deleted");
    }

}
