package ru.job4j.synchronize;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserStorageTest.
 */
public class UserStorageTest {

    private class ThreadTransfer extends Thread {

        private final UserStorage userStorage;

        private ThreadTransfer(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            this.userStorage.transfer(1, 2, 30);
        }
    }

    /**
     * Test Method.
     */
    @Test
    public void whenTransferMoneyThenItTransferred() throws InterruptedException {

        UserStorage userStorage = new UserStorage();
        User userFirst = new User(1, 100);
        User userSecond = new User(2, 500);

        userStorage.add(userFirst);
        userStorage.add(userSecond);

        ThreadTransfer threadTransfer = new ThreadTransfer(userStorage);
        ThreadTransfer thr = new ThreadTransfer(userStorage);

        threadTransfer.start();
        thr.start();

        threadTransfer.join();
        thr.join();

        assertThat(userStorage.getUser(1).getAmount(), is(40));
        assertThat(userStorage.getUser(2).getAmount(), is(560));


    }

}
