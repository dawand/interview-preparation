package facade;

public class RobotFacade {
    RobotBody robotBody;
    RobotHands robotHands;
    RobotColor robotColor;

    public RobotFacade() {
        robotBody = new RobotBody();
        robotHands = new RobotHands();
        robotColor = new RobotColor();
    }

    public void createMilanoRobot() {
        RobotBody.createRobot();
        System.out.println("Milano robot is starting");
        robotColor.setDefaultColor();
        robotHands.setMilanoHands();
        robotBody.createHands();
        robotBody.createRemainingParts();
        System.out.println("Milano robot created");
    }

}
