package java8_features;

public class Lambda {

    private final static String salut = "Hello ";

    public static void main(String[] args) {
        Lambda tester = new Lambda();

        MathOperation addition = Integer::sum;
        MathOperation multiplication = (a, b) -> a * b; // without type
        MathOperation division = (a, b) -> a / b;
        MathOperation subtraction = (a, b) -> a - b;

        System.out.println("10 + 5 is: " + tester.operate(10,5, addition));
        System.out.println("10 X 5 is: " + tester.operate(10,5, multiplication));
        System.out.println("10 - 5 is: " + tester.operate(10,5, subtraction));
        System.out.println("10 / 5 is: " + tester.operate(10,5, division));

        GreetingService service = message -> System.out.println(salut + message);

        service.sayMessage("Dawand");
        service.sayMessage("Sulaiman");
    }

    private int operate(int i, int i1, MathOperation mathOperation) {
        return mathOperation.operation(i,i1);
    }
}

interface MathOperation{
    int operation(int a, int b);
}

interface GreetingService {
    void sayMessage(String message);
}