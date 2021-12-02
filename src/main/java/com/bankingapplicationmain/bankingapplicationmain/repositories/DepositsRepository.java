package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DepositsRepository extends JpaRepository<Deposits,Long> {
  
    @Query(value = "SELECT d FROM Deposits d WHERE d.account.id = ?1 ")
    Set<Deposits> findDepositsByAccountId(Long accountId);

}
