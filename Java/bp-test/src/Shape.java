import java.io.IOException;
import java.util.Arrays;

interface Shape1 {

    default void print() {
        System.out.println("hi");
    }
}

class Quad implements Shape1 {

}

abstract class Triangle implements Shape1 {

}

class Shape {
    private String s = "Hello";
    public static void main(String[] args) throws InterruptedException, IOException {

        String c = "papa";

        Shape shape = new Shape();
        shape.doSomething();
//        Thread.sleep(2000);
        Runtime.getRuntime().gc();

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            // cleanup code
//            System.out.println("oopsie");
//        }));

//        Shape1 shape = new Quad();
//        Quad quadlit = new Quad();
//
//        Triangle tri = (Triangle) shape;
////        System.out.println(tri);
//
//        shape = quadlit;
//        System.out.println(shape);

//        Runnable r = () -> System.out.println("Hi");
//        Thread t = new Thread(r);
//        t.start();
    }

    private void doSomething() {
        Object[] arr = new Object[2];
        Arrays.fill(arr, new Object());
    }

    @Override
    public void finalize() {
        System.out.println("collected");
    }
}
