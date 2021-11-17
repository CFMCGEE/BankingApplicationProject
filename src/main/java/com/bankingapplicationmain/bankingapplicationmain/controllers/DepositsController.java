package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.services.DepositsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class DepositsController {

    @Autowired
    private DepositsService depositsService;


    @RequestMapping(value="/accounts/{accountId}/deposits",method = RequestMethod.GET)
    public ResponseEntity<?> getDeposits(@PathVariable Long accountId) {
        return depositsService.getDeposits(accountId);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDeposit(@PathVariable Long depositId) {
        return depositsService.getDeposits(depositId);
    }

    @RequestMapping(value="/accounts/{accountId}/deposits",method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@PathVariable Long accountId) {
        return depositsService.createDeposit(accountId);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@PathVariable Long depositId) {
        return depositsService.updateDeposit(depositId);
    }

    @RequestMapping(value="/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId) {
        return depositsService.deleteDeposit(depositId);
    }


}
