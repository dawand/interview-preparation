public class LongClass {

    public static void main(String[] args) {
        Long i = new Long(10);
        long k = -5;
        long j = 10;

        if (i.equals(j))
            System.out.println("i equal to j");
        else
            System.out.println("i not equal j");

        if (Long.compare(i,k)>0)
            System.out.println("i greater than k");
        else
            System.out.println("i less than");

        if (Long.compareUnsigned(i,k)>0)
            System.out.println("i greater than k");
        else
            System.out.println("i less than k");
    }
}
