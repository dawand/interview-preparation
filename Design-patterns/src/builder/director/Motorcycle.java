package builder.director;

public class Motorcycle implements Builder{

    private String brandName;
    private Product product;

    public Motorcycle(String brandName) {
        this.brandName = brandName;
        product = new Product();
    }

    @Override
    public void startUpOperation() {

    }

    @Override
    public void buildBody() {
        product.add("Body of a motorcycle");
    }

    @Override
    public void insertWheels() {
        product.add("2 wheels are added");
    }

    @Override
    public void addHightlights() {
        product.add("1 headlights is added");
    }

    @Override
    public void endOperations() {
        product.add(String.format("Motorcycle brand name is %s ", this.brandName));
    }

    @Override
    public Product getVehicle() {
        return product;
    }
}
