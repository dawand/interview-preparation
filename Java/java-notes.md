### Java language

#### Java vs C++

| Differences | C++          | Java  |
| --------------------- |:-------------:| -----:|
| Design goals  | Extend C but support OOP, can write non-OOP language | OOP language, must write OOP |
| Run env | at OS level, must compiled against particular OS | inside JVM, compiled classes portable |
| Pointers | Could pass value by reference | Only pass by value |
| Memory management  | Managed by developers | Garbage collector |
| Exception handling  | All unchecked | Error and RuntimeException unchecked, others checked |

#### Access modifiers

| Access modifiers | Current class | Same package | Children classes | Other packages |
| ---------------- |:-------------:| ------------:| ----------------:| --------------:|
| public           |     Yes       |     Yes      |      Yes         |     Yes        |
| protected        |     Yes       |     Yes      |      Yes         |      No        |
| default          |     Yes       |     Yes      |       No         |      No        |
| private          |     Yes       |      NO      |       No         |      No        |

#### Stack vs heap vs static area
* Stack: local variables
* Heap: new created variables
* Static area: literal and constant variables

#### OutOfMemoryError
* Types
  - java.lang.OutOfMemoryError: Java heap space
  - java.lang.OutOfMemoryError: PermGen space
  - java.lang.OutOfMemoryError: Requested array size exceeds VM limit
  - java.lang.OutOfMemoryError: request "size" bytes for "reason". Out of swap space?
  - java.lang.OutOfMemoryError: "reason" "stack trace" (Native method)
* Solution
  - Step 1: Allow the JVM to use more memory
  - Step 2: Improve/Fix the application to reduce memory usage
    1. Generate a heap dump on OutOfMemoryError
    2. Reproduce the problem
    3. Investigate the issue using heap dump file

#### Equals and hashcode
* The contract between equals and hashCode is
  - If two objects are equal, then they must have the same hash code.
  - If two objects have the same hash code, they may or may not be equal.

#### Overload vs override

| Differences | Overload          | Override  |
| --------------------- |:-------------:| -----:|
| Definition  | Two methods with same name but different signatures      |  Redefine a class already defined in the parent class |
| Execution time | Compile time     |  Run time |

#### Abstract class vs interface

| Differences | Abstract class          | Interface  |
| --------------------- |:-------------:| -----:|
| Use case  | share code among closely related classes |  share code skeleton among unrelated classes |
| Content  | a mix of methods with/without implementation | Only methods/fields, no implementations |
| Modifiers  | no limits | fields are public/static/final, methods are public automatically |
| Inheritance  | Single  | Multiple |

#### Static keyword 

