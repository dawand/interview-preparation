package collections;

import java.util.*;

/*
List
1. Ordered (Sequential)
2. Either index-based (ArrayList), or pointer-based (LinkedList)
 */
public class ListDemo {
    
    public static void main(String[] args) {
        // Static Arrays
        int[] numbersArray = new int[5];

        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = i;
//            System.out.println(i + " " + numbersArray[i]);
        }

        // Arrays are objects
        List<Integer> numbersArrayList = new ArrayList<>();

        // Convert static array to dynamic array (ArrayList)
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArrayList.add(numbersArray[i]);
        }

//        numbersArrayList.addAll(Arrays.asList(numbersArray));
//        numbersArrayList.forEach(System.out::println);

        // Dynamic Arrays - List
        List<Integer> numbers = new ArrayList<>();
//        System.out.println(numbers.size());
//        System.out.println(numbers.isEmpty());

//        for (int i = 0; i < 1_000_000; i++) {
//            numbers.add(i);
//        }

//        numbers.forEach(System.out::println);

        // 1. Traditional for with index
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }

        // 2. ForEach
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }

        // Integer number : numbers
//        Iterator<Integer> iterator = numbers.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // 3. Functional programming - Lambda
//        numbers.forEach(number -> {
//            number += 1;
//            System.out.println(number);
//        });

        // 4. Functional programming - method reference
//        numbers.forEach(System.out::println);

//        long startTime = System.nanoTime();
////        System.out.println(numbers.get(490_000));
//        System.out.println(numbers.size());
//        numbers.remove(490_000);
//        System.out.println(numbers.size());
//
//        // Slow on ArrayList, faster on LinkedList
//        numbers.add(100, 500);
//
//        long endTime = System.nanoTime();
//        System.out.println("It took " + (endTime - startTime) / 1000 + " ms");

        LinkedList<Integer> numbersLinkedList = new LinkedList<>();
        numbersLinkedList.add(2);
        numbersLinkedList.add(3);
        numbersLinkedList.add(1, 6); // insert
        numbersLinkedList.addFirst(4); // Stack
        numbersLinkedList.addLast(5); // Queue

        System.out.println(numbersLinkedList.pop()); // always returns the top element
        System.out.println("********");
        numbersLinkedList.forEach(System.out::println);

        System.out.println(numbersLinkedList.contains(3));
    }
}
