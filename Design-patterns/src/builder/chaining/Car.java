package builder.chaining;

public class Car implements Builder {

    private Product product;

    public Car() {
        this.product = new Product();
    }

    @Override
    public Builder startUpOperation(String startUpMessage) {
        product.add(startUpMessage);
        return this;
    }

    @Override
    public Builder buildBody(String body) {
        product.add(body);
        return this;
    }

    @Override
    public Builder insertWheels(int wheels) {
        product.add(String.valueOf(wheels));
        return this;
    }

    @Override
    public Builder addHightlights(String highlights) {
        product.add(highlights);
        return this;
    }

    @Override
    public Builder endOperations(String endUpMessage) {
        product.add(endUpMessage);
        return this;
    }

    @Override
    public Product getConstructed() {
        return product;
    }
}
