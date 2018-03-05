package ru.job4j.testtask;

/**
 * Class Account.
 */
public class Account {

    public double value;
    public String requisites;

    /**
     * Constructor.
     * @param value amount of the money.
     * @param requisites user's account.
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (value != account.value) {
            return false;
        }
        return requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result + requisites.hashCode();
        return result;
    }
}
