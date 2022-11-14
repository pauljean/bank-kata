package com.pauljean.bankkata;


import com.pauljean.bankkata.builder.BankBuilder;
import com.pauljean.bankkata.dto.AccountDto;
import com.pauljean.bankkata.dto.StatementDto;
import com.pauljean.bankkata.dto.UserDto;
import com.pauljean.bankkata.service.BankServiceImpl;

import java.util.Scanner;

public class BankKataApplication {

    private static BankBuilder bankBuilder = BankBuilder.getInstance();
    private static BankServiceImpl bankService = BankServiceImpl.getInstance();

    public static void main(String[] args) {

        try {

            System.out.println("Welcome to Bank-kata !");

            if (bankService.checkUserExist()) {

                UserDto userDto = bankBuilder.createUser();
                AccountDto accountDto = bankService.createUser(userDto.getName(), userDto.getAmount());

                System.out.println(accountDto);

            } else {

                AccountDto accountDto;
                int choice = bankBuilder.OperationChoice();

                switch (choice) {

                    case 1:
                        UserDto userDto = bankBuilder.createUser();
                        accountDto = bankService.createUser(userDto.getName(), userDto.getAmount());
                        System.out.println(accountDto);
                        break;
                    case 2:
                        AccountDto depositDto = bankBuilder.deposit();
                        accountDto = bankService.deposit(depositDto.getUserId(), depositDto.getAmount());
                        System.out.println(accountDto);
                        break;
                    case 3:
                        AccountDto withdrawalDto = bankBuilder.withdrawal();
                        accountDto = bankService.withdrawal(withdrawalDto.getUserId(), withdrawalDto.getAmount());
                        System.out.println(accountDto);
                        break;
                    case 4:

                        StatementDto statementDto = bankBuilder.printStatement();
                        bankService.accountStatement(statementDto.getUserId(), statementDto.getIndex());
                        break;
                    case 5:
                        System.out.println("Goodbye !");
                        System.exit(0);
                    default:
                        throw new IllegalArgumentException("Unknown choice " + choice);
                }
            }
        } catch (Exception e) {

            System.err.println("Error : " + e);

        }

        main(null);

    }


}
