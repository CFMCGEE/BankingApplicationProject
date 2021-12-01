package com.bankingapplicationmain.bankingapplicationmain.services;


import com.bankingapplicationmain.bankingapplicationmain.details.success.DepositDeleteSuccessFull;
import com.bankingapplicationmain.bankingapplicationmain.details.success.DepositSuccessfullyCreated;
import com.bankingapplicationmain.bankingapplicationmain.details.success.DepositSuccessfullyUpdated;
import com.bankingapplicationmain.bankingapplicationmain.details.success.DepositsByIdSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.DepositDeleteException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.DepositsNotFoundById;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.DepositsNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.UnableToCreateDepositException;
import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.repositories.DepositsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.net.URI;
import java.util.Optional;


@Service
public class DepositsService {

    private static final Logger logger = LoggerFactory.getLogger(DepositsService.class);

    @Autowired
    private DepositsRepository depositsRepository;

    //adding method to verify deposit
    protected void verifyDeposit(Long depositId) throws DepositsNotFoundException {
        Optional<Deposits> deposits = depositsRepository.findById(depositId);
        if(deposits.isEmpty()) {
            throw new DepositsNotFoundException();
        }
    }

    public Deposits getDepositById(Long id) {
        Deposits deposit = depositsRepository.findById(id).orElseThrow(()->
        {
            logger.info("Deposit not found");
            throw new DepositsNotFoundById();
        });
        logger.info("Deposits successfully found");
        return depositsRepository.getById(id);
    }
    public DepositsByIdSuccessfullyFound getDepositsByAccountId(Long accountId) {

        return new DepositsByIdSuccessfullyFound(HttpStatus.OK.value(),
                " Successfully Found Account " + accountId + " Deposits", depositsRepository.findDepositsByAccountId(accountId));

    }

    //we need a post method
    public DepositSuccessfullyCreated createDeposit(Long accountId ,Deposits deposits){

        try {

            logger.info("Deposit successfully completed");
            int successCode = HttpStatus.CREATED.value();

            DepositSuccessfullyCreated depositSuccessfullyCreated = new DepositSuccessfullyCreated(successCode, "Deposit Successfully Created", depositsRepository.save(deposits));


            return depositSuccessfullyCreated;

        }catch (UnableToCreateDepositException e){
            throw new UnableToCreateDepositException();
        }
    }

    //a put method as well
    public DepositSuccessfullyUpdated updateDeposit(Deposits deposits,Long depositId){
       if(depositsRepository.findById(depositId).isEmpty()){
           logger.info("Deposit Not found");
           throw new DepositsNotFoundException();
       }
      
       logger.info("Deposit Successfully Updated...");
        DepositSuccessfullyUpdated depositSuccessfullyUpdated = new DepositSuccessfullyUpdated(HttpStatus.OK.value(),
                "Deposit Successfully Updated",
                depositsRepository.save(deposits));
        return depositSuccessfullyUpdated;
    }

    //delete method
    public DepositDeleteSuccessFull deleteDeposit(Long depositId){

        if (depositsRepository.findById(depositId).isEmpty()){
            throw new DepositDeleteException();
        }

        logger.info("Deposit Deleted");
        depositsRepository.deleteById(depositId);

        DepositDeleteSuccessFull depositDeleteSuccessFull = new DepositDeleteSuccessFull(HttpStatus.OK.value(), "Deposit successfully deleted");
        return depositDeleteSuccessFull;

    }

}
