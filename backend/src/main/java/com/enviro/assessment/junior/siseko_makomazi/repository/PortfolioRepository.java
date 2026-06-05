/*
 * PortfolioRepository.java
 * Spring Data JPA repository for Portfolio entity.
 * Provides CRUD (Create, Read, Update, Delete) operations for portfolio data access.
 * Extends JpaRepository for standard database operations.
 */
package com.enviro.assessment.junior.siseko_makomazi.repository; // Data access layer package

import com.enviro.assessment.junior.siseko_makomazi.model.Portfolio; // Portfolio entity class
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data interface
import org.springframework.stereotype.Repository; // Repository annotation

@Repository // Marks this interface as a Spring Data repository for dependency injection
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> { // Manages Portfolio entities with Long IDs
    // JpaRepository provides:
    // - save(): persist new/updated portfolio
    // - findById(): retrieve portfolio by ID
    // - findAll(): retrieve all portfolios
    // - delete(): remove portfolio
    // - deleteById(): remove portfolio by ID
}

