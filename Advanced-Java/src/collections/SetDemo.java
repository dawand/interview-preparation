package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

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
        numbersSet.add(1);
        numbersSet.add(0);

//        for (int i = 0; i < 10; i++) {
//            numbersSet.add(i);
//        }
//
//        numbersSet.add(5);

        System.out.println("HashSet");
        numbersSet.forEach(System.out::println);

//        System.out.println(numbersSet.contains(4));

        Set<Integer> numbersLinkedSet = new LinkedHashSet<>(32, .5f);
        numbersLinkedSet.add(3);
        numbersLinkedSet.add(2);
        numbersLinkedSet.add(3);
        numbersLinkedSet.add(5);
        numbersLinkedSet.add(1);
        numbersLinkedSet.add(0);


        System.out.println("LinkedHashSet");
        numbersLinkedSet.forEach(System.out::println);

        Set<Integer> numbersTreeSet = new TreeSet<>();
        numbersTreeSet.add(3);
        numbersTreeSet.add(2);
        numbersTreeSet.add(3);
        numbersTreeSet.add(5);
        numbersTreeSet.add(1);
        numbersTreeSet.add(0);

        System.out.println("TreeSet");
        numbersTreeSet.forEach(System.out::println);

        Set<Person> people = new TreeSet<>();
        Person ramadan = new Person("Ramadan", 34);
        Person dawan = new Person("Dawan", 32);
        Person sheriffo = new Person("Sheriffo", 33);
        Person ramadan2 = new Person("Ramadan", 31);
        people.add(ramadan);
        people.add(dawan);
        people.add(sheriffo);
        people.add(ramadan2);

        System.out.println("TreeSet for Person");
        people.forEach(System.out::println);
    }
}
