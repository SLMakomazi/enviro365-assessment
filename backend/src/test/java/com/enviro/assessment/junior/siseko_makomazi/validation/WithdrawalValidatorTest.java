package com.enviro.assessment.junior.siseko_makomazi.validation;

import com.enviro.assessment.junior.siseko_makomazi.dto.WithdrawalRequestDTO;
import com.enviro.assessment.junior.siseko_makomazi.exception.AgeRestrictionException;
import com.enviro.assessment.junior.siseko_makomazi.exception.InsufficientBalanceException;
import com.enviro.assessment.junior.siseko_makomazi.model.Investor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawalValidatorTest {

    private WithdrawalValidator validator;
    private Investor investor;
    private WithdrawalRequestDTO request;

    @BeforeEach
    void setUp() {
        validator = new WithdrawalValidator();
        investor = new Investor("John Doe", "john@example.com", 70, 10000.0);
        request = new WithdrawalRequestDTO(1L, 500.0, "Emergency");
    }

    @Test
    void validate_WithValidRequest_ShouldPass() {
        assertDoesNotThrow(() -> validator.validate(request, investor));
    }

    @Test
    void validate_WithZeroAmount_ShouldThrowException() {
        request.setAmount(0.0);
        assertThrows(InsufficientBalanceException.class, () -> validator.validate(request, investor));
    }

    @Test
    void validate_WithNegativeAmount_ShouldThrowException() {
        request.setAmount(-100.0);
        assertThrows(InsufficientBalanceException.class, () -> validator.validate(request, investor));
    }

    @Test
    void validate_WithMissingReason_ShouldThrowException() {
        request.setReason(null);
        assertThrows(IllegalArgumentException.class, () -> validator.validate(request, investor));
    }

    @Test
    void validate_WithBlankReason_ShouldThrowException() {
        request.setReason("   ");
        assertThrows(IllegalArgumentException.class, () -> validator.validate(request, investor));
    }

    @Test
    void validate_WithAmountExceedingBalance_ShouldThrowException() {
        request.setAmount(15000.0);
        assertThrows(InsufficientBalanceException.class, () -> validator.validate(request, investor));
    }

    @Test
    void validate_WithAmountExceeding90Percent_ShouldThrowException() {
        request.setAmount(9500.0);
        assertThrows(InsufficientBalanceException.class, () -> validator.validate(request, investor));
    }

    @Test
    void validate_WithInvestorUnder65_ShouldThrowException() {
        Investor youngInvestor = new Investor("Young Doe", "young@example.com", 55, 10000.0);
        assertThrows(AgeRestrictionException.class, () -> validator.validate(request, youngInvestor));
    }

    @Test
    void validate_WithInvestorExactly65_ShouldThrowException() {
        Investor investor65 = new Investor("Doe", "doe@example.com", 65, 10000.0);
        assertThrows(AgeRestrictionException.class, () -> validator.validate(request, investor65));
    }

    @Test
    void validate_WithInvestorOver65_ShouldPass() {
        Investor investor66 = new Investor("Doe", "doe@example.com", 66, 10000.0);
        assertDoesNotThrow(() -> validator.validate(request, investor66));
    }
}
