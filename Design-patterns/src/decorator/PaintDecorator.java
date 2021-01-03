package decorator;

public class PaintDecorator extends AbstractDecorator {

    void makeHouse() {
        super.makeHouse();
        System.out.println("Making house is called from paint decorator");
        addPaint();
    }

    private void addPaint() {
        System.out.println("Add some paintings to the house!");
    }
}
