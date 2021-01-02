package builder.director;

public class Car implements Builder {

    private String brandName;
    private Product product;

    public Car(String brandName) {
        this.brandName = brandName;
        product = new Product();
    }

    @Override
    public void startUpOperation() {
        product.add(String.format("Car model is %s", this.brandName));
    }

    @Override
    public void buildBody() {
        product.add("This is a body of the car");
    }

    @Override
    public void insertWheels() {
        product.add("4 wheels are added");
    }

    @Override
    public void addHightlights() {
        product.add("2 Highlights are added");
    }

    @Override
    public void endOperations() {

    }

    @Override
    public Product getVehicle() {
        return product;
    }
}
