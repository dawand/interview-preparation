package dsa_koffman_ch2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class OrderedList<T extends Comparable<T>> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public void add(T obj){
        ListIterator<T> iter = list.listIterator();
        while(iter.hasNext()){
            if (obj.compareTo(iter.next()) < 0){
                iter.previous();
                iter.add(obj);
                return;
            }
        }
        iter.add(obj);
    }

    public T get(int index){
        return list.get(index);
    }

    public T remove(int index){
        return list.remove(index);
    }

    public int size(){
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
