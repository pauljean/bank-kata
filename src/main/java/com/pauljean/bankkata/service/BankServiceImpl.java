package com.pauljean.bankkata.service;

import com.pauljean.bankkata.dao.UserRepository;
import com.pauljean.bankkata.dto.AccountDto;
import com.pauljean.bankkata.entity.AccountImpl;
import com.pauljean.bankkata.entity.AccountLine;
import com.pauljean.bankkata.entity.User;
import com.pauljean.bankkata.util.BankUtil;

import java.util.List;
import java.util.Objects;

public class BankServiceImpl {

    private UserRepository userRepository = UserRepository.getInstance();

    private static BankServiceImpl bankServiceImpl;


    private BankServiceImpl() {
    }

    public static BankServiceImpl getInstance() {

        if (Objects.isNull(bankServiceImpl)) {
            bankServiceImpl = new BankServiceImpl();
            return bankServiceImpl;
        }
        return bankServiceImpl;
    }


    public AccountDto createUser(String name, double amount) {

        AccountImpl account = new AccountImpl();
        long transactionId = account.deposit(amount);
        User user = new User();
        user.setUserId(++BankUtil.USER_ID);
        user.setName(name);
        user.setAccount(account);
        userRepository.create(user);

        return new AccountDto(user.getUserId(), transactionId, amount);
    }


    public AccountDto deposit(long userId, double amount) {

        if (BankUtil.checkPositive(amount)) {
            User user = userRepository.findbyUserId(userId);
            long transactionId = user.getAccount().deposit(amount);

            return new AccountDto(user.getUserId(), transactionId, amount);
        } else {
            throw new RuntimeException("amount must be positive or greater than 0");
        }

    }


    public AccountDto withdrawal(long userId, double amount) {

        if (BankUtil.checkPositive(amount)) {
            User user = userRepository.findbyUserId(userId);
            long transactionId = user.getAccount().withdrawal(amount);

            return new AccountDto(user.getUserId(), transactionId, amount);
        } else {
            throw new RuntimeException("amount must be positive or greater than 0");
        }

    }

    public List<AccountLine> accountStatement(long userId, int index) {

        if (BankUtil.checkPositive(index)) {
            User user = userRepository.findbyUserId(userId);
            List<AccountLine> accountLines = user.getAccount().accountStatement(index);

            printStatement(accountLines);

            return accountLines;
        } else {
            throw new RuntimeException("index must be positive or greater than 0");
        }

    }

    public void printStatement(List<AccountLine> accountLines) {
        System.out.println(BankUtil.STATEMENT_HEADER);
        accountLines.forEach(accountLine -> {
            System.out.println(accountLine);
        });

    }

    public User findUserById(long userId){
        return userRepository.findbyUserId(userId);
    }

    public boolean checkUserExist() {

        return userRepository.checkUserExist();
    }
}
