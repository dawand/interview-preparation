package java8_features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        System.out.println("printing all numbers");
        eval(list, n -> true);
        // list.forEach(System.out::println);

        System.out.println("printing even numbers");
        eval(list, n -> n % 2 == 0);

        System.out.println("printing greater than 3 numbers");
        eval(list, n -> n > 3);
    }

    private static void eval(List<Integer> list, Predicate<Integer> o) {
        for (Integer n: list) {
            if (o.test(n))
                System.out.println(n + " ");
        }
    }
}
