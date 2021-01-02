package builder.director;

public class Director {

    Builder builder;

    public Director() {
    }

    void construct(Builder builder) {
        this.builder = builder;
        builder.startUpOperation();
        builder.buildBody();
        builder.insertWheels();
        builder.addHightlights();
        builder.endOperations();
    }
}
