package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        return ResponseEntity.ok(accountService.getSingleAccount(accountID));
    }

    @GetMapping("/customers/{customerId}/accounts") //
    public ResponseEntity<Object> getEveryAccountByID(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(accountService.getAllAccountsByCustomer(customerId));
    }

    @PostMapping("/customers/{customerId}/accounts")
    public ResponseEntity<Object> createAccount(@Valid @RequestBody Account account, @PathVariable("customerId") Long customerId) {

        URI newAccount = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        return ResponseEntity.created(newAccount).body(accountService.createAccount(account, customerId));

    }

    @PutMapping("/{accountID}")
    public ResponseEntity<Object> updateAccount(@PathVariable Long accountID, @Valid @RequestBody Account account){
        return ResponseEntity.ok(accountService.updateAccount(accountID, account));
    }
    
    @DeleteMapping("/{accountID}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long accountID){
        return ResponseEntity.accepted().body(accountService.deleteAccount(accountID));
    }
}
