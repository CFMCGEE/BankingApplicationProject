package com.bankingapplicationmain.bankingapplicationmain.services;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
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

    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        verifyCustomer(customerId);

        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
