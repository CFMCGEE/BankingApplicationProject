package com.bankingapplicationmain.bankingapplicationmain.services;


import com.bankingapplicationmain.bankingapplicationmain.details.success.DepositSuccessfullyCreated;
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
    public List<Deposits> getDepositsByAccountId(Long id) {

        if(depositsRepository.findAllById(Collections.singleton(id)).isEmpty()){
            logger.info("Deposits not found");
            throw new DepositsNotFoundById();
        }
        logger.info("Account Deposits successfully found");
        return depositsRepository.findAllById(Collections.singleton(id));

    }

    //we need a post method
    public ResponseEntity<?>createDeposit(Deposits deposits){

        try {

            depositsRepository.save(deposits);
            logger.info("Deposit successfully completed");
            int successCode = HttpStatus.CREATED.value();

            HttpHeaders responseHeaders = new HttpHeaders();
            URI newDepositUri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(deposits.getId())
                    .toUri();
            responseHeaders.setLocation(newDepositUri);


            DepositSuccessfullyCreated depositSuccessfullyCreated = new DepositSuccessfullyCreated(successCode, "Deposit Successfully Created", depositsRepository.save(deposits));


            return new ResponseEntity<>(depositSuccessfullyCreated, responseHeaders, HttpStatus.CREATED);

        }catch (UnableToCreateDepositException e){
            throw new UnableToCreateDepositException();
        }
    }

    //a put method as well
  
    public ResponseEntity<?> updateDeposit(Long depositId, Deposits deposits){
        deposits.setId(depositId);
        verifyDeposit(depositId);

        depositsRepository.save(deposits);
        logger.info("Deposit successfully Updated");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete method
    public ResponseEntity<?> deleteDeposit(Long depositId){
        logger.info("Deposit successfully deleted");
        depositsRepository.delete(depositsRepository.getById(depositId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
