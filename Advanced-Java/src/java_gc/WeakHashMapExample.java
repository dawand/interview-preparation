package java_gc;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        WeakHashMap<Person, PersonMetaData> weakHM = new WeakHashMap<>();
        Person p1 = new Person();
        weakHM.put(p1, new PersonMetaData());

        PersonMetaData metaData = weakHM.get(p1);

        System.out.println(metaData);

        p1 =null;
        System.out.println(weakHM);
        System.gc();


        if (weakHM.containsValue(metaData)){
            System.out.println("Key still there");
        } else {
            System.out.println("The weak key is gone!");
        }

        System.out.println(weakHM);
    }
}

class PersonMetaData {
    Date date;

    public PersonMetaData() {
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "PersonMetaData{" +
                "date=" + date +
                '}';
    }
}

