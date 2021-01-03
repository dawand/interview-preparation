package adapter;

public class CalculatorAdapter {
    public double getArea(Triangle triangle) {
        Calculator calculator = new Calculator();
        Rectangle rectangle = new Rectangle(triangle.getBase(), 0.5 * triangle.getHeight());
        return calculator.getArea(rectangle);
    }
}
