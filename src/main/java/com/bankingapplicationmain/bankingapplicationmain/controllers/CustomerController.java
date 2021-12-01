package com.bankingapplicationmain.bankingapplicationmain.controllers;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.CustomerNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    CustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @GetMapping
    public ResponseEntity<?> getAllCustomers(){

        try {
            logger.info("Getting all customers");
            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            logger.error("Customer not found");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //get customer by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){

        try {
            logger.info("Getting customer by id");
            return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            logger.error("Customer not found");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //create customer
    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
        try {
            logger.info("Creating customer");
            return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
        } catch (CustomerNotFoundException e) {
            logger.error("Customer not found");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //edit customer
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer){
        try {
            logger.info("Updating customer");
            return new ResponseEntity<>(customerService.updateCustomer(customer, id), HttpStatus.OK);

        } catch (CustomerNotFoundException e) {
            logger.error("Customer not found");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Get customer that owns the specified account
    @GetMapping("/account/{accountId}/customer")
    public ResponseEntity<?> getCustomerByAccount(@PathVariable Long accountId){
        try {
            logger.info("Getting customer by account");
            return new ResponseEntity<>(customerService.getCustomerByAccount(accountId), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            logger.error("Customer not found");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}