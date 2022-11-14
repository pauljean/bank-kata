Feature: Think of your personal bank account experience

  Background:
    Given As a bank client: enter <name> and initialAmount <amount>
      | 1001 | 1000   |
      | 1002 | 500    |

  Scenario Outline: deposit
    When I want to make a deposit in my account: enter your userId <userId> and amount <amount>
    Then add deposit amount on user account : balance become <balance>
    Examples:
      | userId | amount | balance |
      | 1001   | 900    | 1900    |
      | 1002   | 800    | 1300    |


  Scenario Outline: withdrawal
    When I want to make a withdrawal from my account: enter your userId <userId> and amount <amount>
    Then retrieve amount on user account : balance become <balance>
    Examples:
      | userId | amount | balance |
      | 1001   | 400    | 1500    |
      | 1002   | 500    | 800     |


  Scenario Outline: accountStatement
    When I want to see the history (operation, date, amount, balance) of my operations: enter your userId <userId> and index <index>
    Then print last n operations : <size>
    Examples:
      | userId | index | size |
      | 1001   | 6     | 3    |
      | 1002   | 2     | 2    |