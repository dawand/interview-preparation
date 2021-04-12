package collections;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. Unordered
 * 2. Does not contain duplicates (unique)
 * 3. O(1) contains element
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> numbersSet = new HashSet<>();
        numbersSet.add(3);
        numbersSet.add(2);
        numbersSet.add(3);
        numbersSet.add(5);

        for (int i = 0; i < 10; i++) {
            numbersSet.add(i);
        }

        numbersSet.add(5);

        numbersSet.forEach(System.out::println);

        System.out.println(numbersSet.contains(4));
    }
}
