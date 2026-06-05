/*
 * WithdrawalValidator.java
 * Business validation component for withdrawal requests.
 * Validates withdrawal amount, reason, and applies business rules.
 * Throws custom exceptions for validation failures.
 */
package com.enviro.assessment.junior.siseko_makomazi.validation; // Validation layer package

import org.springframework.stereotype.Component; // Component annotation

import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalRequestDTO; // Incoming withdrawal request
import com.enviro.assessment.junior.siseko_makomazi.exception.AgeRestrictionException; // Age restriction exception
import com.enviro.assessment.junior.siseko_makomazi.exception.InsufficientBalanceException; // Insufficient balance exception

@Component // Marks this as a Spring component for dependency injection
public class WithdrawalValidator {

    /**
     * Validates a withdrawal request against business rules
     * @param request The WithdrawalRequestDTO to validate
     * @throws InsufficientBalanceException if amount <= 0 or > 10000
     * @throws IllegalArgumentException if reason is missing or blank
     * @throws AgeRestrictionException if amount > 5000 (requires authorization)
     */
    public void validate(WithdrawalRequestDTO request) {
        // Rule 1: Amount must be positive
        if (request.getAmount() <= 0) { // Check if amount is zero or negative
            throw new InsufficientBalanceException("Withdrawal amount must be greater than zero."); // Throw error
        }
        
        // Rule 2: Amount cannot exceed daily/transaction limit of 10000
        if (request.getAmount() > 10000) { // Check if amount exceeds maximum limit
            throw new InsufficientBalanceException("Requested amount exceeds the available balance."); // Throw error
        }
        
        // Rule 3: Withdrawal reason is required
        if (request.getReason() == null || request.getReason().isBlank()) { // Check if reason is missing or empty
            throw new IllegalArgumentException("Withdrawal reason is required."); // Throw error
        }
        
        // Rule 4: Large withdrawals (> 5000) require additional authorization
        if (request.getAmount() > 5000) { // Check if amount exceeds authorization threshold
            throw new AgeRestrictionException("Withdrawals above 5000 require additional authorization."); // Throw error
        }
    }
}

