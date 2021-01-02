package factory.factorymethod;

public class FactoryMethodExample {
    public static void main(String[] args) {
        AnimalFactory tigerFactory = new TigerFactory();
         tigerFactory.makeAnimal();

        AnimalFactory dogFactory = new DogFactory();
        dogFactory.makeAnimal();
    }
}
