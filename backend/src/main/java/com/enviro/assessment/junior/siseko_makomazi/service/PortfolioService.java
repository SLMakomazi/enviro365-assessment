/*
 * PortfolioService.java
 * Service class for business logic related to portfolio operations.
 * Handles data retrieval, transformation, and DTO mapping.
 * Uses PortfolioRepository for database access.
 */
package com.enviro.assessment.junior.siseko_makomazi.service; // Service layer package

import java.util.List; // For returning lists
import java.util.stream.Collectors; // For stream operations

import org.springframework.stereotype.Service; // Service annotation

import com.enviro.assessment.junior.siseko_makomazi.dto.PortfolioDTO; // DTO for API responses
import com.enviro.assessment.junior.siseko_makomazi.model.Portfolio; // Entity model
import com.enviro.assessment.junior.siseko_makomazi.repository.PortfolioRepository; // Data access

@Service // Marks this class as a business logic service component
public class PortfolioService {

    private final PortfolioRepository portfolioRepository; // Repository for database operations (injected)

    /**
     * Constructor with dependency injection for PortfolioRepository
     */
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository; // Inject the repository dependency
    }

    /**
     * Retrieves all portfolios from the database and converts to DTOs
     * @return List of PortfolioDTO objects containing all portfolios
     */
    public List<PortfolioDTO> getAllPortfolios() {
        return portfolioRepository.findAll() // Fetch all portfolios from database
                .stream() // Convert to stream for functional processing
                .map(this::mapToDto) // Transform each Portfolio entity to PortfolioDTO
                .collect(Collectors.toList()); // Collect results into a list
    }

    /**
     * Retrieves a specific portfolio by ID and converts to DTO
     * @param id The portfolio ID to retrieve
     * @return PortfolioDTO containing the portfolio details
     * @throws NoSuchElementException if portfolio not found
     */
    public PortfolioDTO getPortfolioById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow(); // Find portfolio or throw exception
        return mapToDto(portfolio); // Convert entity to DTO and return
    }

    /**
     * Maps Portfolio entity to PortfolioDTO
     * @param portfolio The entity to map
     * @return PortfolioDTO with populated fields
     */
    private PortfolioDTO mapToDto(Portfolio portfolio) { // Private helper method for entity-to-DTO transformation
        Long id = (Long) portfolio.getId(); // Extract ID with explicit cast (Eclipse null analysis)
        
        return new PortfolioDTO( // Create and return new DTO instance
                id, // Unique identifier
                portfolio.getName(), // Portfolio name/description
                portfolio.getTotalValue() // Current market value of all assets
        );
    }
}