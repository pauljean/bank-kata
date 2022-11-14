package com.pauljean.bankkata.entity;

import java.util.List;

public interface Account {

    public long deposit(double amount);

    public long withdrawal(double amount);

    public List<AccountLine> accountStatement(int index);

}
