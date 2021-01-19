package flyweight;

public class FixedSizeRobot implements Robot{
    private final String robotTypeCreated;

    public FixedSizeRobot() {
        robotTypeCreated = "A fixed size robot";
        System.out.println(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.println("With color " + color);
    }
}
