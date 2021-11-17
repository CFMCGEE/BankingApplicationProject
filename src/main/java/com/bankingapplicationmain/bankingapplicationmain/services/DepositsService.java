package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.repositories.DepositsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositsService {

    @Autowired
    private DepositsRepository depositsRepository;

    public ResponseEntity<?> getDeposits(Long accountId) {
        return ResponseEntity.ok(depositsRepository.findAll());
    }

    public ResponseEntity<?> getDepositById(Long id) {
        return ResponseEntity.ok(depositsRepository.findById(id));
    }

    //we need a post method
    public void addDeposit(Deposits deposits){
        depositsRepository.save(deposits);
    }

    //a put method as well
    public void editDeposit(Long depositId, Deposits deposits){
        depositsRepository.save(deposits);
    }

    //delete method
    public void deleteDeposit(Long depositId){
        depositsRepository.delete(depositsRepository.getById(depositId));
    }




}
