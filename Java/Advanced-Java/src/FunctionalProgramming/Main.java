package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Liza", Gender.FEMALE),
                new Person("Dan", Gender.MALE),
                new Person("Sammi", Gender.FEMALE),
                new Person("John", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
                );

        // Imperative approach
//        List<Person> females = new ArrayList<>();
//
//        for (Person person: people) {
//            if (Gender.FEMALE.equals(person.getGender())){
//                females.add(person);
//            }
//        }
//
//        for (Person female: females) {
//            System.out.println(female);
//        }

        // Declarative approach
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        females.forEach(System.out::println);
    }
}
