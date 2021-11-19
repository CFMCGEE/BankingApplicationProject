package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.services.DepositsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposits")
public class DepositsController {

    @Autowired
    private DepositsService depositsService;

    //works
    @GetMapping("/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        return ResponseEntity.ok(depositsService.getDepositById(depositId));

    }

    //works
    @RequestMapping(value="/accounts/{accountId}/deposits",method = RequestMethod.GET)
    public ResponseEntity<?> getDepositsByAccountId(@PathVariable Long accountId) {
        return ResponseEntity.ok(depositsService.getDepositsByAccountId(accountId));
    }

    //works
    @PostMapping("/deposits")
    public ResponseEntity<?> createDeposit(@RequestBody Deposits deposit){
        return depositsService.createDeposit(deposit);
    }

    //works
    @PutMapping("/deposits/{depositId}")
    public void updateDeposits(@RequestBody Deposits deposits, @PathVariable Long depositId){
        depositsService.updateDeposit(depositId,deposits);
    }

    //works
    @DeleteMapping("/deposits/{depositId}")
    public void deleteDeposits(@PathVariable Long depositId){
        depositsService.deleteDeposit(depositId);
    }



}
