package Concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionDemo{
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Counter implements Runnable{
    private int c = 0;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " " + lock.getHoldCount());
        try {
            //…method body
//        synchronized(this) {
            //incrementing
            this.increment();
            System.out.println("Value for Thread After increment "
                    + Thread.currentThread().getName() + " " + this.getValue());
            //decrementing
            this.decrement();
            System.out.println("Value for Thread at last "
                    + Thread.currentThread().getName() + " " + this.getValue());
//        }
        } finally {
            lock.unlock();
        }
    }

    public void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c++;
    }

    public void decrement() {
        c--;
    }

    public int getValue() {
        return c;
    }
}