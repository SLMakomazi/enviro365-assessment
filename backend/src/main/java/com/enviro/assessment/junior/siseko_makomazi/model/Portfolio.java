/*
 * Portfolio.java
 * Entity class representing an investment portfolio owned by an investor.
 * Maps to the 'portfolio' table in the database.
 * Contains portfolio name and current total market value.
 */
package com.enviro.assessment.junior.siseko_makomazi.model;

import jakarta.persistence.Entity; // JPA entity marker
import jakarta.persistence.GeneratedValue; // Auto-generation strategy
import jakarta.persistence.GenerationType; // ID generation type
import jakarta.persistence.Id; // Primary key annotation

@Entity // Marks this class as a JPA entity for database persistence
public class Portfolio {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID from database
    private Long id; // Unique identifier for the portfolio
    
    private String name; // Name/description of the portfolio (e.g., "Growth Portfolio")
    private double totalValue; // Current market value of all assets in the portfolio

    /**
     * No-argument constructor required by JPA for entity instantiation
     */
    public Portfolio() {
    }

    /**
     * Constructor for creating a new portfolio with details.
     * Note: ID is auto-generated, not provided here.
     */
    public Portfolio(String name, double totalValue) {
        this.name = name; // Set portfolio name/description
        this.totalValue = totalValue; // Set initial total market value
    }

    /**
     * Getter for portfolio ID
     */
    public Long getId() {
        return id; // Return the unique portfolio identifier
    }

    /**
     * Getter for portfolio name
     */
    public String getName() {
        return name; // Return portfolio name/description
    }

    /**
     * Getter for portfolio total value
     */
    public double getTotalValue() {
        return totalValue; // Return current market value of portfolio
    }
}

