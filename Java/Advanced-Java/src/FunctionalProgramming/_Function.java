package FunctionalProgramming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOne.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTen.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyByTen =
                incrementByOne.andThen(multiplyByTen);

        System.out.println(addBy1AndThenMultiplyByTen.apply(4));

        BiFunction<Integer, Integer, Integer> addAndMultiply =
                (num1, num2) -> (num1 + 1) * num2;

        System.out.println(addAndMultiply.apply(1,4));
    }

    static Function<Integer, Integer> incrementByOne = number -> number + 1;
    static Function<Integer, Integer> multiplyByTen = number -> number * 10;

    private static int incrementByOne(int i) {
        return i + 1;
    }
}
