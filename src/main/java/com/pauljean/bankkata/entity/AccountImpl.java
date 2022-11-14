package com.pauljean.bankkata.entity;

import com.pauljean.bankkata.constant.OperationEnum;
import com.pauljean.bankkata.util.BankUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AccountImpl implements Account {

    private double balance;
    private List<AccountLine> accountLines = new ArrayList<>();


    public double getBalance() {
        return balance;
    }


    public List<AccountLine> getAccountLines() {
        return accountLines;
    }

    public void setAccountLines(List<AccountLine> accountLines) {
        this.accountLines = accountLines;
    }

    /**
     * synchronized keyword allows to avoid concurrent access
     * @param amount
     * @return
     */
    @Override
    public synchronized long deposit(double amount) {

        this.balance += amount;
        AccountLine accountLine = createAccountLine(this.balance, amount, OperationEnum.DEPOSIT);
        accountLines.add(accountLine);

        return accountLine.getTransactionNumber();

    }

    /**
     * synchronized keyword allows to avoid concurrent access
     * @param amount
     * @return
     */
    @Override
    public synchronized long withdrawal(double amount) {

        if (this.balance > amount) {
            this.balance -= amount;
            AccountLine accountLine = createAccountLine(this.balance, -amount, OperationEnum.WITHDRAWAL);
            accountLines.add(accountLine);

            return accountLine.getTransactionNumber();
        } else {
            throw new RuntimeException("opertion is not possible");
        }
    }

    /**
     * this method return the n last operations
     * @param index
     * @return
     */
    @Override
    public List<AccountLine> accountStatement(int index) {

        if (this.accountLines.size() < index) {
            index = this.accountLines.size();
        }

        this.accountLines.sort(Comparator.comparing(AccountLine::getLocalDateTime));
        Collections.reverse(this.accountLines);

        return this.accountLines.subList(0, index);

    }


    private AccountLine createAccountLine(double balance, double amount, OperationEnum operationEnum) {

        long transactionNumber = BankUtil.random();
        AccountLine accountLine = new AccountLine();
        accountLine.setAmount(amount);
        accountLine.setBalance(balance);
        accountLine.setLocalDateTime(LocalDateTime.now());
        accountLine.setOperationEnum(operationEnum);
        accountLine.setTransactionNumber(transactionNumber);

        return accountLine;

    }

}
