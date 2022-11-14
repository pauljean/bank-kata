package com.pauljean.bankkata.dto;

public class UserDto {

    private long userId;
    private String name;
    private double amount;

    public UserDto(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public UserDto(long userId, String name, double amount) {
        this.userId = userId;
        this.name = name;
        this.amount = amount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
