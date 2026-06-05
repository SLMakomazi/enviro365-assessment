/*
 * InvestorService.java
 * Service class for business logic related to investor operations.
 * Handles data retrieval, transformation, and DTO mapping.
 * Uses InvestorRepository for database access.
 */
package com.enviro.assessment.junior.siseko_makomazi.service; // Service layer package

import java.util.List; // For returning lists
import java.util.stream.Collectors; // For stream operations

import org.springframework.stereotype.Service; // Service annotation

import com.enviro.assessment.junior.siseko_makomazi.dto.InvestorDTO; // DTO for API responses
import com.enviro.assessment.junior.siseko_makomazi.model.Investor; // Entity model
import com.enviro.assessment.junior.siseko_makomazi.repository.InvestorRepository; // Data access

@Service // Marks this class as a business logic service component
public class InvestorService {

    private final InvestorRepository investorRepository; // Repository for database operations (injected)

    /**
     * Constructor with dependency injection for InvestorRepository
     */
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository; // Inject the repository dependency
    }

    /**
     * Retrieves all investors from the database and converts to DTOs
     * @return List of InvestorDTO objects containing all investors
     */
    public List<InvestorDTO> getAllInvestors() {
        return investorRepository.findAll() // Fetch all investors from database
                .stream() // Convert to stream for functional processing
                .map(this::mapToDto) // Transform each Investor entity to InvestorDTO
                .collect(Collectors.toList()); // Collect results into a list
    }

    /**
     * Retrieves a specific investor by ID and converts to DTO
     * @param id The investor ID to retrieve
     * @return InvestorDTO containing the investor details
     * @throws NoSuchElementException if investor not found
     */
    public InvestorDTO getInvestorById(Long id) {
        Investor investor = investorRepository.findById(id).orElseThrow(); // Find investor or throw exception
        return mapToDto(investor); // Convert entity to DTO and return
    }

    /**
     * Maps Investor entity to InvestorDTO
     * @param investor The entity to map
     * @return InvestorDTO with populated fields
     */
    private InvestorDTO mapToDto(Investor investor) { // Private helper method for entity-to-DTO transformation
        Long id = (Long) investor.getId(); // Extract ID with explicit cast (Eclipse null analysis)
        
        return new InvestorDTO( // Create and return new DTO instance
                id, // Unique identifier
                investor.getName(), // Full name
                investor.getEmail(), // Email address
                investor.getAge(), // Age for compliance
                investor.getBalance() // Current account balance
        );
    }
}