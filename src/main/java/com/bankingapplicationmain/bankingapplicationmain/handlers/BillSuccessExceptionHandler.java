package com.bankingapplicationmain.bankingapplicationmain.handlers;

import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleBillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleBillSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

public class BillSuccessExceptionHandler extends BillSuccessfullyFound {

    @Autowired
    private BillRepository billRepository;

    @ExceptionHandler()
    public ResponseEntity<?> handleBillSuccessfullyFoundException(){

        int successCode = HttpStatus.OK.value();

        List<Bill>  billList = billRepository.findAll();


        BillSuccessfullyFound billSuccessfullyFound = new BillSuccessfullyFound();
        billSuccessfullyFound.setCode(successCode);
        billSuccessfullyFound.setMessage("Bill Successfully Found");
        billSuccessfullyFound.setData(billList);

    return new ResponseEntity<>(billSuccessfullyFound, null, HttpStatus.OK);

    }


}
