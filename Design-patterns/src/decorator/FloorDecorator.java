package decorator;

public class FloorDecorator extends AbstractDecorator {
    void makeHouse() {
        super.makeHouse();
        System.out.println("Let's also work on the floor");
        addFloor();
    }

    private void addFloor() {
        System.out.println("Adding a new floor");
    }
}
