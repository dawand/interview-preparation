package Concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CancelThread {
    public static void main(String[] args) throws InterruptedException {
        RandomList randomList = new RandomList();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(randomList);
        }

        Thread.sleep(1000);
        randomList.cancel();

        System.out.println(randomList.getRandoms());
        System.out.println(randomList.getCount());

        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}

class RandomList implements Runnable {

    private volatile boolean cancelled;
    private AtomicInteger count = new AtomicInteger();
    private final List<Integer> randoms = new CopyOnWriteArrayList<>();
    private final Random rnd = new Random();

    @Override
    public void run() {
        while (!cancelled) {
            randoms.add(rnd.nextInt(100));
            count.addAndGet(1);
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public List<Integer> getRandoms() {
        return randoms;
    }

    public AtomicInteger getCount() {
        return count;
    }
}
