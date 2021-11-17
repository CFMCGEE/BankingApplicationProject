package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getEveryAccount() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountID}")
    public Account getAccount(@PathVariable Long accountID) {
        return accountService.getSingleAccount(accountID);
    }
    
    @DeleteMapping("/{accountID}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountID){
        return accountService.deleteAccount(accountID);
    }

    @PostMapping("/customers/{customerId}/accounts")
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/{accountID}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long accountID, @Valid @RequestBody Account account){
        return accountService.updateAccount(account, accountID);
    }
}
