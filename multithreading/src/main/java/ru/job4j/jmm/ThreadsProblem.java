package ru.job4j.jmm;

/**
 * Class ThreadsProblem.
 */
public class ThreadsProblem {

    public static void main(String[] args) {

        Counter counter = new Counter();

        for (int i = 0; i < 200; i++) {
            CounterInThread ct = new CounterInThread(counter);
            ct.start();

        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter.getCounter());
    }


}

/**
 * Class Counter shared object.
 */
class Counter {

    private long counter = 0L;

    public long getCounter() {
        return counter;
    }

    public void increseCounter() {
        counter++;
    }
}

/**
 * Class CounterInThread.
 * Thread increases counter for 1.
 */
class CounterInThread extends Thread {

    private Counter counter;

    public CounterInThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increseCounter();
        }
    }
}