|                 |    Use case   | Accessibility  |  Benefits |
| --------------- |:-------------:| --------------:| ---------:|
| Static class    | Static classes are nested classes that act like top-level classes, even if they appear somewhere in the middle or the bottom of the program hierarchy (within a class). Static classes do not need the reference of the outer class. They act like an outer class within themselves. Normal non-static nested classes, on the other hand, need reference of the outer class.  In other words, static classes are independent of the outer class, while other inner classes are dependent on the outer class. | Static classes can only access static members of an outer class, while non-static nested classes can interact with both static and non-static members of an outer class. This functionality allows static nested classes to interact with other parts of the program and provides code re-usability. | A static class, like other nested classes, can access the private variables and methods of its outer class. Static classes can be declared to remove restrictions on member classes of an outer class. If we think the outer class is too limiting and we want a member class to perform more functions, we use the “static” keyword to provide that added functionality. A static class can never be instantiated. Static classes can’t directly access non-static members of a class. It can interact with them only through an object reference. This is both a drawback and an advantage of a static class. | 
| Static block    | Static blocks are also called Static initialization blocks . A static initialization block is a normal block of code enclosed in braces, { }, and preceded by the static keyword. Static block is mostly used for changing the default values of static variables. This block get executed when the class is loaded into memory. A class can have multiple static blocks, which will be executed in the same sequence in which they have been written into the program. | non-static variables cannot be accessed in static block.  | <ul><li>If you’re loading drivers and other items into the namespace. For ex, Class class has a static block where it registers the natives.</li><li>If you need to do computation in order to initialize your static variables,you can declare a static block which gets executed exactly once,when the class is first loaded.</li><li>Security related issues or logging related tasks</li></ul> |
| Static method   | A static method belongs to the class rather than instances. You can call a static method without creating any object, just by using it's class name. So if you need a method, which you want to call directly by class name, make that method static. Utility classes e.g. java.lang.Math or StringUtils, are good examples of classes, which uses static methods. Before making a method static, you should look into limitation of static methods as well, as you can not override static method in Java. | <ul><li>Static methods can access static variables and invoke only static methods of the class. The static method cannot use non static data member or call non-static method directly.</li><li>this and super cannot be used in static context.</li></ul> | | 
| Static variable | A static variable is a class variable and doesn't belong to object/instance of the class. Memory allocation for such variables only happens once when the class is loaded in the memory. | These variables can be accessed in any other class using class name. Unlike non-static variables, such variables can be accessed directly in static and non-static methods. | Memory more efficient because the static variable allocate memory only once in class area at the time of class loading. Static variables are shared across all the instances of object, thus not thread-safe. |
| Interface static method |  |  |  |
| static import | | | | 

* Rules to use static method
  1. If a method doesn't modify state of object, or not using any instance variables.
  2. You want to call method without creating instance of that class.
  3. A method is good candidate of being static, if it only work on arguments provided to it e.g. public int factorial(int number){}, this method only operate on number provided as argument.
  4. Utility methods are also good candidate of being static e.g. StringUtils.isEmpty(String text), this a utility method to check if a String is empty or not.
  5. If function of method will remain static across class hierarchy e.g. equals() method is not a good candidate of making static because every Class can redefine equality.

* When to use static method
  - it makes sense to use static methods when 
    + Along with creational design pattern e.g. Factory and Singleton.
    + As utility method, which operate on arguments.
    + A conversion tool e.g. valueOf().
  - Detailed explanation
    1. Factory design pattern provides a good use of static method. You can use static method to create instance of a class. Even Effective Java book advises about using static factory method, couple of example of these in Java library is creating thread pool from Executors class. Executors provides lots of static methods to create different types of thread pool e.g. public static ExecutorService newCachedThreadPool(), public static ExecutorService newFixedThreadPool(int nThreads) etc
    2. Another interesting use of static methods from JDK is collection classes e.g. Collections and Arrays which provides lot of static utility methods to operate on different kinds of collection.
    3. Static method can also be combined with variable arguments to create a collection of explicitly elements e.g. EnumSet.of(E first, E... rest). Apart from these, if you loot at Apache commons lang library, you will find a pattern of utils class e.g. StringUtils, ArrayUtils, which provides utility methods to operate on String and arrays.
    4. One more interesting use of static method I have seen is valueOf() method inside different value classes e.g. java.lang.String, though this is also an example of factory method, but it's also a nice way to convert one type to another. For example valueOf() can also be used to convert String to Integer in Java.
  
* Cannot override static methods in Java
No, you cannot override static method in Java because method overriding is based upon dynamic binding at runtime and static methods are bonded using static binding at compile time. Though you can declare a method with same name and method signature in sub class which does look like you can override static method in Java but in reality that is method hiding. Java won't resolve method call at runtime and depending upon type of Object which is used to call static method, corresponding method will be called. It means if you use Parent class's type to call static method, original static will be called from patent class, on ther other hand if you use Child class's type to call static method, method from child class will be called. In short you can not override static method in Java. If you use Java IDE like Eclipse or Netbeans, they will show warning that static method should be called using class name and not by using object becaues static method can not be overridden in Java.

