package builder.chaining;

public interface Builder {
    Builder startUpOperation(String startUpMessage);
    Builder buildBody(String body);
    Builder insertWheels(int wheels);
    Builder addHightlights(String headlights);
    Builder endOperations(String endUpMessage);
//    Product construct();
    Product getConstructed();
}
