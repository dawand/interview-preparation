package flyweight;

public class LargeRobot implements Robot {
    private final String robotTypeCreated;

    public LargeRobot() {
        robotTypeCreated = "A large robot";
        System.out.println(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.println("With color " + color);
    }
}