#### Main method 
* Why main method is static
  1. Since the main method is static Java virtual Machine can call it without creating any instance of a class which contains the main method.
  2. Since C and C++ also have similar main method which serves as entry point for program execution, following that convention will only help Java.
  3. If main method were not declared static than JVM has to create instance of main Class and since constructor can be overloaded and can have arguments there would not be any certain and consistent way for JVM to find main method in Java.
  4. Anything which is declared in class in Java comes under reference type and requires object to be created before using them but static method and static data are loaded into separate memory inside JVM called context which is created when a class is loaded. If main method is static than it will be loaded in JVM context and are available to execution.
* Why main method is public
Java specifies several access modifiers e.g. private, protected and public. Any method or variable which is declared public in Java can be accessible from outside of that class. Since the main method is public in
Java, JVM can easily access and execute it.
* Why the main method is void
Since the main method in Java is not supposed to return any value, it's made void which simply means main is not returning anything.

#### Clone
* Deep and shallow copy
  - Default clone() method creates the shallow copy of an object. 
    + The shallow copy of an object will have exact copy of all the fields of original object.
    + Shallowcopy is preferred if an object has only primitive fields. 
  - In addition to shallow copy,
    + If original object has any references to other objects as fields, then copy of those objects are also created by calling clone() method on them.  
* How to clone an object
  - Implements Cloneable interface and override clone() 
  - Implements serializable interface and clone objects by serialize and deserialize

#### Assertion 
* Assertion. To put it short, assertion are for internal precondition/post-condition violation checking while exception are for external condition checking.
  - Where not to use
    + Implement any application functionality
      * Enable/Disable them may cause severe damage to the state of the application and its usability
    + Check arguments of public methods
      * Public methods should always behave the same. Enable/Disable them will change the behavior of the method dramatically.
  - Where to use: internal logic checking
    + Implement pre-conditions
      * Something that must be true at the time of invoking a method
    + Implement post-conditions
      * Something that must be true after the 
    + Implement class invariants

#### Error vs exception 
* Both java.lang.Error and java.lang.Exception classes are sub classes of java.lang.Throwable class
* java.lang.Error class represents the errors which are mainly caused by the environment in which application is running. 
  + For example, OutOfMemoryError occurs when JVM runs out of memory or StackOverflowError occurs when stack overflows.
* java.lang.Exception class represents the exceptions which are mainly caused by the application itself. 
  + For example, NullPointerException occurs when an application tries to access null object or ClassCastException occurs when an application tries to cast incompatible class types. In this article, we will discuss the differences between Error and Exception in java.

#### Checked vs unchecked exception 
* **Checked exception**
  - **Def**: Exceptions that are checked at compile time. Must be handled explicitly either by catching or throwing the exception. 
  - **Use condition 1**: Expected but unpreventable (The caller did everything within their power to validate the input parameters, but some condition outside their control has caused the operation to fail. For example, you try reading a file but someone deletes it between the time you check if it exists and the time the read operation begins. By declaring a checked exception, you are telling the caller to anticipate this failure.)
  - **Use condition 2**: Reasonable to recover from (There is no point telling callers to anticipate exceptions that they cannot recover from. If a user attempts to read from an non-existing file, the caller can prompt them for a new filename. On the other hand, if the method fails due to a programming bug (invalid method arguments or buggy method implementation) there is nothing the application can do to fix the problem in mid-execution. The best it can do is log the problem and wait for the developer to fix it at a later time.)
* **Unchecked exception**: 
  - **Runtime exception**
    + **Use case**: Use runtime exceptions to indicate programming errors. Runtime exceptions indicate precondition violations. A precondition violation is simply a failure by the client of an API to adhere to the contract established by the API specification. For example, the contract for array access specifies that the array index must be between zero and the array length minus one. ArrayIndexOutOfBoundsException indicates that this precondition was violated.
    + **Examples**:
      * IllegalArgumentException ( check input of function arguments )
      * IllegalStateException ( illegal state of variables )
      * ArithmeticException ( 1 / 0 )
      * IndexOutOfBoundaryException ( example problem: search in unknown size sorted array )

