import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//
//interface I1 {
//    String name = "N1";
//    String s1 = "S1";
//}
//
//interface I2 extends I1{
//    String name = "N2";
//}

class Parent{
    protected static int count = 0;
    public Parent(){
        count++;
    }
    static int getCount() {return count; }
}

class Child extends Parent{
        public Child(){
            count++;
        }

    public static void main(String[] args) {
        System.out.println(getCount());
        Child obj = new Child();
        System.out.println(getCount());
    }
}

public class Main{
        static int c = 0;

    Main(){

    }

    public static void main(String[] args) {

        int c = 5;
        System.out.println(c);

//        System.out.println(I2.name);
//        System.out.println(I2.s1);
//        System.out.println(((I1)new Main()).name);

//        System.out.println(Stream.of(new Integer[] {1,2,3,4,5}).findFirst());

//        File file1 = new File("src/test.txt");
//        File backup = new File("src/test.txt.bak");
//        backup.delete();
//        file1.renameTo(backup);

//        StringBuilder sb = new StringBuilder();
//        for (String arg: args
//             ) {
//            if (sb.indexOf(arg) < 1)
//                sb.append(" " + args + " ");
//        }
//
//        System.out.println(sb.toString());
//
//        Scanner sc = new Scanner(sb.toString());
//
//        while (sc.hasNext()){
//            if (sc.hasNextInt()) {
//                System.out.println(sc.nextInt() + " ");
//                System.out.println("papappap");
//            }
//            else
//                sc.next();
//        }
//        Calendar cal = Calendar.getInstance();
//        cal.set(2000, Calendar.AUGUST, 30);
//        cal.roll(Calendar.MONTH, 7);
//
//        System.out.println(cal.get(Calendar.DATE) + " " + cal.get(Calendar.MONDAY) + " " + cal.get(Calendar.YEAR));
//        cal.add(Calendar.MONTH, 11);
//        System.out.println(cal.get(Calendar.DATE) + " " + cal.get(Calendar.MONDAY) + " " + cal.get(Calendar.YEAR));
//
//        LocalDate date = LocalDate.of(2000, Month.AUGUST, 30);
//        date.plusMonths(6);
//        System.out.println(date.getDayOfMonth() + " "  + date.getMonthValue() + " " + date.getYear());
//        meth(args);
//        System.out.println(Runtime.getRuntime().totalMemory());
//        System.out.println(Runtime.getRuntime().maxMemory());
//        System.out.println(Runtime.getRuntime().freeMemory());
//    String first = "first";
//    String second = new String("first");
//    "first".concat("second");
//        System.out.println(first.equals(second));
//        System.out.println(first == second);
//        System.out.println(first.equals("firstsecond"));
//        System.out.println("first" == second);

//        Integer i = Integer.parseUnsignedInt(4);
//        Double d = new Double("17.46d");
////        Character c = new Character("C");
//        Float f = new Float(23.43);
//        Boolean b = new Boolean("false");

//        Supplier<String> i = () -> "Car";
//        Consumer<String> c = x -> System.out.println(x.toLowerCase());
//        Consumer<String> d = x -> System.out.println(x.toUpperCase());
//
//        c.andThen(d).accept(i.get());
//        System.out.println();
    }

    private static void meth(String[] args) {
        System.out.println(args);
        System.out.println(args[1]);
    }
//        System.out.println("main 1");
//
//        Main main = new Main();
//
//        try {
//            int c = 10 / 0;
//            new FileReader("papa") throw new IOException();
//        } catch (IOException | ArithmeticException e){
//            System.out.println(e.getLocalizedMessage());
//        }
//        Main test = new Main();
//        test.myMethod(new Runnable() {
//            public void run() {}
//        }
//        );
//
//        YearMonth m1 = YearMonth.of(2015, Month.SEPTEMBER);
//        YearMonth m2 = YearMonth.of(2016, Month.FEBRUARY);
//
//        System.out.println(m2.until(m1, ChronoUnit.MONTHS));
//        System.out.println(m1.minus(Period.ofMonths(4)).getMonthValue());

//        String e = "1";
//        System.out.println((e != "1")? "true": "false");
//
//        System.out.println((0 == c++)? "true": "false");
//
//        Double d = null;
//        System.out.println((d instanceof Double));
//    } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        public void myMethod(Runnable runnable){



}
