package com.enviro.assessment.junior.siseko_makomazi.dto;

public class WithdrawalResponseDTO {

    private final Long id;
    private final double amount;
    private final String status;
    private final String requestedAt;

    public WithdrawalResponseDTO(Long id, double amount, String status, String requestedAt) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.requestedAt = requestedAt;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getRequestedAt() {
        return requestedAt;
    }
}