#### Immutable class 
* Benefits:
  - **Clone**: Don't need a copy constructor/an implementation of clone()
  - **Defensive copy**: Don't need to be copied defensively when used as a field
  - **Threadsafe**: Are automatically thread-safe and have no synchronization issues
  - **Hashcode cache**: Allow hashCode to use lazy initialization and to cache its return value
  - **Class invariants**: Have their class invariants established once upon construction and it never needs to be checked again.
* Design guidelines:
  - Don't allow subclass to override methods
    + Declare the class as final
    + Make constructor private and construct instances in factory methods
  - Don't provide setter methods
  - Make all fields final and private
  - If the instance fields include references to mutable objects, don't allow those objects to be changed
    + Do not provide methods that modify mutable objects
    + Do not share references of mutable objects. Create defensive copy of internal mutable objects when sharing.

#### Final vs finally vs finalize
* Final class can't be inherited, final method can't be overriden and final variable can't be changed. A class/Method may never be both abstract and final. Abstract means the class/Method must be extended/Overriden, while final means it cannot be. 


|     Object   |       Meaning        |       Advantage    |     Example      |
| ------------ |:--------------------:| ------------------:| ----------------:|
| Final class  | Cannot be subclassed | Security/Efficiency | String | 
| Final method | Cannot be overriden  | <ul> <li>Preventing unexpected behavior crucial to the funtionality of the class </li> <li>Critical to the consistent state of the object</li> </ul> | <ul><li>Object.getClass()/notify() </li> <li> methods called from constructors should usually be final </li></ul> | 
| Final var    | Cannot be reassigned / Making a reference var final only means the var can not be changed but you can change the referenced object | <ul> <li>Could be cached </li> <li> Safe to share in multi-threading env </li> </ul> | All vars declared inside java interface are implicitly final |

* Finally
  - Use case: Clean up operations like closing the DB resources 
  - Reason: those operations will be always executed irrespective of 
    + Whether exceptions are raised in the try block or not
    + Whether raised exceptions are caught in catch block or not
    + Except 
      * You call JVM to exit by executing System.exit(0)
```java
lock.lock();
try 
{
  // do stuff
}
catch ( SomeException se )
{
  // handle se
}
finally
{
  lock.unlock();
}
```

* Finalize 
  + How it is going to work
    - When the garbage collector is ready to release the storage used for your object, it will first call finalize()
    - Only on the next garbage-collection pass will it reclaim the object's memory. 
  + Use case: 
    - Finalize() should not be used as a general-purpose cleanup method. Finalize() is limited to special cases in which your object can allocate storage in some way other than creating an object. Finalize() is in place because of the possibility that you'll do something C-like by allocating memory using a mechanism other than the normal one in Java. This can happen primarily through native methods, which are a way to call non-Java code from Java. Inside the non-Java code, C's malloc() family of functions might be called to allocate storage, and unless you call free(), that storage will not be released, causing a memory leak. 
    - An interesting use of finalize() is the verification of the termination condition of an object. When the object is ready to be cleaned up - the object should be in a state whereby its memory can be safely released. 
```java
class FinalizeExample
{
  public void finalize()
  {
    System.out.println("finalize called");
  }

  public static void main( String[] args )
  {
    FinalizeExample f1 = new FinalizeExample();
    FinalizeExample f2 = new FinalizeExample();
    f1 = null;
    f2 = null;
    System.gc();
  }
}
```

#### Java garbage collection
##### Components
* Reference counting
  - Cyclic reference
  - When the reference counting is zero, the object is freed. 
* Mark and sweep
  - 'mark' phase identifies the objects that are still in use.
  - 'sweep' phase remove unused objects
  - 'compact' phase to compact memory
