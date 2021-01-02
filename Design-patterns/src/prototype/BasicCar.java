package prototype;

import java.util.Random;

public abstract class BasicCar implements Cloneable {

    public String modelNAme;
    public int basePrice, onRoadPrice;

    public String getModelNAme() {
        return modelNAme;
    }

    public static int setAdditionalPrice() {
        Random random = new Random();
        return random.nextInt(100_000);
    }

    @Override
    protected BasicCar clone() throws CloneNotSupportedException {
        return (BasicCar) super.clone();
    }
}
