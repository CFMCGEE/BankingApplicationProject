package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.BillByIdSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillByAccountIDNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleBillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.repositories.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;


    private static final Logger logger = LoggerFactory.getLogger(BillService.class);


    public ResponseEntity<Object> getAllBillsByAccountId(Long accountID){

        List<Bill> billsByCustomerID = billRepository.findAllById(Collections.singleton(accountID));
        try {
            logger.info("All Bills For This Account Successfully Found!");
            BillSuccessfullyFound billSuccessfullyFound = new BillSuccessfullyFound(HttpStatus.OK.value(), "Success!", billsByCustomerID);
            return new ResponseEntity<>(billSuccessfullyFound, HttpStatus.OK);

        } catch(BillNotFoundException e) {
            throw new BillNotFoundException();
            }
    }

    public Bill getBillById(Long id) {
        if (billRepository.findById(id).isEmpty()) {
            logger.info("Bill Not Found.");
        }
        return billRepository.findById(id).orElseThrow(() -> new SingleBillNotFoundException());
    }

    public ResponseEntity<Object> getAllBillsByCustomerId(Long customerID) {
        Iterable<Bill> billsByCustomerID = billRepository.findAllById(Collections.singleton(customerID));
        try {
            logger.info("All Bills For This Customer Successfully Found!");
            BillByIdSuccessfullyFound billByIdSuccessfullyFound = new BillByIdSuccessfullyFound(HttpStatus.OK.value(), "Success!", billsByCustomerID);
            return new ResponseEntity<>(billByIdSuccessfullyFound, HttpStatus.OK);

        } catch (BillByAccountIDNotFoundException e) {
            throw new BillByAccountIDNotFoundException();
        }
    }

}
