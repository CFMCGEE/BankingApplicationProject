package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
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
    public Bill getSingleBill(@PathVariable Long billID){
        return billService.getBillById(billID);
    }

    @GetMapping("/accounts/{accountID}/bills")
    public ResponseEntity<?> getBillsByAccountID(@PathVariable Long accountID){
        return billService.getAllBillsByAccountId(accountID);
    }

    @GetMapping("/customers/{customerID}/bills")
    public ResponseEntity<?> getBillsByCustomerID(@PathVariable Long customerID){
        return billService.getAllBillsByCustomerId(customerID);
    }


}
