package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.BillByIDSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessMethods;
import com.bankingapplicationmain.bankingapplicationmain.details.success.BillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleBillSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
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


    protected void verifyBill(Long billId) throws UnableToUpdateBillException {
        Bill bill = billRepository.findById(billId).orElse(null);

        if(bill == null){
            throw new UnableToUpdateBillException();
        }
    }


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

    public Bill createBill(Bill bill, Long billID) {
        if(billRepository.findById(billID).isEmpty()){
            logger.info("Error Trying To Create a Bill");
            throw new UnableToCreateBillException();
        }

        logger.info("Bill Created");




        return billRepository.save(bill);

    }

    public Bill updateBill(Bill bill, Long id) {
        //shout out to whoever did the account this jawn is wild
        verifyBill(id);
        
        logger.info("Bill Successfully Modified");
        

        return billRepository.save(bill);

    }


    public Object deleteBill( Long id) {
        logger.info("Deleted Bill");
        billRepository.deleteById(id);
        
        if(billRepository.findById(id).isEmpty()){
            throw new UnableToDeleteBillException();
        }

        return new BillSuccessMethods(HttpStatus.ACCEPTED.value(), "Bill Successfully Deleted");

    }

}
