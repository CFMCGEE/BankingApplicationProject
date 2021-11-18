package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.details.success.SingleCustomerSuccessfullyFound;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.UnableToCreateAccountException;
import com.bankingapplicationmain.bankingapplicationmain.details.success.CustomerAccountSuccessfullyCreated;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.*;
import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
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


    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get all customerss
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            logger.info("No customers found");
            throw new CustomerNotFoundException();
        }
        logger.info("Customers successfully found");
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //get customer by id
    public Customer getCustomerById(Long customerId) {

        if (customerRepository.findById(customerId).isEmpty()) {
            logger.info("Customer Not Found");
            throw new CustomerNotFoundById();
        }
        logger.info("Customer successfully found");
        return customerRepository.findById(customerId).get();
    }

    public ResponseEntity<?> createCustomer(Customer customer){

        try {

            logger.info("Customer successfully created!");

            int successCode = HttpStatus.OK.value();

            HttpHeaders responseHeaders = new HttpHeaders();
            URI newCustomerUri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(customer.getId())
                    .toUri();
            responseHeaders.setLocation(newCustomerUri);

            CustomerAccountSuccessfullyCreated customerAccountSuccessfullyCreated = new CustomerAccountSuccessfullyCreated(successCode, "Customer Successfully Created!", customerRepository.save(customer));

            return new ResponseEntity<>(customerAccountSuccessfullyCreated, responseHeaders, HttpStatus.CREATED);

        } catch (UnableToCreateAccountException e) {
           throw new UnableToCreateAccountException();
        }

    }

    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId) {

        logger.info("Customer successfully updated");

        SingleCustomerSuccessfullyFound customerSuccessfullyUpdated = new SingleCustomerSuccessfullyFound(HttpStatus.OK.value(), "Customer Info Successfully Updated!", customerRepository.save(customer));

        return new ResponseEntity<>(customerSuccessfullyUpdated, HttpStatus.OK);
    }

    public ResponseEntity<?> getCustomerByAccountId(Long customerId) {
        if (customerRepository.findById(customerId).isPresent()) {
            //logger
            logger.info("Customer successfully found");
            customerRepository.findById(customerId);
        }
        throw new CustomerNotFoundById();
    }


}