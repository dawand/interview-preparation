public class MyClass implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getInfo(){
        return "myclass";
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyClass myClass = (MyClass) MyClass.class.getClassLoader().loadClass("MyClass").newInstance();
        myClass.getInfo();
    }
}
