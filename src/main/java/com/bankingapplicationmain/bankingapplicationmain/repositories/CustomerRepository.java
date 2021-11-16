package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
