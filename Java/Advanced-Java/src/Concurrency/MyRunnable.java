package Concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyRunnable implements Runnable {

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = false;
    }

    public synchronized boolean keepRunning(){
        return !this.doStop;
    }

    @Override
    public void run() {
        while (keepRunning()) {
            Logger.getAnonymousLogger().log(Level.ALL, "Running");
            System.out.println("Running");

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Logger.getAnonymousLogger().log(Level.WARNING, "Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        }

    }
}
