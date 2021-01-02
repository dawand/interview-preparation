package Callbacks;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("Dan", null, value ->
                System.out.println("no last name provided for " + value));

        hello2("Dan", null, () ->
                System.out.println("no last name provided"));
    }

    /**
     * Using callbacks
     * @param first
     * @param last
     * @param callback
     */
    static void hello(String first, String last, Consumer<String> callback){
        System.out.println(first);
        if (last != null){
            System.out.println(last);
        } else {
            callback.accept(first);
        }
    }

    /**
     * Using Runnable
     * @param first
     * @param last
     * @param callback
     */
    static void hello2(String first, String last, Runnable callback){
        System.out.println(first);
        if (last != null){
            System.out.println(last);
        } else {
            callback.run();
        }
    }
}
