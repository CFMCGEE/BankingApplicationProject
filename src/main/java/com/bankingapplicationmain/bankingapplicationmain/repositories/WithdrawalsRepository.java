package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface WithdrawalsRepository extends JpaRepository<Withdrawals, Long> {

    @Query("SELECT w FROM Withdrawals w JOIN w.account a WHERE a.id = ?1")
    Set<Withdrawals> findWithdrawalsByAccountId(Long accountId);

}
