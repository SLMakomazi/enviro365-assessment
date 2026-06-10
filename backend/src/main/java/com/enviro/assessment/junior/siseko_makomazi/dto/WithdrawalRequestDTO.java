/*
 * WithdrawalRequestDTO.java
 * Data Transfer Object (DTO) for incoming withdrawal requests.
 * Used to receive withdrawal information from API clients.
 * Mutable: allows deserialization from JSON request bodies.
 */
package com.enviro.assessment.junior.siseko_makomazi.dto; // DTO layer package

/**
 * WithdrawalRequestDTO represents withdrawal request information from API clients.
 * Uses mutable pattern to support JSON deserialization from request bodies.
 */
public class WithdrawalRequestDTO {

    private Long investorId; // Investor ID making the withdrawal (mutable for deserialization)
    private double amount; // Withdrawal amount requested (mutable for deserialization)
    private String reason; // Reason for withdrawal (mutable for deserialization)

    /**
     * No-argument constructor required for JSON deserialization
     * (e.g., when Spring converts JSON request body to this DTO)
     */
    public WithdrawalRequestDTO() {
    }

    /**
     * Constructor to create WithdrawalRequestDTO with all fields
     * @param investorId ID of the investor making the withdrawal
     * @param amount Amount to withdraw
     * @param reason Reason for the withdrawal
     */
    public WithdrawalRequestDTO(Long investorId, double amount, String reason) {
        this.investorId = investorId; // Set investor ID
        this.amount = amount; // Set withdrawal amount
        this.reason = reason; // Set withdrawal reason
    }

    /**
     * Getter for investor ID
     * @return ID of the investor
     */
    public Long getInvestorId() {
        return investorId; // Return investor ID
    }

    /**
     * Setter for investor ID
     * @param investorId The investor ID
     */
    public void setInvestorId(Long investorId) {
        this.investorId = investorId; // Update investor ID
    }

    /**
     * Getter for withdrawal amount
     * @return Requested withdrawal amount
     */
    public double getAmount() {
        return amount; // Return withdrawal amount
    }

    /**
     * Setter for withdrawal amount
     * @param amount The amount to withdraw
     */
    public void setAmount(double amount) {
        this.amount = amount; // Update withdrawal amount
    }

    /**
     * Getter for withdrawal reason
     * @return Stated reason for withdrawal
     */
    public String getReason() {
        return reason; // Return withdrawal reason
    }

    /**
     * Setter for withdrawal reason
     * @param reason The reason for withdrawal
     */
    public void setReason(String reason) {
        this.reason = reason; // Update withdrawal reason
    }
}

