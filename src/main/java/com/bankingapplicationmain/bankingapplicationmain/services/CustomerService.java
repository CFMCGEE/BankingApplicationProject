package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.exceptions.CustomerNotFoundById;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.CustomerNotFoundException;
import com.bankingapplicationmain.bankingapplicationmain.exceptions.SingleCustomerNotFoundException;
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
import java.util.Optional;

@Service
public class CustomerService {


    private CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    protected void verifyCustomer(Long customerId) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isEmpty()) {
            throw new CustomerNotFoundException();
        }
    }

    // Get all customers
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
        verifyCustomer(customerId);

        if (customerRepository.findById(customerId).isEmpty()) {
            logger.info("Customer Not Found");
            throw new CustomerNotFoundById();
        }
        return customerRepository.findById(customerId).get();
    }

    public ResponseEntity<?> createCustomer(Customer customer){
        logger.info("Customer successfully created");
        customerRepository.save(customer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId) {
        verifyCustomer(customerId);

        logger.info("Customer successfully updated");
        customerRepository.save(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getCustomerByAccountId(Long customerId) {
        verifyCustomer(customerId);
        if (customerRepository.findById(customerId).isPresent()) {
            //logger
            logger.info("Customer successfully found");
            customerRepository.findById(customerId);
        }
        throw new CustomerNotFoundById();
    }
}