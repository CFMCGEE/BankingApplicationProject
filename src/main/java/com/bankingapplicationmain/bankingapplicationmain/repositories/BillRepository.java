package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT b.customer FROM Bill b WHERE b.id = ?1")
     List<Long> findCustomerByBillId(Long id);
}
