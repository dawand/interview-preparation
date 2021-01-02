package interfaces;

public class Employee extends Person implements TaxPayer{
    @Override
    public String getName() {
        return "Employee's name: " + super.getName();
    }

    @Override
    public String toString() {
        return "Employee Details: " + super.getId()
                + " " + super.getName()
                + " " + super.getHeight()
                + " " + super.getWeight();
    }

    @Override
    public double payTaxes() {
        return 3.0;
    }
}
