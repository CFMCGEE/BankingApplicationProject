package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("bills/{billID}")
    public ResponseEntity<?> getSingleBill(@PathVariable Long billID){
        return ResponseEntity.ok(billService.getBillById(billID));
    }

    @GetMapping("accounts/{accountId}/bills")
    public ResponseEntity<?> getBillsByAccountId(@PathVariable Long accountId){
        return ResponseEntity.ok(billService.getAllBillsByAccountId(accountId));
    }

//    @GetMapping("/customers/{customerId}/bills")
//    public ResponseEntity<?> getBillsByCustomerId(@PathVariable Long customerId){
//        return ResponseEntity.ok(billService.getAllBillsByCustomerId(customerId));
//    }

    @PutMapping("bills/{billID}")
    public ResponseEntity<Object> updateBill(@PathVariable Long billId, @Valid @RequestBody Bill bill) {
        return ResponseEntity.ok(billService.updateBill(bill, billId));
    }

    @PostMapping("accounts/{accountId}/bills")
    public ResponseEntity<Object> createBill(@Valid @RequestBody Bill bill, @PathVariable Long accountId){
        return ResponseEntity.status(HttpStatus.CREATED).body(billService.createBill(bill, accountId));
    }

    @DeleteMapping("/bills/{id}")
    public void deleteBill( @PathVariable Long id){
        billService.deleteBill(id);
    }

}
