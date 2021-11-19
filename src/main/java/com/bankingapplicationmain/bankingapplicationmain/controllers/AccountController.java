package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Object> getAccount(@PathVariable Long accountID) {
        return accountService.getSingleAccount(accountID);
    }

    @GetMapping("/customers/{customerId}/accounts") //
    public ResponseEntity<Object> getEveryAccountByID(@PathVariable("customerId") Long customerId) {
        return accountService.getAllAccountsByCustomer(customerId);
    }

    @PostMapping("/customers/{customerId}/accounts")
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account, @PathVariable("customerId") Long customerId) {
        return accountService.createAccount(account, customerId);
    }

    @PutMapping("/{accountID}")
    public ResponseEntity<?> updateAccount(@PathVariable Long accountID, @Valid @RequestBody Account account){
        return accountService.updateAccount(accountID, account);
    }
    
    @DeleteMapping("/{accountID}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountID){
        return accountService.deleteAccount(accountID);
    }
}
