import java.util.Arrays;

public class ComparableTest implements Comparable<ComparableTest>{
    @Override
    public int compareTo(ComparableTest comparableTest) {
        return comparableTest.i - this.i;
    }

    int i;

    ComparableTest(int i){
        this.i = i;
    }

    public static void main(String[] args) {
        ComparableTest[] ct = {new ComparableTest(3),new ComparableTest(4),new ComparableTest(2),new ComparableTest(1)};

        Arrays.sort(ct);
        for (ComparableTest c:
ct             ) {
            System.out.println(c.i);
        }
    }
}
