package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalsRepository extends JpaRepository<Withdrawals, Long> {

}
