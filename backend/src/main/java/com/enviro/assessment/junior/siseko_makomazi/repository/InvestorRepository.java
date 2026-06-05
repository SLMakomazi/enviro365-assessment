/*
 * InvestorRepository.java
 * Spring Data JPA repository for Investor entity.
 * Provides CRUD (Create, Read, Update, Delete) operations for investor data access.
 * Extends JpaRepository for standard database operations.
 */
package com.enviro.assessment.junior.siseko_makomazi.repository; // Data access layer package

import com.enviro.assessment.junior.siseko_makomazi.model.Investor; // Investor entity class
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data interface
import org.springframework.stereotype.Repository; // Repository annotation

@Repository // Marks this interface as a Spring Data repository for dependency injection
public interface InvestorRepository extends JpaRepository<Investor, Long> { // Manages Investor entities with Long IDs
    // JpaRepository provides:
    // - save(): persist new/updated investor
    // - findById(): retrieve investor by ID
    // - findAll(): retrieve all investors
    // - delete(): remove investor
    // - deleteById(): remove investor by ID
}

