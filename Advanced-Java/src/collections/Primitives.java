package collections;

public class Primitives {
    public static void main(String[] args) {

        // primitive types: boolean, bit, char, int, long, float, double
        // primitive counterpart objects: Boolean, Bit, Character, Integer, Long, Float, Double

        Integer integerNumber = Integer.parseInt("5"); // parsing

        Integer integerAutoBoxedNumber = new Integer(5); // boxing
//                Integer.valueOf(5); // boxing
        integerAutoBoxedNumber = 5; // Autoboxing
        int intNumber = integerAutoBoxedNumber; // unboxing

        long longNumber = 500_000_000_000_000L;
        Long longObject = longNumber; // Autobox
//        Integer autoBoxedFromLong = Integer.valueOf(longObject.toString());
        // (int) longNumber;
        System.out.println(longObject);
    }
}
