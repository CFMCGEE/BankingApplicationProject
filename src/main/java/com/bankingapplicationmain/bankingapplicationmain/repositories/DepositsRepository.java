package com.bankingapplicationmain.bankingapplicationmain.repositories;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositsRepository extends JpaRepository<Deposits,Long> {
}
