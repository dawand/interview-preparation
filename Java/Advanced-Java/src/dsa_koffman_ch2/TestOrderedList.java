package dsa_koffman_ch2;

import java.util.Random;

public class TestOrderedList {
    private static final int STAR_SIZE = 100;

    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();
        Random random = new Random();
        for (int i = 0; i < STAR_SIZE; i++) {
            int rand = random.nextInt(500);
//            System.out.println(rand);
            list.add(rand);
        }

        for (int n: list){
            System.out.println(n);
        }
    }
}
