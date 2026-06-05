/*
 * Product.java
 * Entity class representing an investment product that can be held in a portfolio.
 * Maps to the 'product' table in the database.
 * Stores product details including name, description, and risk classification.
 */
package com.enviro.assessment.junior.siseko_makomazi.model;

import jakarta.persistence.Entity; // JPA entity marker
import jakarta.persistence.GeneratedValue; // Auto-generation strategy
import jakarta.persistence.GenerationType; // ID generation type
import jakarta.persistence.Id; // Primary key annotation

@Entity // Marks this class as a JPA entity for database persistence
public class Product {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID from database
    private Long id; // Unique identifier for the product
    
    private String name; // Product name (e.g., "ESG Bond Fund", "Green Energy ETF")
    private String description; // Detailed description of the product and its holdings
    private String riskLevel; // Risk classification: LOW, MEDIUM, HIGH

    /**
     * No-argument constructor required by JPA for entity instantiation
     */
    public Product() {
    }

    /**
     * Constructor for creating a new product with details.
     * Note: ID is auto-generated, not provided here.
     */
    public Product(String name, String description, String riskLevel) {
        this.name = name; // Set product name
        this.description = description; // Set detailed description
        this.riskLevel = riskLevel; // Set risk classification
    }

    /**
     * Getter for product ID
     */
    public Long getId() {
        return id; // Return the unique product identifier
    }

    /**
     * Getter for product name
     */
    public String getName() {
        return name; // Return product name
    }

    /**
     * Getter for product description
     */
    public String getDescription() {
        return description; // Return detailed product description
    }

    /**
     * Getter for product risk level
     */
    public String getRiskLevel() {
        return riskLevel; // Return risk classification (LOW, MEDIUM, HIGH)
    }
}

