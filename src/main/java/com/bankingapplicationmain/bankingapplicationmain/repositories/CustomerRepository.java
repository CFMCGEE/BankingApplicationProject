package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //query to join the customer and account tables and get customer by account id
    @Query(value = "SELECT c FROM Customer c JOIN c.accounts a WHERE a.id = ?1")
    Customer findCustomerByAccountId(Long accountId);
}
