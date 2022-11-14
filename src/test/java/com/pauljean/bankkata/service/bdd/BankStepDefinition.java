package com.pauljean.bankkata.service.bdd;

import com.pauljean.bankkata.dto.AccountDto;
import com.pauljean.bankkata.dto.StatementDto;
import com.pauljean.bankkata.entity.AccountLine;
import com.pauljean.bankkata.entity.User;
import com.pauljean.bankkata.service.BankServiceImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.awt.print.Book;
import java.util.List;

public class BankStepDefinition {

    private BankServiceImpl bankService = BankServiceImpl.getInstance();
    private AccountDto accountDto;
    private StatementDto statementDto;

    @Given("As a bank client: enter <name> and initialAmount <amount>")
    public void as_a_bank_client(DataTable dataTable) {

        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> columns : rows) {
            System.out.println(columns);

            accountDto = bankService.createUser(columns.get(0), Double.valueOf(columns.get(1)));
        }
    }

    @When("I want to make a deposit in my account: enter your userId {long} and amount {double}")
    public void i_want_to_make_a_deposit_in_my_account(long userId, double amount) {
        accountDto = new AccountDto(userId, amount);

    }

    @Then("add deposit amount on user account : balance become {double}")
    public void add_deposit_amount_on_user_account(double balance) {

        accountDto = bankService.deposit(accountDto.getUserId(), accountDto.getAmount());
        User user = bankService.findUserById(accountDto.getUserId());

        Assertions.assertEquals(balance, user.getAccount().getBalance());

    }


    @When("I want to make a withdrawal from my account: enter your userId {long} and amount {double}")
    public void i_want_to_make_a_withdrawal_from_my_account(long userId, double amount) {

        accountDto = new AccountDto(userId, amount);
    }

    @Then("retrieve amount on user account : balance become {double}")
    public void retrieve_amount_on_user_account(double balance) {

        accountDto = bankService.withdrawal(accountDto.getUserId(), accountDto.getAmount());
        User user = bankService.findUserById(accountDto.getUserId());

        Assertions.assertEquals(balance, user.getAccount().getBalance());
    }


    @When("I want to see the history \\(operation, date, amount, balance) of my operations: enter your userId {long} and index {int}")
    public void i_want_to_see_the_history_operation_date_amount_balance_of_my_operations(long userId, int index) {

        statementDto = new StatementDto(userId, index);
    }

    @Then("print last n operations : {int}")
    public void print_last_n_operations(int size) {

        List<AccountLine> accountLines = bankService.accountStatement(statementDto.getUserId(), statementDto.getIndex());

        Assertions.assertEquals(size, accountLines.size());
    }
}
