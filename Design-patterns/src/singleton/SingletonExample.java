package singleton;

public class SingletonExample {
    public static void main(String[] args) {
        Captain captain1 = Captain.getInstance();
        Captain captain2 = Captain.getInstance();

        if (captain1 == captain2) {
            System.out.println("Captain 1 and 2 are same instances");
        }

    }
}
