package com.enviro.assessment.junior.siseko_makomazi.repository;

import com.enviro.assessment.junior.siseko_makomazi.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}

