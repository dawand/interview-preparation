package builder.chaining;

public class BuilderExample {
    public static void main(String[] args) {

        final Product p1 = new Car().addHightlights("5")
                .buildBody("Plastic")
                .insertWheels(4)
                .endOperations("My car is nice :)")
                .getConstructed();

        p1.showProduct();
    }
}
