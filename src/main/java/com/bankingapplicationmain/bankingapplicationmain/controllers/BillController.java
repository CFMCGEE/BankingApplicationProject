package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping()
    public List<Bill> getAllBills(){
        return billService.getAllBills();
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id){
        return billService.getBillById(id);
    }

    @PostMapping
    @RequestMapping
    public ResponseEntity<?> postBill(@Valid @RequestBody Bill bill){

        return billService.createBill(bill);
    }
    @DeleteMapping("/{id}")
    public void deleteBill( @PathVariable Long id){
        billService.deleteBill(id);
    }

}
