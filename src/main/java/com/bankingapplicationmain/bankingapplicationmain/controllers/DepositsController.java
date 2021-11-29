package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.services.DepositsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<?> createDeposit(@Valid @RequestBody Deposits deposit){
        return new ResponseEntity<>(depositsService.createDeposit(deposit),HttpStatus.CREATED);
    }

    //works
    @PutMapping("/deposits/{depositId}")
    public ResponseEntity<?> updateDeposits(@RequestBody Deposits deposits, @PathVariable Long depositId){
        return new ResponseEntity<>(depositsService.updateDeposit(deposits,depositId), HttpStatus.OK);
    }

    //works
    @DeleteMapping("/deposits/{depositId}")
    public ResponseEntity<?> deleteDeposits(@PathVariable Long depositId){
        return new ResponseEntity<>(depositsService.deleteDeposit(depositId), HttpStatus.OK);
    }



}
