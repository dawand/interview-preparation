package java8_features;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("papa", "3ewlew", "", "oops", "", "hell");
        // filter
        System.out.println(names.stream()
                .filter(name -> !name.isEmpty())
                .collect(Collectors.joining(", ")));

        // map
        System.out.println(names.stream()
                .map(name -> name.repeat(2))
                .collect(Collectors.toList()));

        // count
        System.out.println(names.stream()
                .filter(String::isEmpty)
                .count());

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();

        System.out.println("max is: " + stats.getMax());
        System.out.println("min is: " + stats.getMin());
        System.out.println("avg is: " + stats.getAverage());
        System.out.println("sum is: " + stats.getSum());

        // limit and sorted
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }
}
