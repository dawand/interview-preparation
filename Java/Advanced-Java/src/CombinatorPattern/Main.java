package CombinatorPattern;

import java.time.LocalDate;

import static CombinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice",
                "alice@gmail.com",
                "+44783276362",
                LocalDate.of(2000, 1, 3));

//        CustomerValidatorService validatorService = new CustomerValidatorService();
//        System.out.println(validatorService.isValid(customer));

        // Using Combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (!result.equals(ValidationResult.SUCCESS)){
            throw new IllegalArgumentException(result.name());
        }
    }
}
