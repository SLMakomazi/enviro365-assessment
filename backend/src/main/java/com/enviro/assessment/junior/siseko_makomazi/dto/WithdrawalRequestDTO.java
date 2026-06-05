package com.enviro.assessment.junior.siseko_makomazi.dto;

public class WithdrawalRequestDTO {

    private double amount;
    private String reason;

    public WithdrawalRequestDTO() {
    }

    public WithdrawalRequestDTO(double amount, String reason) {
        this.amount = amount;
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

