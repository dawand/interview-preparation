package builder.director;

public class BuilderExample {
    public static void main(String[] args) {
        Director director = new Director();

        Builder fordCar = new Car("Ford");
        Builder hondaMotorcycle = new Motorcycle("Honda");

        director.construct(fordCar);
        Product p1 = fordCar.getVehicle();
        p1.showProduct();

        director.construct(hondaMotorcycle);
        Product p2 = hondaMotorcycle.getVehicle();
        p2.showProduct();
    }
}
