package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.BillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleBillNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
import com.bankingapplicationmain.bankingapplicationmain.repositories.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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

    public void createBill(Bill bill){
        billRepository.save(bill);
    }


}
