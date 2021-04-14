package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class mapDemo {

    public static void main(String[] args) {
        Map<String, Integer> personAge = new HashMap<>();
        personAge.put("Ramadan", 32);
//        personAge.put("Ramadan", 34);
        personAge.put("Dawan", 31);
        personAge.put("Sheriffo", 35);

//        personAge.keySet().forEach(System.out::println);
//        personAge.values().forEach(System.out::println);

        // iterative approach
//        for (Map.Entry<String, Integer> entry: personAge.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        // functional
        System.out.println("*** HashMap ***");
        personAge.forEach((k, v) -> System.out.println(k + " : " + v));

        Map<String, Integer> personAgeLinkedMap = new LinkedHashMap<>();
        personAgeLinkedMap.put("Ramadan", 32);
//        personAge.put("Ramadan", 34);
        personAgeLinkedMap.put("Dawan", 31);
        personAgeLinkedMap.put("Sheriffo", 35);

        System.out.println("*** LinkedHashMap ***");
        personAgeLinkedMap.forEach((k, v) -> System.out.println(k + " : " + v));

        Map<String, Integer> personAgeOrderedMap = new TreeMap<>();
        personAgeOrderedMap.put("Ramadan", 32);
//        personAge.put("Ramadan", 34);
        personAgeOrderedMap.put("Dawan", 31);
        personAgeOrderedMap.put("Sheriffo", 35);

        System.out.println("*** TreeMap ***");
        personAgeOrderedMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
