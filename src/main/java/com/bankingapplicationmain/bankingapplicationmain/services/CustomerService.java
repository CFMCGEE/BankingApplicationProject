package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.CustomerSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.UnableToCreateAccountException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
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

    // Get all customerss
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        try {
            for (Customer customer : customers) {
                logger.info("Customer successfully found");
                return new ResponseEntity<>(customers, HttpStatus.OK);
            }

        }
        catch (CustomerNotFoundException e) {
            logger.info("Customer not found");
            throw new CustomerNotFoundException();
        }
        return null;
    }

    //get customer by id
    public Customer getCustomerById(Long customerId) {
        try {
            if (customerRepository.findById(customerId).isPresent()) {
                logger.info("Customer successfully found");

                return customerRepository.findById(customerId).get();
            }
        } catch (CustomerNotFoundException e) {
            logger.info("Customer not found");
            throw new CustomerNotFoundException();
        }
        return null;
    }

    public ResponseEntity<?> createCustomer(Customer customer){

        try {

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

        } catch (UnableToCreateAccountException e) {
           throw new UnableToCreateAccountException();
        }

    }

    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId) {

        try {
            logger.info("Customer successfully updated");

            CustomerSuccessfullyFound customerSuccessfullyUpdated = new CustomerSuccessfullyFound(HttpStatus.OK.value(),
                    "Customer Info Successfully Updated!",
                    customerRepository.save(customer));

            return new ResponseEntity<>(customerSuccessfullyUpdated, HttpStatus.OK);
        } catch (UnableToUpdateCustomerException e) {
            throw new UnableToUpdateCustomerException();
        }
    }

    public ResponseEntity<?> getCustomerByAccountId(Long accountId, Long customerId) {

        try {
            if (accountRepository.findById(accountId).isPresent()) {
                logger.info("Customer successfully found");

                CustomerSuccessfullyFound customerSuccessfullyUpdated = new CustomerSuccessfullyFound(HttpStatus.OK.value(),
                        "Customer Found By Account!",
                        customerRepository.findById(customerId).get());

                return new ResponseEntity<>(customerSuccessfullyUpdated, HttpStatus.OK);
            }

        } catch (CustomerNotFoundById e) {
            logger.info("Customer Not Found");
            throw new CustomerNotFoundById();
        }
        return null;
    }

}