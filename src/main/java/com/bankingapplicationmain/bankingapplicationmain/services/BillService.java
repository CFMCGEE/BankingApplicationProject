package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.BillByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillByIDNotFoundException;
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

    public ResponseEntity<Object> getAllBillsByAccountID(Long accountID) {
        List<Bill> billsByCustomerID = billRepository.findAllById(Collections.singleton(accountID));

        if (billsByCustomerID.isEmpty()) {
            throw new BillNotFoundException();
        } else {
            try {
                logger.info("All bills for this Account successfully found.");
                BillSuccessfullyFound billSuccessfullyFound = new BillSuccessfullyFound(HttpStatus.OK.value(), "Success!", billsByCustomerID);
                return new ResponseEntity<>(billSuccessfullyFound, HttpStatus.OK);

            } catch (BillNotFoundException e) {
                    throw new BillNotFoundException();
                }
        }
    }

    public Bill getBillById(Long billID){
        if (billRepository.findById(billID).isEmpty()) {
            logger.info("Bill Not Found.");
        }

        return billRepository.findById(billID).orElseThrow(() -> new SingleBillNotFoundException());
    }

    public ResponseEntity<Object> getAllBillsByCustomerID(Long customerID) {
        Iterable<Bill> billsByCustomerID = billRepository.findAllById(Collections.singleton(customerID));
        try {
            logger.info("All Bills For This Customer Successfully Found!");
            BillByIDSuccessfullyFound billByIdSuccessfullyFound = new BillByIDSuccessfullyFound(HttpStatus.OK.value(), "Success!", billsByCustomerID);
            return new ResponseEntity<>(billByIdSuccessfullyFound, HttpStatus.OK);
        } catch (BillByIDNotFoundException e) {
            throw new BillByIDNotFoundException();
        }
    }

    public ResponseEntity<?> createBill(Bill bill) {
        logger.info("Bill created Successfully");
        billRepository.save(bill);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBillURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bill.getId())
                .toUri();
        responseHeaders.setLocation(newBillURI);


        return new ResponseEntity<>(null,responseHeaders,HttpStatus.CREATED);

    }

    public ResponseEntity<?> updateBill(Long billID, Bill bill) {
        logger.info("Accepted bill modification");
        billRepository.save(bill);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> deleteBill(Long id) {
        billRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
