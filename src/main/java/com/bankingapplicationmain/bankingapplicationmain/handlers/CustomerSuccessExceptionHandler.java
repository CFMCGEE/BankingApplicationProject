package com.bankingapplicationmain.bankingapplicationmain.handlers;


import com.bankingapplicationmain.bankingapplicationmain.details.success.CustomerSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleCustomerSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.CustomerSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleCustomerSuccessfullyFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomerSuccessExceptionHandler extends CustomerSuccessfullyFound {

    @Autowired
    private CustomerRepository customerRepository;

    @ExceptionHandler(CustomerSuccessfullyFoundException.class)
    public ResponseEntity<?> handleCustomerSuccessfullyFoundException() {

        List<Customer> customerList = customerRepository.findAll();

        CustomerSuccessfullyFound customerSuccessfullyFound = new CustomerSuccessfullyFound();
        customerSuccessfullyFound.setCode(HttpStatus.OK.value());
        customerSuccessfullyFound.setMessage("Success!"); // Success
        customerSuccessfullyFound.setData(customerList);

        return new ResponseEntity<>(customerSuccessfullyFound, null, HttpStatus.OK);

    }

    @ExceptionHandler(SingleCustomerSuccessfullyFoundException.class)
    public ResponseEntity<?> handleSingleCustomerSuccessfullyFoundException(Long customerID) {

        Customer customerList = customerRepository.findById(customerID).orElse(null);

        SingleCustomerSuccessfullyFound singleCustomerSuccessfullyFound = new SingleCustomerSuccessfullyFound();
       singleCustomerSuccessfullyFound.setCode(HttpStatus.OK.value());
        singleCustomerSuccessfullyFound.setMessage("Success!");
        singleCustomerSuccessfullyFound.setData(customerList);

        return new ResponseEntity<>(singleCustomerSuccessfullyFound, null, HttpStatus.OK);

    }

}
