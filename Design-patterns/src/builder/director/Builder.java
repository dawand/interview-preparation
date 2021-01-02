package builder.director;

public interface Builder {
    void startUpOperation();
    void buildBody();
    void insertWheels();
    void addHightlights();
    void endOperations();
    Product getVehicle();
}
