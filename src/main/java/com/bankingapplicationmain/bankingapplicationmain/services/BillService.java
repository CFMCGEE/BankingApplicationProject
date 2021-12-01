package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleBillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
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
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;



    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    public List<Bill> getAllBills(){
        List<Bill> billsList = billRepository.findAll();

        if (billsList.isEmpty()) {
            throw new BillNotFoundException();
        } else {
            logger.info("All bills successfully found.");
            return billRepository.findAll();
        }
    }

    public Bill getBillById(Long id){
        if (billRepository.findById(id).isPresent()) {
            logger.info("Bill successfully found.");
        }

        return billRepository.findById(id).orElseThrow(() -> new SingleBillNotFoundException());
    }

//    public List<Bill> getAllBillsByAccountId(Long id) {
//        //Account account;
//        List<Bill> billList = billRepository.findAll();
//        if (accountRepository.findById(id).isPresent()) {
//            logger.info("Account id found");
//        }
//        return null;
//    }

    public ResponseEntity<?> createBill(Bill bill){
        logger.info("Bill created Successfully");
      billRepository.save(bill);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBillURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{accountId}")
                .buildAndExpand(bill.getId())
                .toUri();
        responseHeaders.setLocation(newBillURI);


        return new ResponseEntity<>(null,responseHeaders,HttpStatus.CREATED);

    }

    public ResponseEntity<?> updateBill(Bill bill, Long id){
        logger.info("Accepted bill modification");
        billRepository.save(bill);


        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> deleteBill( Long id){
        billRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
