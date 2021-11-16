package com.bankingapplicationmain.bankingapplicationmain.services;

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


}
