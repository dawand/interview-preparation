package proxy;

public class Proxy extends Subject {

    static Subject cs;

    @Override
    void doSomeWork() {
        System.out.println("Proxy call happening ...");

        if (cs == null) {
            cs = new ConcreteSubject();
        }
        cs.doSomeWork();
    }
}
