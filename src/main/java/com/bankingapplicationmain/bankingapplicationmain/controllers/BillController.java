package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("bills/{billID}")
    public ResponseEntity<?> getSingleBill(@PathVariable Long billID){
        return billService.getBillById(billID);
    }

    @GetMapping("accounts/{accountID}/bills")
    public ResponseEntity<?> getBillsByAccountID(@PathVariable Long accountID){
        return billService.getAllBillsByAccountID(accountID);
    }

    @GetMapping("/customers/{customerID}/bills")
    public ResponseEntity<?> getBillsByCustomerID(@PathVariable Long customerID){
        return billService.getAllBillsByCustomerID(customerID);
    }

    @PutMapping("bills/{billID}")
    public ResponseEntity<?> updateBill(@PathVariable Long billID, @Valid @RequestBody Bill bill) {
        return billService.updateBill(billID, bill);
    }

    @PostMapping("accounts/{accountID}/bills")
    public ResponseEntity<?> postBill(@Valid @RequestBody Bill bill, @PathVariable(name = "accountID") Long billID){
        return billService.createBill(bill, billID);
    }

    @DeleteMapping("/bills/{id}")
    public void deleteBill( @PathVariable Long id){
        billService.deleteBill(id);
    }


}
