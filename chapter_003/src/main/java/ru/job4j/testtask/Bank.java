package ru.job4j.testtask;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class Bank.
 */
public class Bank {

    Map<User, List<Account>> usersAccounts = new HashMap<>();
    Map<String, User> users = new HashMap<>();
    /**
     * Method to add user to the Bank.
     * @param user user.
     */
    public void addUser(User user) {
        users.put(user.passport, user);
    }

    /**
     * Method to delete user from the Bank.
     * @param user user.
     */
    public void deleteUser(User user) {
        users.remove(user.passport);

    }
    /**
     * Mathod to add account for user.
     * @param passport user's passport.
     * @param account account.
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> tempAccList = getUserAccounts(passport);
        if (tempAccList == null) {
            tempAccList = new LinkedList<>();
        }
        tempAccList.add(account);
        usersAccounts.put(users.get(passport), tempAccList);
    }

    /**
     * Mathod to get list of user's accounts.
     * @param passport user's passport.
     */
    public List<Account> getUserAccounts(String passport) {
        return usersAccounts.get(users.get(passport));
    }

    /**
     * Mathod to delete one of the user's accounts.
     * @param passport user's passport.
     * @param account user's account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        getUserAccounts(passport).remove(account);
    }

    /**
     * Method to transfer money from one account to another.
     * @param srcPassport user from whose account the transfer is made.
     * @param srcRequisite account from which the transfer is made.
     * @param destPassport user to whom to transfer the money.
     * @param dstRequisite account to which the transfer is made.
     * @param amount amount of money.
     * @return transfertOk the success of transfer.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        List<Account> tempList = getUserAccounts(srcPassport);
        boolean tranfertOk = false;
        for (Account account : tempList) {
            if (account.requisites.equals(srcRequisite) && account.value >= amount) {
                List<Account> tempDestList = getUserAccounts(destPassport);
                for (Account destAccount : tempDestList) {
                    if (destAccount.requisites.equals(dstRequisite)) {
                        account.value = account.value - amount;
                        destAccount.value = destAccount.value + amount;
                        tranfertOk = true;
                    }
                }
            }
        }
        return tranfertOk;
    }


}
