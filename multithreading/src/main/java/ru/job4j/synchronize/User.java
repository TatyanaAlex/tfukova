package ru.job4j.synchronize;

import net.jcip.annotations.GuardedBy;

/**
 * Class User.
 */
public class User {

    /**
     * user`s id.
     */
    private int id;

    /**
     * user`s amount.
     */
    @GuardedBy("this")
    private int amount;

    /**
     * constructor.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
