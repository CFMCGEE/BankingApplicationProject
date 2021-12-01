package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.details.success.DepositSuccessfullyCreated;
import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import com.bankingapplicationmain.bankingapplicationmain.services.DepositsService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/deposits")
public class DepositsController {

    @Autowired
    private DepositsService depositsService;

    //works
    @GetMapping("{depositId}")
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
        return ResponseEntity.ok(depositsService.getDepositById(depositId));

    }

    //works
    @GetMapping("/accounts/{accountId}/deposits")
    public ResponseEntity<?> getDepositsByAccountId(@PathVariable Long accountId) {
        return ResponseEntity.ok(depositsService.getDepositsByAccountId(accountId));
    }

    //works
    @PostMapping("/accounts/{accountId}/deposits")
    public ResponseEntity<DepositSuccessfullyCreated> createDeposit(@Valid @PathVariable Long accountId , @RequestBody Deposits deposit){

        URI newDepositUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(deposit.getId())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(newDepositUri).body(depositsService.createDeposit(accountId, deposit));
    }

    //works
    @PutMapping("{depositId}")
    public ResponseEntity<Object> updateDeposits(@RequestBody Deposits deposits, @PathVariable Long depositId){
        return ResponseEntity.ok(depositsService.updateDeposit(deposits,depositId));
    }

    //works
    @DeleteMapping("{depositId}")
    public ResponseEntity<Object> deleteDeposits(@PathVariable Long depositId){
        return ResponseEntity.accepted().body(depositsService.deleteDeposit(depositId)) ;
    }


}
