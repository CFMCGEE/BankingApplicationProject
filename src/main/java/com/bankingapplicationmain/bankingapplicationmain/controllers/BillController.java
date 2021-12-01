package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/bills/")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("{billID}")
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

    @PutMapping("{id}")
    public ResponseEntity<Object> updateBill(@PathVariable Long id, @Valid @RequestBody Bill bill) {
        return ResponseEntity.ok(billService.updateBill(id, bill));
    }

    @PostMapping("accounts/{accountId}/bills")
    public ResponseEntity<Object> createBill(@Valid @RequestBody Bill bill, @PathVariable Long accountId){
        return ResponseEntity.status(HttpStatus.CREATED).body(billService.createBill(bill, accountId));
    }

    @DeleteMapping("{id}")
    public void deleteBill( @PathVariable Long id){
        billService.deleteBill(id);
    }

}
