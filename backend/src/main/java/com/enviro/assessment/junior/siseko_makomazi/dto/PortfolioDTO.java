/*
 * PortfolioDTO.java
 * Data Transfer Object (DTO) for Portfolio data.
 * Used for API responses to transfer portfolio information to clients.
 * Immutable: all fields are final and set via constructor only.
 */
package com.enviro.assessment.junior.siseko_makomazi.dto; // DTO layer package

/**
 * PortfolioDTO represents portfolio information transferred to API clients.
 * Uses immutable pattern (final fields) to prevent accidental modification.
 */
public class PortfolioDTO {

    private final Long id; // Unique portfolio identifier (immutable)
    private final String name; // Portfolio name/description (immutable)
    private final double totalValue; // Total market value of portfolio (immutable)

    /**
     * Constructor to create PortfolioDTO with all fields
     * @param id Unique portfolio ID
     * @param name Portfolio name or description
     * @param totalValue Current total market value
     */
    public PortfolioDTO(Long id, String name, double totalValue) {
        this.id = id; // Set immutable ID
        this.name = name; // Set immutable name
        this.totalValue = totalValue; // Set immutable totalValue
    }

    /**
     * Getter for portfolio ID
     * @return Unique portfolio identifier
     */
    public Long getId() {
        return id; // Return immutable ID
    }

    /**
     * Getter for portfolio name
     * @return Portfolio name or description
     */
    public String getName() {
        return name; // Return immutable name
    }

    /**
     * Getter for portfolio total value
     * @return Current market value of all assets
     */
    public double getTotalValue() {
        return totalValue; // Return immutable totalValue
    }
}

