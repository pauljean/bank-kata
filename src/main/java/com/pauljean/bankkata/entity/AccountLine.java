package com.pauljean.bankkata.entity;

import com.pauljean.bankkata.constant.OperationEnum;

import java.time.LocalDateTime;


public class AccountLine {

    private OperationEnum operationEnum;
    private LocalDateTime localDateTime;
    private double amount;
    private double balance;
    private long transactionNumber;

    public OperationEnum getOperationEnum() {
        return operationEnum;
    }

    public void setOperationEnum(OperationEnum operationEnum) {
        this.operationEnum = operationEnum;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String toString() {
        return operationEnum.name() + " | " + localDateTime + " | " + amount + " | " + balance;
    }

}
