package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicReference<Integer> a = new AtomicReference<>(0);
        int b = 0;

//        Runnable T1 = () ->  {
//            System.out.println("hello from T1!");
//            for (int i = 0; i < 100; i++) {
//                a.updateAndGet(v -> v + 1);
//            }
//        };
//        T1.run();
//
//        Thread thread = new Thread();
//
//        thread.start();

        myThread T1 = new myThread();
        Thread.currentThread().setName("T1");
//        T1.run();

        myThread T2 = new myThread();
        Thread.currentThread().setName("T2");
//        T2.run();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(T1);
        executorService.submit(T2);
        executorService.shutdown();
    }
}

class myThread implements Runnable {

    int a = 0; // shared resource
//    int b = 0;

    @Override
    public void run() {
        System.out.println("hello from external class");

        for (int i = 0; i < 100; i++) {
            a += 1; // criticial section
//            b -= 1;
            System.out.println(Thread.currentThread().getName());
            System.out.println( "a: " + a);
        }

//        for (int i = 0; i < 10; i++) {
//            a -= 1;
//            b += 1;
//            System.out.println(Thread.currentThread().getName());
//            System.out.println( "a: " + a + " b: " + b);
//        }

    }

    @Override
    public String toString() {
        return "myThread{}";
    }
}
