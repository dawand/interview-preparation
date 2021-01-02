package Concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyRunnableMain {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable);

        thread.start();

        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "interrupted", e);
            Thread.currentThread().interrupt();
        }

        myRunnable.doStop();

    }
}
