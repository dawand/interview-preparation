package factory.factorymethod;

public class TigerFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Tiger();
    }
}
