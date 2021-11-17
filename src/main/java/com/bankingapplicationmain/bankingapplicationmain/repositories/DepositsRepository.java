package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositsRepository extends JpaRepository<Deposits,Long> {

    @Query(value="select d.* from Deposits d, Account a where a.id = ?1 and d.id = a.id", nativeQuery = true)
    List<Deposits> findByAccountID(long accountID);

}
