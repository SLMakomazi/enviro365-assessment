/*
 * WithdrawalRepository.java
 * Spring Data JPA repository for Withdrawal entity.
 * Provides CRUD (Create, Read, Update, Delete) operations for withdrawal data access.
 * Extends JpaRepository for standard database operations.
 */
package com.enviro.assessment.junior.siseko_makomazi.repository; // Data access layer package

import com.enviro.assessment.junior.siseko_makomazi.model.Withdrawal; // Withdrawal entity class
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data interface
import org.springframework.stereotype.Repository; // Repository annotation

@Repository // Marks this interface as a Spring Data repository for dependency injection
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> { // Manages Withdrawal entities with Long IDs
    // JpaRepository provides:
    // - save(): persist new/updated withdrawal record
    // - findById(): retrieve withdrawal by ID
    // - findAll(): retrieve all withdrawals
    // - delete(): remove withdrawal record
    // - deleteById(): remove withdrawal by ID
}

