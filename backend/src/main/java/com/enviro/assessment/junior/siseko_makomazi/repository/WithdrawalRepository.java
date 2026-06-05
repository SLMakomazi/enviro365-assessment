package com.enviro.assessment.junior.siseko_makomazi.repository;

import com.enviro.assessment.junior.siseko_makomazi.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
}

