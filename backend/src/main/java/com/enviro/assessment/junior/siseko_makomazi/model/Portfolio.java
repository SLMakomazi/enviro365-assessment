package com.enviro.assessment.junior.siseko_makomazi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double totalValue;

    public Portfolio() {
    }

    public Portfolio(String name, double totalValue) {
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

