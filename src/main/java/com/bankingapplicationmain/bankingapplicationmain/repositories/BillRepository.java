package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT b FROM Bill b WHERE b.account.id = ?1")
    List<Bill> findBillsByAccountId(Long id);

//    @Query(value = "SELECT b FROM Bill b JOIN b b.account.customer_id = ?1")
//    List<Bill> findBillsByCustomerId(Long id);

}
