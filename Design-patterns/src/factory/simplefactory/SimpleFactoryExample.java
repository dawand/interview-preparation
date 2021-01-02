package factory.simplefactory;

public class SimpleFactoryExample {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Animal preferredType;

        preferredType = simpleFactory.createAnimal();
        preferredType.speak();
        preferredType.preferredAction();
    }
}
