package com.pauljean.bankkata.service.tdd;

import com.pauljean.bankkata.dao.UserRepository;
import com.pauljean.bankkata.entity.AccountImpl;
import com.pauljean.bankkata.entity.User;
import com.pauljean.bankkata.service.BankServiceImpl;
import com.pauljean.bankkata.util.BankUtil;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankServiceImplTest {

    private UserRepository userRepository;
    private BankServiceImpl bankServiceImpl;

    protected User user;
    protected AccountImpl account;


    @BeforeAll
    public void init() {

        userRepository = UserRepository.getInstance();
        bankServiceImpl = BankServiceImpl.getInstance();

        account = new AccountImpl();

        user = new User();
        user.setUserId(++BankUtil.USER_ID);
        user.setName("DONGMO");
        user.setAccount(account);

        userRepository.create(user);

    }

    @Test
    @Order(1)
    void deposit() {

        bankServiceImpl.deposit(BankUtil.USER_ID, 2000);

        double amount = user.getAccount().getBalance();
        Assertions.assertEquals(2000, amount);
    }

    @Test
    @Order(2)
    void withdrawal() {

        bankServiceImpl.withdrawal(BankUtil.USER_ID, 500);
        double amount = user.getAccount().getBalance();
        Assertions.assertEquals(1500, amount);

    }

    @Test
    @Order(3)
    void accountStatement() {

        bankServiceImpl.accountStatement(BankUtil.USER_ID, 2);
    }

}