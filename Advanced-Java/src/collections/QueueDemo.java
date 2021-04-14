package collections;

import java.util.*;

public class QueueDemo {

    public static void main(String[] args) {
        Deque<Integer> numbersQueue = new ArrayDeque<>();
        numbersQueue.add(5);
        numbersQueue.add(8);
        numbersQueue.add(4);
        System.out.println(numbersQueue.size());
        numbersQueue.add(3);
        numbersQueue.add(7);
        System.out.println(numbersQueue.peek()); // Does not remove the element - only returns it
        System.out.println(numbersQueue.pop()); // removes and returns the element
        System.out.println(numbersQueue.size());

//        CustomQueue customQueue = new CustomQueue();
//        customQueue.addLast(4);
//        customQueue.addLast(5);
//        customQueue.addLast(4);
//        customQueue.addLast(6);
//        customQueue.addLast(6);

        CustomQueue<String> customQueue2 = new CustomQueue<>();
        customQueue2.addLast("Ramadan");
        customQueue2.addLast("Mubarak");
        customQueue2.forEach(System.out::println);

        Queue<Person> people = new PriorityQueue<>(Comparator.comparingInt(Person::getAge));
        Person ramadan = new Person("Ramadan", 34);
        Person dawan = new Person("Dawan", 32);
        Person sheriffo = new Person("Sheriffo", 33);
        Person ramadan2 = new Person("Ramadan", 31);
        people.add(ramadan);
        people.add(dawan);
        people.add(sheriffo);
        people.add(ramadan2);

        System.out.println("PQ for Person");
//        people.forEach(System.out::println);

        while(true)
        {
            Person e = people.poll();
            System.out.println(e);
            if(e == null) break;
        }
    }
}

class CustomQueue<E> implements Deque<E> {

    int maxSize;
    List<E> elements;

    public CustomQueue() {
        maxSize = 3;
        elements = new ArrayList<>();
    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {
        elements.add(e);
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}
