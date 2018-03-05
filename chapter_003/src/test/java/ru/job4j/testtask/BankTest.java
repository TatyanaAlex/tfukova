package ru.job4j.testtask;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Class BankTest.
 */
public class BankTest {

    /**
     * Test method.
     */
    @Test
    public void whenGiveUserShouldAddUserInTheMap() {
        Bank bank = new Bank();
        User user = new User("Maxim", "ET 245367");
        bank.addUser(user);
        User resultUser = bank.users.get("ET 245367");
        assertEquals(user, resultUser);
    }
    /**
     * Test method.
     */
    @Test
    public void whenGiveUserShouldDeleteItFromMap() {
        Bank bank = new Bank();
        User user1 = new User("Maxim", "ET 245367");
        User user2 = new User("Alex", "ET 345367");
        bank.addUser(user1);
        bank.addUser(user2);

        bank.deleteUser(user1);
        assertFalse(bank.users.containsKey(user1.passport));
        assertTrue(bank.users.containsKey(user2.passport));
    }
    /**
     * Test Method.
     */
    @Test
    public void whenGiveUserAndAccountShouldAppendAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Maxim", "ET 245367");

        bank.addUser(user);
        Account userAccount = new Account(1000, "2460-9876");
        bank.addAccountToUser("ET 245367", userAccount);
        List<Account> resAcc = bank.usersAccounts.get(user);

        assertTrue(resAcc.contains(userAccount));
    }
    /**
     * Test Method.
     */
    @Test
    public void whenGiveUserAndAccountShouldDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user = new User("Maxim", "ET 245367");
        bank.addUser(user);

        Account account1 = new Account(1000, "123-765");
        Account account2 = new Account(2000, "987-568");

        bank.addAccountToUser("ET 245367", account1);
        bank.addAccountToUser("ET 245367", account2);
        bank.deleteAccountFromUser("ET 245367", account1);
        List<Account> resAcc = bank.usersAccounts.get(user);

        assertTrue(resAcc.contains(account2));
        assertFalse(resAcc.contains(account1));
    }
    /**
     * Test Method.
     */
    @Test
    public void whenGiveUserShouldReturnAllHisAccounts() {
        Bank bank = new Bank();
        User user = new User("Maxim", "ET 245367");
        bank.addUser(user);
        Account account1 = new Account(1000, "123-765");
        Account account2 = new Account(2000, "987-568");

        bank.addAccountToUser("ET 245367", account1);
        bank.addAccountToUser("ET 245367", account2);
        List<Account> accountList = new ArrayList<>();
        accountList.addAll(Arrays.asList(account1, account2));

        List<Account> resultAccList = bank.getUserAccounts("ET 245367");
        assertThat(resultAccList, is(accountList));
    }

    /**
     * Test Method.
     */
    @Test
    public void whenTransferMoneyShouldReturnResult() {
        Bank bank = new Bank();
        User user1 = new User("Maxim", "ET 245367");
        User user2 = new User("Alex", "ET 345367");
        bank.addUser(user1);
        bank.addUser(user2);

        Account maxAcc1 = new Account(1000, "123-765");
        Account maxAcc2 = new Account(2000, "987-568");
        Account alexAcc1 = new Account(4000, "198-935");
        Account alexAcc2 = new Account(2300, "909-786");

        bank.addAccountToUser("ET 245367", maxAcc1);
        bank.addAccountToUser("ET 245367", maxAcc2);
        bank.addAccountToUser("ET 345367", alexAcc1);
        bank.addAccountToUser("ET 345367", alexAcc2);

        boolean firstTransac = bank.transferMoney("ET 245367", "123-765", "ET 345367", "198-935", 500);
        boolean secondTransac = bank.transferMoney("ET 245367", "987-568", "ET 345367", "909-786", 5000);
        boolean thirdTransac = bank.transferMoney("ET 245367", "19823-765", "ET 345367", "909-786", 350);

        assertTrue(firstTransac);
        assertFalse(secondTransac);
        assertFalse(thirdTransac);


    }





}
