package proxy;

public class ConcreteSubject extends Subject {
    @Override
    void doSomeWork() {
        System.out.println("Inside concrete subject");
    }
}
