package java_gc;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) {
        Person person = new Person();
        WeakReference<Person> weakRef = new WeakReference<Person>(person);

        Person p1 = weakRef.get();
        System.out.println(p1);

        person = null;
        p1 = null;

        Person p2 = weakRef.get();
        System.out.println(p2);

        p2 = null;
        System.gc();

        Person p3 = weakRef.get();
        System.out.println(p3);
    }
}

class Person{
}
