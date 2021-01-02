package Callbacks;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Lambdas {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            if (name.isBlank()) throw new IllegalArgumentException((""));
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("Dawand", 34));
    }

    static class Service {
        public Consumer<String> blah = System.out::println;
    }
}