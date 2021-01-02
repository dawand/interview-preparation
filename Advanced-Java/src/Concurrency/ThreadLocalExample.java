package Concurrency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadSafeFormatter {
    public static ThreadLocal<DateTimeFormatter> df = ThreadLocal.withInitial(() ->
            DateTimeFormatter.ofPattern("dd LLLL yyyy"));
}

public class ThreadLocalExample {

    static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {

            threadPool.submit(() -> {
                String td1 = birthDate(1);
                System.out.println(td1);
            });
        }

//        new Thread(() -> {
//            String td2 = birthDate(2);
//            System.out.println(td2);
//        }).start();

        Thread.sleep(1000);
    }

    public static String birthDate(int userId) {
        LocalDate birthDate = birthDateFromDB(userId);
        DateTimeFormatter formatter = ThreadSafeFormatter.df.get();
        return birthDate.format(formatter);
    }

    private static LocalDate birthDateFromDB(int userId) {
        LocalDate d1 = LocalDate.of(1986, 1, 8);
        LocalDate d2 = LocalDate.of(1988, 2, 8);

        return (userId == 1) ? d1 : d2;
    }
}
