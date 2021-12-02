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
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            throw new CustomerNotFoundException("No customers found");
        }
        return customers;
    }

    //get customer by id
    public Customer getCustomerById(Long customerId) {
        if (customerRepository.findById(customerId).isEmpty()) {
            logger.info("Customer not found");
            throw new SingleCustomerNotFoundException("Customer not found");
        }
        return customerRepository.findById(customerId).get();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, Long customerId) {

        Customer customerToUpdate = customerRepository.findById(customerId).get();
        if (customerRepository.findById(customerId).isEmpty()) {
            logger.info("Customer not found");
            throw new UnableToUpdateCustomer("Customer not found");
        }

        customerToUpdate.setFirst_Name(customer.getFirst_Name());
        customerToUpdate.setLast_Name(customer.getLast_Name());

        return customerToUpdate;
    }

    public Customer getCustomerByAccount(Long accountId) {

        if (customerRepository.findById(accountId).isEmpty()) {
            logger.info("Customer not found");
            throw new AccountByIDNotFoundException("Customer not found");
        }

        Customer customer = customerRepository.findCustomerByAccountId(accountId);
        logger.info("Customer successfully found");

        return customer;
    }
}