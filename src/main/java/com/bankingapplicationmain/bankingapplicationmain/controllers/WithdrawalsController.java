package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.details.success.WithdrawalsByAccountSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;
import com.bankingapplicationmain.bankingapplicationmain.services.BillService;
import com.bankingapplicationmain.bankingapplicationmain.services.WithdrawalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalsController {

    @Autowired
    private WithdrawalsService withdrawalsService;

    @GetMapping("/{withdrawalId}")
    public ResponseEntity<Object> getWithdrawalByID(@PathVariable Long withdrawalId) {
        return new ResponseEntity<>(withdrawalsService.getSingleWithdrawals(withdrawalId), HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountID}/withdrawals")
    public ResponseEntity<Object> getEveryWithdrawalByID(@PathVariable Long accountID) {
        return ResponseEntity.ok(withdrawalsService.getAllWithdrawalsByAccountID(accountID));
    }

    @PostMapping("accounts/{accountID}/withdrawals")
    public ResponseEntity<Object> postWithdrawals(@PathVariable Long accountID, @Valid @RequestBody Withdrawals withdrawals){

        URI newWithdrawals = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(withdrawals.getId())
                .toUri();

        return ResponseEntity.created(newWithdrawals).body(withdrawalsService.createWithdrawals(accountID, withdrawals));
    }

    @PutMapping("/{withdrawalId}")
    public void updateWithdrawals(@Valid @RequestBody Withdrawals withdrawals, @PathVariable Long withdrawalId){
        withdrawalsService.updateWithdrawals(withdrawals, withdrawalId);
    }

    @DeleteMapping("/{withdrawalId}")
    public void deleteWithdrawal(@PathVariable Long withdrawalId){
        withdrawalsService.deleteWithdrawals(withdrawalId);
    }

}
