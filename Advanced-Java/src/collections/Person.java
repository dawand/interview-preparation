package collections;

// Entity / model / POJO
public class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().compareTo(o.getName()) == 0) {
            if (this.getAge() > (o.getAge())) return 1;
            else return -1;
        } else if (this.getName().compareTo(o.getName()) > 0){
            return 1;
        } else {
            return -1;
        }
    }
}
