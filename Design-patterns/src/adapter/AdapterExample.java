package adapter;

public class AdapterExample {

    public static void main(String[] args) {
        CalculatorAdapter calculatorAdapter = new CalculatorAdapter();
        Triangle triangle = new Triangle(20, 10);
        System.out.println(calculatorAdapter.getArea(triangle));
    }
}
