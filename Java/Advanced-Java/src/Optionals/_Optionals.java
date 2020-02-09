package Optionals;

import java.util.Optional;

public class _Optionals {

    public static void main(String[] args) {

        Optional<String> dan = Optional.ofNullable("Dan");
        dan.ifPresentOrElse(System.out::println,
                                () -> System.out.println("could not find value"));
    }
}
