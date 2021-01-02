package prototype;

public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        BasicCar nano = new Nano("Green Nano");
        nano.basePrice = 100_000;

        BasicCar ford = new Ford("Ford Yellow");
        ford.basePrice = 500_000;

        BasicCar bc1;

        bc1 = nano.clone();

        bc1.onRoadPrice = nano.basePrice + BasicCar.setAdditionalPrice();
        System.out.println("Car is: " + bc1.modelNAme + " and price is: " + bc1.onRoadPrice);

        bc1 = ford.clone();
        bc1.onRoadPrice = ford.basePrice + BasicCar.setAdditionalPrice();
        System.out.println("Car is: " + bc1.modelNAme + " and price is: " + bc1.onRoadPrice);
    }
}
