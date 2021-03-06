package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    //find all accounts by customer id
    @Query("SELECT a FROM Account a WHERE a.customer.id = ?1")
    Set<Account> findAllByCustomerId(Long customerId);

}
