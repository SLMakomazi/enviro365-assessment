/*
 * Withdrawal.java
 * Entity class representing a withdrawal request/transaction.
 * Maps to the 'withdrawal' table in the database.
 * Tracks withdrawal amount, reason, status, and timestamp.
 */
package com.enviro.assessment.junior.siseko_makomazi.model;

import jakarta.persistence.Entity; // JPA entity marker
import jakarta.persistence.GeneratedValue; // Auto-generation strategy
import jakarta.persistence.GenerationType; // ID generation type
import jakarta.persistence.Id; // Primary key annotation
import java.time.LocalDateTime; // For storing withdrawal request timestamp

@Entity // Marks this class as a JPA entity for database persistence
public class Withdrawal {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID from database
    private Long id; // Unique identifier for the withdrawal transaction
    
    private double amount; // Amount requested for withdrawal
    private String reason; // Reason for the withdrawal (e.g., "Rebalancing", "Emergency fund")
    private String status; // Current status: PENDING, APPROVED, REJECTED, COMPLETED
    private LocalDateTime requestedAt; // Timestamp when the withdrawal was requested

    /**
     * No-argument constructor required by JPA for entity instantiation
     */
    public Withdrawal() {
    }

    /**
     * Getter for withdrawal ID
     */
    public Long getId() {
        return id; // Return the unique withdrawal transaction identifier
    }

    /**
     * Getter for withdrawal amount
     */
    public double getAmount() {
        return amount; // Return the withdrawal amount requested
    }

    /**
     * Setter for withdrawal amount
     */
    public void setAmount(double amount) {
        this.amount = amount; // Set the withdrawal amount
    }

    /**
     * Getter for withdrawal reason
     */
    public String getReason() {
        return reason; // Return the stated reason for withdrawal
    }

    /**
     * Setter for withdrawal reason
     */
    public void setReason(String reason) {
        this.reason = reason; // Set the withdrawal reason
    }

    /**
     * Getter for withdrawal status
     */
    public String getStatus() {
        return status; // Return the current transaction status
    }

    /**
     * Setter for withdrawal status (updated during processing)
     */
    public void setStatus(String status) {
        this.status = status; // Update the transaction status
    }

    /**
     * Getter for request timestamp
     */
    public LocalDateTime getRequestedAt() {
        return requestedAt; // Return when the withdrawal was requested
    }

    /**
     * Setter for request timestamp
     */
    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt; // Set the request timestamp
    }
}

