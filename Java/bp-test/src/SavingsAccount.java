import java.math.BigDecimal;
import java.util.*;

interface Account {
    BigDecimal decimal = new BigDecimal(0.00);
}

public class SavingsAccount implements Account{
    private static int count;
//    static {
//        System.out.println("in block 1");
//        count = 10;
//    }

//    private int[] data;
//    {
//        System.out.println("in block 2");
//        data = new int[count];
//        for (int i = 0; i < count ; i++) {
//            data[i] = i;
//        }
//    }
    public static void main(String[] args) {

//        System.out.println(count);
//        System.out.println("before first");
//        SavingsAccount s = new SavingsAccount();
//        System.out.println("before second");
//        SavingsAccount s2 = new SavingsAccount();

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", new Locale("zh", "CN"));

//        SavingsAccount acc = new SavingsAccount(new BigDecimal(50.00));
//        System.out.println(acc);
//        SavingsAccount.Employee emp = new SavingsAccount().new Employee();
//        System.out.println(emp.getBalance());

//        String s1 = "1";
//        String s2 = new String("1");
//
//        System.out.println(s2.equals(s1));
//        System.out.println(s2 == s1);
//        System.out.println(s2.matches(s1));
////        System.out.println(String.parse(s2) == s1);
//        System.out.println(s1.hashCode() == s2.hashCode());

    }
}
