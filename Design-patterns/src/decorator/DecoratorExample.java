package decorator;

public class DecoratorExample {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.makeHouse();

        FloorDecorator floorDecorator = new FloorDecorator();
        floorDecorator.setComponent(concreteComponent);
        floorDecorator.makeHouse();

        PaintDecorator paintDecorator = new PaintDecorator();
        paintDecorator.setComponent(concreteComponent);
        paintDecorator.makeHouse();
    }
}
