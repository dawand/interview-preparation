package prototype;

public class Nano extends BasicCar {

    public int basePrice = 100_000;

    public Nano(String m) {
        this.modelNAme = m;
    }

    @Override
    protected BasicCar clone() throws CloneNotSupportedException {
        return (Nano) super.clone();
    }
}
