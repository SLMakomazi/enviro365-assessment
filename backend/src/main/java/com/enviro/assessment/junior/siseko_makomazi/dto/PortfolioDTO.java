package com.enviro.assessment.junior.siseko_makomazi.dto;

public class PortfolioDTO {

    private final Long id;
    private final String name;
    private final double totalValue;

    public PortfolioDTO(Long id, String name, double totalValue) {
        this.id = id;
        this.name = name;
        this.totalValue = totalValue;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTotalValue() {
        return totalValue;
    }
}

