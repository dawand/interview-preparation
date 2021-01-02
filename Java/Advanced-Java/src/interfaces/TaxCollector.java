package interfaces;

public class TaxCollector {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Dan");

        System.out.println(e1.toString() + " paid tax: " + e1.payTaxes());
    }
}
