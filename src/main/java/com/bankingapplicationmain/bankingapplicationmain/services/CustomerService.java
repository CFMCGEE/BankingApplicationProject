package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.CustomerSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.details.success.CustomersSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.UnableToCreateAccountException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.repositories.AccountRepository;
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
import java.util.List;



@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private AccountRepository accountRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get all customers
    public ResponseEntity<Object> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            logger.info("No customers found");
            throw new CustomerNotFoundException();
        }

        logger.info("Customers successfully found");
        CustomersSuccessfullyFound customersSuccessfullyFound = new CustomersSuccessfullyFound(HttpStatus.OK.value(),
                "Customers Successfully Found!", customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //get customer by id
    public ResponseEntity<Object> getCustomerById(Long customerId) {
        if (customerRepository.findById(customerId).isEmpty()) {
            logger.info("Customer not found");
            throw new SingleCustomerNotFoundException();
        }

        Customer customer = customerRepository.findById(customerId).get();
        logger.info("Customer successfully found");
        CustomerSuccessfullyFound customerSuccessfullyFound = new CustomerSuccessfullyFound(HttpStatus.OK.value(),
                "Customer Successfully Found!", customer);
        return new ResponseEntity<>(customerSuccessfullyFound, HttpStatus.OK);
    }

    public ResponseEntity<?> createCustomer(Customer customer){
        logger.info("Customer successfully created!");

        int successCode = HttpStatus.CREATED.value();

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);

        CustomerSuccessfullyFound customerSuccessfullyCreated = new CustomerSuccessfullyFound(successCode,
                "Customer Successfully Created!",
                customerRepository.save(customer));
        return new ResponseEntity<>(customerSuccessfullyCreated, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId) {
        if (customerRepository.findById(customerId).isEmpty()) {
            logger.info("Customer not found");
            throw new SingleCustomerNotFoundException();
        }

        logger.info("Customer successfully updated!");
        CustomerSuccessfullyFound customerSuccessfullyUpdated = new CustomerSuccessfullyFound(HttpStatus.OK.value(),
                "Customer Successfully Updated!",
                customerRepository.save(customer));
        return new ResponseEntity<>(customerSuccessfullyUpdated, HttpStatus.OK);
    }

    public ResponseEntity<?> getCustomerByAccountId(Long accountId, Long customerId) {

        if (customerRepository.findById(customerId).isEmpty() || accountRepository.findById(accountId).isEmpty()) {
            logger.info("Customer not found");
            throw new SingleCustomerNotFoundException();
        }

        Customer customer = customerRepository.findById(customerId).get();
//        Account account = accountRepository.findById(accountId).get();
        logger.info("Customer successfully found");
        CustomerSuccessfullyFound customerSuccessfullyFound = new CustomerSuccessfullyFound(HttpStatus.OK.value(),
                "Customer Successfully Found!", customer);
        return new ResponseEntity<>(customerSuccessfullyFound, HttpStatus.OK);
    }

}