package com.pauljean.bankkata.dto;

public class AccountDto {

    private long userId;
    private double amount;
    private long transactionId;

    public AccountDto(long userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public AccountDto(long userId, long transactionNumber, double amount) {
        this.userId = userId;
        this.amount = amount;
        this.transactionId = transactionNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }


    @Override
    public String toString() {
        return "AccountDto{" +
                "userId =" + String.valueOf(userId) +
                ", transactionId = " + String.valueOf(transactionId) +
                '}';
    }
}
