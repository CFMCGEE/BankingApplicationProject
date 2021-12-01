package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.BillByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessMethods;
import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleBillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import com.bankingapplicationmain.bankingapplicationmain.repositories.BillRepository;
import com.bankingapplicationmain.bankingapplicationmain.repositories.CustomerRepository;
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


    protected void verifyBill(Long billId) throws UnableToUpdateBillException {
        Bill bill = billRepository.findById(billId).orElse(null);

        if(bill == null){
            throw new UnableToUpdateBillException();
        }
    }

    public BillByIDSuccessfullyFound getAllBillsByAccountId(Long accountId) {
        return new BillByIDSuccessfullyFound(HttpStatus.OK.value(), "Successfully Found Account " + accountId + " Bills", billRepository.findBillsByAccountId(accountId));
    }

    public SingleBillSuccessfullyFound getBillById(Long billId){
        Bill singleBill = billRepository.findById(billId).orElseThrow(() -> new SingleBillNotFoundException());
        if (billRepository.findById(billId).isEmpty()) {
            logger.info("Bill Not Found.");
        }
        logger.info("Bill Found At This ID.");
        SingleBillSuccessfullyFound singleBillSuccessfullyFound = new SingleBillSuccessfullyFound(HttpStatus.OK.value(), "Bills Successfully Found!", singleBill);
        return singleBillSuccessfullyFound;
    }

//    public  BillByIDSuccessfullyFound getAllBillsByCustomerId(Long customerId) {
//        return new BillByIDSuccessfullyFound(HttpStatus.OK.value(), "Successfully Found Account " + customerId + " Bills", billRepository.findBillsByCustomerId(customerId));
//    }

    public Bill createBill(Bill bill, Long billId) {
//       if(billRepository.findById(billId).isEmpty()){
//           logger.info("Error Trying To Create a Bill");
//           throw new UnableToCreateBillException();
//       }

        try{
            logger.info("Bill Created");
            return billRepository.save(bill);
        }
        catch(UnableToCreateBillException e){
            throw new UnableToCreateBillException();
        }

    }

    public Bill updateBill(Long id, Bill bill) {
        //shout out to whoever did the account this jawn is wild
        verifyBill(id);

        logger.info("Bill Successfully Modified");
        return billRepository.save(bill);
    }

    public BillSuccessMethods deleteBill( Long id) {
        if(billRepository.findById(id).isEmpty()){
            throw new UnableToDeleteBillException();
        } else {
            logger.info("Deleted Bill");
            billRepository.deleteById(id);
            return new BillSuccessMethods(HttpStatus.ACCEPTED.value(), "Bill Successfully Deleted");
        }
    }



}
