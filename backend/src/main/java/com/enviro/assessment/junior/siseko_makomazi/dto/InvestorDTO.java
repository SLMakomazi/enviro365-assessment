package com.enviro.assessment.junior.siseko_makomazi.dto;

public class InvestorDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final int age;
    private final double balance;

    public InvestorDTO(Long id, String name, String email, int age, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }
}

