package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.services.DepositsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class DepositsController {

    @Autowired
    private DepositsService depositsService;


    @RequestMapping(value="/accounts/{accountId}/deposits",method = RequestMethod.GET)
    public ResponseEntity<?> getDepositsByAccountId(@PathVariable Long accountId) {
        return ResponseEntity.ok(depositsService.getDepositsByAccountId(accountId));
    }


    @GetMapping("/deposits/{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        return ResponseEntity.ok(depositsService.getDepositById(depositId));
      
    }


    @PostMapping("/accounts/{accountId}/deposits")
    public void addDeposits(@RequestBody Deposits deposits){
        depositsService.createDeposit(deposits);

    }

    @PutMapping("/deposits/{depositId}")
    public void updateDeposits(@RequestBody Deposits deposits, @PathVariable Long depositId){
//         depositsService.editDeposit(depositId,deposits);
        depositsService.updateDeposit(depositId,deposits);

    }

    @DeleteMapping("/deposits/{depositId}")
    public void deleteDeposits(@PathVariable Long depositId){
        depositsService.deleteDeposit(depositId);
    }



}
