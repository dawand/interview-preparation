package Concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    int count = 0;
    int MAX_COUNT = 100;

    Lock lock = new ReentrantLock();
    Condition added = lock.newCondition();
    Condition removed = lock.newCondition();

    public void produce() {
        lock.lock();

        try {
            while (count == MAX_COUNT)
                removed.await();

            addData();
            added.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();

        try {
            while (count == 0)
                added.await();

            String data = getData();
            System.out.println(data);

            removed.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private String getData() {
        count--;
        return "consumed data";
    }

    private void addData() {
        System.out.println("Adding data called");
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionExample example = new ConditionExample();

        for (int i = 0; i < 10; i++) {
            new Thread(example::produce).start();
            new Thread(example::consume).start();
        }
    }
}