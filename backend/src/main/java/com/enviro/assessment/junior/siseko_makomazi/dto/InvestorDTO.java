/*
 * InvestorDTO.java
 * Data Transfer Object (DTO) for Investor data.
 * Used for API responses to transfer investor information to clients.
 * Immutable: all fields are final and set via constructor only.
 */
package com.enviro.assessment.junior.siseko_makomazi.dto; // DTO layer package

/**
 * InvestorDTO represents investor information transferred to API clients.
 * Uses immutable pattern (final fields) to prevent accidental modification.
 */
public class InvestorDTO {

    private final Long id; // Unique investor identifier (immutable)
    private final String name; // Full name of investor (immutable)
    private final String email; // Email address (immutable)
    private final int age; // Age of investor (immutable)
    private final double balance; // Account balance (immutable)

    /**
     * Constructor to create InvestorDTO with all fields
     * @param id Unique investor ID
     * @param name Investor full name
     * @param email Investor email address
     * @param age Investor age
     * @param balance Current account balance
     */
    public InvestorDTO(Long id, String name, String email, int age, double balance) {
        this.id = id; // Set immutable ID
        this.name = name; // Set immutable name
        this.email = email; // Set immutable email
        this.age = age; // Set immutable age
        this.balance = balance; // Set immutable balance
    }

    /**
     * Getter for investor ID
     * @return Unique investor identifier
     */
    public Long getId() {
        return id; // Return immutable ID
    }

    /**
     * Getter for investor name
     * @return Full name
     */
    public String getName() {
        return name; // Return immutable name
    }

    /**
     * Getter for investor email
     * @return Email address
     */
    public String getEmail() {
        return email; // Return immutable email
    }

    /**
     * Getter for investor age
     * @return Age value
     */
    public int getAge() {
        return age; // Return immutable age
    }

    /**
     * Getter for account balance
     * @return Current balance
     */
    public double getBalance() {
        return balance; // Return immutable balance
    }
}