* Copying
  - Use different spaces to manage memory
  - When the fromspace is full, compact it to the tospace
* Generational
  - Maintain different generations for memory
    + Long living objects promoted to a different generation
    + For a given definition of long
  - Young generation
    + One eden space:       
      * Objects allocated into Eden space
    + Two survivor spaces
      * Objects that survive a GC get moved to the survivor space
      * Only one survivor space in use at a time
      * Objects copied between survivor spaces
    + Minor garbage collection
        - When GC runs objects are copied to 'newer' survivor space
        - Objects from 'older' survivor space also copied to 'newer' survivor space
        - Survivior spaces are swapped
    + Major garbage collection
      * Triggered when the tenured space is full
      * Collects old and young generations
      * JVM will eventually promot to old: 
        - After a certain number of garbage collects
        - If survivor space is full
        - If JVM has been told to always create objects in old space
          + -XX:+AlwaysTenure flag to JVM
  - Old generation / Tenured space
    + Where long lived objects go to die
    + Garbage collector tends to run less on old generation

##### Memory allocation
* Java use thread local allocation buffers
* Each thread gets its own buffer inside eden space

##### What does live mean
* Live roots
  - From stack frames
  - Static variables
  - Others such as JNI and synchronization 'monitors'
* References from live rooted objects are followed to other objects
* What about references from old generation to young
  - This is an issue - Young GC has to scan old space
  - Sort of defeats the purpose of having multiple generation spaces
    + CardTable
      * Each write a reference to a young object goes through a write barrier. 
      * This barrier updates a card table entry
      * One entry per 512 bytes of memory
      * Minor GC scans

##### Types of Java garbage collectors
* Serial collector
  - Single threaded. Stop the world collector
  - Mark and sweep
  - Ok for small applications running on the client
* Parallel collector
  - Multiple threads for minor collection
  - Single thread for major collection
  - Same process as serial
  - Use on servers
* Parallel old collector
  - Multiple threads for minor and major collections
  - Preferred over parallel GC
* Concurrent mark and sweep collector
  - Only collects old space
  - No longer bump the pointer allocation
  - Causes heap fragmentation
  - Designed to be lower latency. 

| Phase            | Notes          | Description                                                                                                             | 
|------------------|----------------|-------------------------------------------------------------------------------------------------------------------------| 
| Initial mark     | Stop the world | Mark objects in the old generation reachable from root references                                                       | 
| Concurrent mark  | Concurrent     | Traverse object graph looking for live objects. Any allocations made during this phase are automatically marked as live | 
| Remark           | Stop the world | Finds objects created after the previous phase stopped                                                                  | 
| Concurrent sweep | Concurrent     | Collect objects                                                                                                         | 
| Resetting        | Concurrent     | Get ready for the next run                                                                                              | 

* G1 collector
  - New in Java 6
  - Is a compacting collector, as a replacement for CMS
  - Meant for server applications
    + Running on multiprocessor machines with large memories
  - Breaks heap into regions

#### Java reference classes
##### Types
* Java has always had strong references
* Other types of references are available
  - Special class in java.lang.ref package
  - Soft, weak, phantom

##### Reference rules
* Strong &gt; Soft &gt; Weak &gt; Phantom
* Object not GC'd if there is a strong reference
  - Can be GC'd if there is a soft, weak or phantom reference
* Soft will be collected if there is memory pressue
* Weak will be collected immediately
* Phantom refernces different to the other two
  - Cannot retrieve the object through a phantom reference

##### Usage of reference types
* WeakReference
  - Associate meta data with another type
  - Usually used in conjunction with weakhashmap
* SoftReference
  - When strong references is cleared soft is still available
  - Can be used for caching
    + No control over the cache
    + It's all managed by the garbage collector
* PhantomReference
  - Interaction with the garbage collector

##### Use Weak reference

