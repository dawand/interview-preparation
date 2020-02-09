package FunctionalProgramming;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("070000000032"));
        System.out.println(isPhoneNumberValid("07000000032"));

        System.out.println(isPhoneNumberValid .test("07000000032"));
    }

    static Predicate<String> isPhoneNumberValid =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
}
