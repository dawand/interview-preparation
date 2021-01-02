package singleton;

// final is to avoid having non-static nested classes subclassing Captain
final class Captain {

    private static Captain captain;

    private Captain() {}

    // synchronized is for multithreaded purpose
    public static synchronized Captain getInstance() {
        if (captain == null) { // lazy initialization
            captain = new Captain();
            System.out.println("A new captain is created :)");
            return captain;
        } else {
            System.out.println("You already have a captain!");
        }
            return captain;
    }
}
