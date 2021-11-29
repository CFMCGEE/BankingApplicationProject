package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.BillByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleBillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillByIDNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleBillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.UnableToCreateBillException;
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

    public List<Bill> getAllBillsByAccountID(Long accountID) {
        List<Bill> billsByCustomerID = billRepository.findAllById(Collections.singleton(accountID));
        if (billsByCustomerID.isEmpty()) {
            logger.info("Error Trying To Get All Account Bill(s)");
            throw new BillNotFoundException();
        } else {
                logger.info("All Bills For This Account Successfully Found.");
                //BillByIDSuccessfullyFound billByIDSuccessfullyFound = new BillByIDSuccessfullyFound(HttpStatus.OK.value(), "Bills Successfully Found!", billsByCustomerID);
                return billsByCustomerID;
            }
    }

    public Bill getBillById(Long billID){
        Bill singleBill = billRepository.findById(billID).orElseThrow(() -> new SingleBillNotFoundException());
        if (billRepository.findById(billID).isEmpty()) {
            logger.info("Bill Not Found.");
        }

        logger.info("Bill Found At This ID.");
        SingleBillSuccessfullyFound singleBillSuccessfullyFound = new SingleBillSuccessfullyFound(HttpStatus.OK.value(), "Bills Successfully Found!", singleBill);
        singleBillSuccessfullyFound.setCode(HttpStatus.OK.value());
        singleBillSuccessfullyFound.setMessage("Bill Found Successfully");
        singleBillSuccessfullyFound.setData(singleBill);
        return singleBill;
    }

    public ResponseEntity<Object> getAllBillsByCustomerID(Long customerID) {
        Iterable<Bill> billsByCustomerID = billRepository.findAllById(Collections.singleton(customerID));

        try {
            logger.info("All Bills For This Customer Successfully Found!");
            BillByIDSuccessfullyFound billByIdSuccessfullyFound = new BillByIDSuccessfullyFound(HttpStatus.OK.value(), "Bills Successfully Found!", billsByCustomerID);
            return new ResponseEntity<>(billByIdSuccessfullyFound, HttpStatus.OK);
        } catch (BillByIDNotFoundException e) {
            logger.info("Error Trying To Get All Customer Bill(s)");
            throw new BillByIDNotFoundException();
        }
    }

    public ResponseEntity<?> createBill(Bill bill, Long billID) {
        if(billRepository.findById(billID).isEmpty()){
            logger.info("Error Trying To Create a Bill");
            throw new UnableToCreateBillException();
        }

        logger.info("Bill Created");
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

    public ResponseEntity<?> updateBill(Bill bill, Long id) {
        logger.info("Bill Successfully Modified");
        billRepository.save(bill);

        return new ResponseEntity<>(HttpStatus.OK);

    }


    public ResponseEntity<?> deleteBill( Long id) {
        logger.info("Deleted Bill");
        billRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
