package Concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {

    }
}

class Producer implements Runnable{
    List<String> queue = new LinkedList<>();



    @Override
    public void run() {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

            String product = "product - " + new Random().nextInt(1000);
            queue.add(product);
            queue.notify();
        }
    }
}

class Consumer {

}
