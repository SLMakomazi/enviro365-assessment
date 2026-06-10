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
import com.enviro.assessment.junior.siseko_makomazi.model.Investor; // Investor entity

@Component // Marks this as a Spring component for dependency injection
public class WithdrawalValidator {

    /**
     * Validates a withdrawal request against business rules
     * @param request The WithdrawalRequestDTO to validate
     * @param investor The investor making the withdrawal
     * @throws InsufficientBalanceException if amount <= 0, exceeds balance, or exceeds 90% limit
     * @throws IllegalArgumentException if reason is missing or blank
     * @throws AgeRestrictionException if investor age <= 65 for retirement withdrawals
     */
    public void validate(WithdrawalRequestDTO request, Investor investor) {
        // Rule 1: Amount must be positive
        if (request.getAmount() <= 0) {
            throw new InsufficientBalanceException("Withdrawal amount must be greater than zero.");
        }
        
        // Rule 2: Withdrawal reason is required
        if (request.getReason() == null || request.getReason().isBlank()) {
            throw new IllegalArgumentException("Withdrawal reason is required.");
        }
        
        // Rule 3: Withdrawal must not exceed available balance
        if (request.getAmount() > investor.getBalance()) {
            throw new InsufficientBalanceException("Withdrawal amount exceeds available balance.");
        }
        
        // Rule 4: Withdrawal must not exceed 90% of balance
        double maxWithdrawal = investor.getBalance() * 0.9;
        if (request.getAmount() > maxWithdrawal) {
            throw new InsufficientBalanceException("Withdrawal amount cannot exceed 90% of available balance.");
        }
        
        // Rule 5: Retirement withdrawals only allowed if age > 65
        if (investor.getAge() <= 65) {
            throw new AgeRestrictionException("Retirement withdrawals are only allowed for investors over 65 years of age.");
        }
    }
}

