package factory.simplefactory;

import java.util.Scanner;

public class SimpleFactory {
    public Animal createAnimal() {
        Animal intendedAnimal;
        System.out.println("Enter your choice: 0 for Tiger, 1 for Dog: ");
        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 0:
                intendedAnimal = new Tiger();
                break;
            case 1:
                intendedAnimal = new Dog();
                break;
            default:
                throw new IllegalArgumentException("An unknown animal!");
        }

        return intendedAnimal;
    }
}
