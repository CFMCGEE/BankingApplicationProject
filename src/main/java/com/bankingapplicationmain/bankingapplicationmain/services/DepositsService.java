package com.bankingapplicationmain.bankingapplicationmain.services;


import com.bankingapplicationmain.bankingapplicationmain.exceptions.CustomerNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.DepositsNotFoundById;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.DepositsNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
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

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
public class DepositsService {

    private static final Logger logger = LoggerFactory.getLogger(DepositsService.class);

    @Autowired
    private DepositsRepository depositsRepository;

    //adding method to verify deposit
    protected void verifyDeposit(Long depositId) throws CustomerNotFoundException {
        Optional<Deposits> deposits = depositsRepository.findById(depositId);
        if(deposits.isEmpty()) {
            throw new DepositsNotFoundException();
        }
    }

    public ResponseEntity<?> getDeposits(Long accountId) {
        return ResponseEntity.ok(depositsRepository.findAll());
    }

    public ResponseEntity<?> getDepositById(Long id) {
        if(depositsRepository.findById(id).isEmpty()){
            logger.info("Deposit not found");
           throw new DepositsNotFoundById();
        }
        return ResponseEntity.ok(depositsRepository.findById(id));
    }

    //we need a post method
    public ResponseEntity<?>createDeposit(Deposits deposits){

        depositsRepository.save(deposits);
        logger.info("Deposit successfully completed");

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newDepositUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deposits.getId())
                .toUri();
        responseHeaders.setLocation(newDepositUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    //a put method as well
  
    public ResponseEntity<?> updateDeposit(Long depositId, Deposits deposits){
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