```java
import java.lang.ref.WeakReference;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        WeakReference<Person> wr = new WeakReference<Person>(person);

        Person p1 = wr.get();
        System.out.println(p1);

        person = null;
        p1 = null;
        Person p2 = wr.get();
        System.out.println(p2);

        p2 = null;
        System.gc();
        Person p3 = wr.get();
        System.out.println(p3);

    }
}

class Person {

}

```

##### Use WeakHashMap
* Like a hashMap
* Key is a weak reference to an object
  - Store a weak reference to an object as a key
  - Value is the object's meta data
* When object has no more strong references
  - The key is released
  - Meta data goes away

```java
import java.util.Date;
import java.util.WeakHashMap;

public class Main {

    public static void main(String[] args) {
        WeakHashMap<Person, PersonMetaData> weakHashMap = new WeakHashMap<Person, PersonMetaData>();
        Person kevin = new Person();
        weakHashMap.put(kevin, new PersonMetaData());

        PersonMetaData p = weakHashMap.get(kevin);

        System.out.println(p);

        kevin = null;
        System.gc();

        if(weakHashMap.containsValue(p)){
            System.out.println("Still contains key");
        } else {
            System.out.println("Key gone");
        }
    }
}

final class Person {

}

class PersonMetaData {
    Date date;

    PersonMetaData() {
        date = new Date();
    }

    @Override
    public String toString() {
        return "PersonMetaData {" +
                "date=" + date +
                '}';
    }
}
```

##### Use ReferenceQueue
* Pass a reference queue to constructor when creating the reference object
  - Optional except for PhantomReference
* References types enqueued to ReferenceQueue
* When all strong references cleared
  - Reference object is added to the reference queue
* ReferenceQueue has poll and remove methods
  - Poll returns immediately
  - Remove has a timeout
  - Both remove object from the queue
* Can be used to attach clean up code
  - Extend reference type
* When all strong references cleared
  - Reference object added to the queue

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.sql.Ref;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException {
        Person p = new Person();
        final ReferenceQueue<Person> referenceQueue = new ReferenceQueue<Person>();
        PersonCleaner cleaner = new PersonCleaner();
        PersonWeakReference weakReference = new PersonWeakReference(p, cleaner, referenceQueue );

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    PersonWeakReference wr = (PersonWeakReference) referenceQueue.remove();
                    wr.clean();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        p = null;
        System.gc();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press any key to continue");
        br.readLine();
        executorService.shutdown();

    }
}

final class Person {

}

class PersonCleaner {

    public void clean() {
        System.out.println("Cleaned");
    }
}

class PersonWeakReference extends WeakReference<Person> {

    PersonCleaner cleaner;
    public PersonWeakReference(Person referent, PersonCleaner cleaner, ReferenceQueue<? super Person> q) {
        super(referent, q);
        this.cleaner = cleaner;
    }

    public void clean(){
        cleaner.clean();
    }
}
```

##### Use PhantomReference
* Used instead of finalizers
* Finalizers have issues
  - Can be expensive
  - Not sure when they will be called

```java
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ReferenceQueue<Person> queue = new ReferenceQueue<Person>();
        ArrayList<FinalizePerson> list = new ArrayList<FinalizePerson>();
        ArrayList<Person> people = new ArrayList<Person>();

        for (int i = 0; i< 10; i++){
            Person p = new Person();
            people.add(p);
            list.add(new FinalizePerson(p, queue));
        }

        people = null;
        System.gc();

        for (PhantomReference<Person> reference : list) {
            System.out.println(reference.isEnqueued());
        }

        Reference<? extends Person> referenceFromQueue;
        while ((referenceFromQueue = queue.poll()) != null) {
            ((FinalizePerson) referenceFromQueue).cleanup();
        }

    }
}

class FinalizePerson extends PhantomReference<Person>{

    public FinalizePerson(Person referent, ReferenceQueue<? super Person> q) {
        super(referent, q);
    }

    public void cleanup() {
        System.out.println("person is finalizing resources");
    }

}

class Person {
}
```