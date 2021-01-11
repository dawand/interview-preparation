package facade;

public class RobotBody {
    public static void createRobot() {
        System.out.println("Refer to manual before creating a robot.");
    }

    public void createHands(){
        System.out.println("hands assembled");
    }

    public void createRemainingParts() {
        System.out.println("Remaining parts are created.");
    }

    public static void destoryRobot() {
        System.out.println("Refer to manual before destroying a robot");
    }

    public void destroyHnads() {
        System.out.println("Hands are destroyed");
    }

    public void destroyRemainingParts() {
        System.out.println("Remaining parts are destroyed");
    }
}
