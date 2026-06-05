/*
 * Investor.java
 * Entity class representing an investor in the Enviro365 system.
 * Maps to the 'investor' table in the database.
 * Includes personal details, contact info, age, and account balance.
 */
package com.enviro.assessment.junior.siseko_makomazi.model;

import jakarta.persistence.Entity; // JPA entity marker
import jakarta.persistence.GeneratedValue; // Auto-generation strategy
import jakarta.persistence.GenerationType; // ID generation type
import jakarta.persistence.Id; // Primary key annotation

@Entity // Marks this class as a JPA entity for database persistence
public class Investor {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID from database
    private Long id; // Unique identifier for the investor
    
    private String name; // Full name of the investor
    private String email; // Email address for contact
    private int age; // Age of the investor (used for compliance checks)
    private double balance; // Current account balance available for investment/withdrawal

    /**
     * No-argument constructor required by JPA for entity instantiation
     */
    public Investor() {
    }

    /**
     * Constructor for creating a new investor with details.
     * Note: ID is auto-generated, not provided here.
     */
    public Investor(String name, String email, int age, double balance) {
        this.name = name; // Set investor name
        this.email = email; // Set contact email
        this.age = age; // Set age
        this.balance = balance; // Set initial account balance
    }

    /**
     * Getter for investor ID
     */
    public Long getId() {
        return id; // Return the unique investor identifier
    }

    /**
     * Getter for investor name
     */
    public String getName() {
        return name; // Return full name
    }

    /**
     * Getter for investor email
     */
    public String getEmail() {
        return email; // Return email address
    }

    /**
     * Getter for investor age
     */
    public int getAge() {
        return age; // Return investor age
    }

    /**
     * Getter for account balance
     */
    public double getBalance() {
        return balance; // Return current available balance
    }

    /**
     * Setter for account balance (used during withdrawals/deposits)
     */
    public void setBalance(double balance) {
        this.balance = balance; // Update the account balance
    }
}

