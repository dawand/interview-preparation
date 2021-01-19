package flyweight;

public class SmallRobot implements Robot{
    private final String robotTypeCreated;

    public SmallRobot() {
        robotTypeCreated = "A small robot";
        System.out.println(robotTypeCreated);
    }

    @Override
    public void showMe(String color) {
        System.out.println("With color " + color);
    }
}
