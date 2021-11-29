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

import javax.validation.Valid;

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
    public ResponseEntity<Object> getEveryWithdrawalByID(@PathVariable("accountID") Long accountID) {
        return new ResponseEntity<>(withdrawalsService.getAllWithdrawals(),HttpStatus.OK);
    }

    @PostMapping("accounts/{accountID}/withdrawals")
    public void postWithdrawals(@Valid @RequestBody Withdrawals withdrawals){
        withdrawalsService.createWithdrawals(withdrawals);
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
