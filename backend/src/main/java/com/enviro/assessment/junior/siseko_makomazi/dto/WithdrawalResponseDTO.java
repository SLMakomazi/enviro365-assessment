/*
 * WithdrawalResponseDTO.java
 * Data Transfer Object (DTO) for withdrawal responses.
 * Used for API responses to transfer withdrawal information to clients.
 * Immutable: all fields are final and set via constructor only.
 */
package com.enviro.assessment.junior.siseko_makomazi.dto; // DTO layer package

/**
 * WithdrawalResponseDTO represents withdrawal information returned to API clients.
 * Uses immutable pattern (final fields) to prevent accidental modification.
 */
public class WithdrawalResponseDTO {

    private final Long id; // Unique withdrawal transaction ID (immutable)
    private final double amount; // Withdrawal amount (immutable)
    private final String status; // Current status (Pending/Approved/Rejected/Completed) (immutable)
    private final String requestedAt; // Timestamp of request as string (immutable)

    /**
     * Constructor to create WithdrawalResponseDTO with all fields
     * @param id Unique withdrawal transaction ID
     * @param amount Withdrawal amount
     * @param status Current status of the withdrawal
     * @param requestedAt Timestamp when withdrawal was requested
     */
    public WithdrawalResponseDTO(Long id, double amount, String status, String requestedAt) {
        this.id = id; // Set immutable ID
        this.amount = amount; // Set immutable amount
        this.status = status; // Set immutable status
        this.requestedAt = requestedAt; // Set immutable requestedAt
    }

    /**
     * Getter for withdrawal transaction ID
     * @return Unique withdrawal identifier
     */
    public Long getId() {
        return id; // Return immutable ID
    }

    /**
     * Getter for withdrawal amount
     * @return Withdrawal amount
     */
    public double getAmount() {
        return amount; // Return immutable amount
    }

    /**
     * Getter for withdrawal status
     * @return Current status of withdrawal
     */
    public String getStatus() {
        return status; // Return immutable status
    }

    /**
     * Getter for request timestamp
     * @return Timestamp when withdrawal was requested
     */
    public String getRequestedAt() {
        return requestedAt; // Return immutable requestedAt
    }
}

