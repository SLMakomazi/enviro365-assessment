package com.enviro.assessment.junior.siseko_makomazi.validation;

import org.springframework.stereotype.Component;

import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalRequestDTO;
import com.enviro.assessment.junior.siseko_makomazi.exception.AgeRestrictionException;
import com.enviro.assessment.junior.siseko_makomazi.exception.InsufficientBalanceException;

@Component
public class WithdrawalValidator {

    public void validate(WithdrawalRequestDTO request) {
        if (request.getAmount() <= 0) {
            throw new InsufficientBalanceException("Withdrawal amount must be greater than zero.");
        }
        if (request.getAmount() > 10000) {
            throw new InsufficientBalanceException("Requested amount exceeds the available balance.");
        }
        if (request.getReason() == null || request.getReason().isBlank()) {
            throw new IllegalArgumentException("Withdrawal reason is required.");
        }
        if (request.getAmount() > 5000) {
            throw new AgeRestrictionException("Withdrawals above 5000 require additional authorization.");
        }
    }
}

