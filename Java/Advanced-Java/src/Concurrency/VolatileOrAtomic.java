package Concurrency;

public class VolatileOrAtomic {

    boolean flag = false;

    Thread t1 = new Thread(new FlagUpdater());
    Thread t2 = new Thread(new FlagChecker());

    public static void main(String[] args) throws InterruptedException {

        VolatileOrAtomic v = new VolatileOrAtomic();

        v.t1.start();
        Thread.sleep(1000);

        System.out.println("in mean: " + v.flag);

        v.t2.start();
        Thread.sleep(1000);

//        v.flag = false;
        v.t1.join();
        System.out.println("in mean: " + v.flag);
    }

    private class FlagUpdater implements Runnable {
        @Override
        public void run() {
            System.out.println("in t1: " + flag);
            flag = true;
        }
    }

    private class FlagChecker implements Runnable {
        @Override
        public void run() {
            System.out.println("in t2: " + flag);
        }
    }
}
