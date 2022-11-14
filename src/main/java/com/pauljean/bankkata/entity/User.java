package com.pauljean.bankkata.entity;

public class User {

    private long userId;
    private String name;
    private AccountImpl account;

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

    public AccountImpl getAccount() {
        return account;
    }

    public void setAccount(AccountImpl account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "userId= " + userId +
                "balance= " + account.getBalance()
                ;
    }
}

