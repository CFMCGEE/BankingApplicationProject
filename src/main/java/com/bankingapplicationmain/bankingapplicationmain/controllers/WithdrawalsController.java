package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;
import com.bankingapplicationmain.bankingapplicationmain.services.BillService;
import com.bankingapplicationmain.bankingapplicationmain.services.WithdrawalsService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return withdrawalsService.getSingleWithdrawals(withdrawalId);
    }

    @GetMapping("/accounts/{accountID}/withdrawals")
    public ResponseEntity<Object> getEveryWithdrawalByID(@PathVariable("accountID") Long accountID) {
        return withdrawalsService.getAllWithdrawals();
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
