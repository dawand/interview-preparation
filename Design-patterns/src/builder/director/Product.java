package builder.director;

import java.util.LinkedList;
import java.util.List;

public class Product {
    private List<String> parts = new LinkedList<>();

    public Product() { }

    void add (String part) {
        parts.add(part);
    }

    void showProduct() {
        System.out.println("Product completed as below: ");
        parts.forEach(System.out::println);
    }
}
