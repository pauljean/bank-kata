package com.pauljean.bankkata.builder;

import com.pauljean.bankkata.dto.AccountDto;
import com.pauljean.bankkata.dto.StatementDto;
import com.pauljean.bankkata.dto.UserDto;

import java.util.Objects;
import java.util.Scanner;

public class BankBuilder {

    private Scanner scanner;

    private static BankBuilder bankBuilder;

    private BankBuilder() {
        this.scanner = new Scanner(System.in);
    }

    public static BankBuilder getInstance() {

        if (Objects.isNull(bankBuilder)) {

            bankBuilder = new BankBuilder();

        }
        return bankBuilder;
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public UserDto createUser() {

        System.out.println("Create User");

        System.out.print("Name : ");
        String name = scanner.next();

        System.out.print("Amount : ");
        double amount = scanner.nextDouble();

        return new UserDto(name, amount);

    }

    public int OperationChoice() {

        System.out.println("select one choice");
        System.out.println(" [1] create new user");
        System.out.println(" [2] deposit");
        System.out.println(" [3] withdrawal");
        System.out.println(" [4] printing statement");
        System.out.println(" [5] exit");

        System.out.print("Your choice : ");
        int choice = scanner.nextInt();

        return choice;
    }

    public AccountDto deposit() {

        System.out.println("You selected deposit !");

        System.out.print("Enter userId : ");
        long userId = scanner.nextLong();

        System.out.print("Amount : ");
        double amount = scanner.nextDouble();

        return new AccountDto(userId, amount);
    }

    public AccountDto withdrawal() {

        System.out.println("You selected withdrawal !");

        System.out.print("Enter userId : ");
        long userId = scanner.nextLong();

        System.out.print("Amount : ");
        double amount = scanner.nextDouble();

        return new AccountDto(userId, amount);

    }

    public StatementDto printStatement() {

        System.out.println("You selected printStatement !");
        System.out.print("Enter userId : ");
        long userId = scanner.nextLong();

        System.out.print("number of last transaction : ");
        int index = scanner.nextInt();

        return new StatementDto(userId, index);
    }
}
