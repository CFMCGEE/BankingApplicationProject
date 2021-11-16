package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.services.DepositsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class DepositsController {

    @Autowired
    private DepositsService depositsService;


    @RequestMapping("/accounts/{accountId}/deposits")
    public ResponseEntity<?> getDeposits(@PathVariable Long accountId) {
        return depositsService.getDeposits(accountId);
    }


}
