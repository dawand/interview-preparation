package java_gc;

import org.w3c.dom.ls.LSOutput;

public class FinalizeExample {

    String name;

    @Override
    public void finalize(){
        System.out.println("finalize called!");
    }

    public static void main(String[] args) {
        FinalizeExample example1 = new FinalizeExample();
        example1.name = "ex1";
        FinalizeExample example2;

        example2 = example1;

        System.out.println(example1.hashCode());

        example1 = null;
        System.out.println(example2.name);
        System.out.println(example2.equals(example1));
        System.out.println(example2.hashCode());

        example2 =null;

        System.gc();
    }
}
