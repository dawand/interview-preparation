package factory.factorymethod;

public class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Dog says Bow-Bow");
    }

    @Override
    public void preferredAction() {
        System.out.println("Barking");
    }
}
