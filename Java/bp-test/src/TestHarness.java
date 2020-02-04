import com.iknet.*;

public class TestHarness {
    public void writeString(){
        MySub object = new MySub();
        System.out.println(object.buildString("0,"));
    }

    public static void main(String[] args) {
        new TestHarness().writeString();
    }
}


