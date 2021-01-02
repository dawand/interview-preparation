package prototype;

public class Ford extends BasicCar {

    public Ford(String m) {
        this.modelNAme = m;
    }

    @Override
    protected BasicCar clone() throws CloneNotSupportedException {
        return (Ford) super.clone();
    }
}
