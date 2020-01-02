## Queue 
### Interfaces 
| Comparison | throws exception         | return special value  |
| --------------------- |:-------------:| -----:|
| insert  | boolean add(E e)    |  boolean offer(E e) |
| remove  | E remove()     |   E poll() |
| examine  | E element()     |   E peek() |


## PriorityQueue
### Internal structure
* An unbounded priority queue based on a priority heap. Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

### Heapify 
* Def: Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
* Heapify is an O(n) operation. The reason is as follows:
  - At the bottommost level, there are 2^(h)nodes, but we do not call heapify on any of these, so the work is 0. At the next to level there are 2^(h − 1) nodes, and each might move down by 1 level. At the 3rd level from the bottom, there are 2^(h − 2) nodes, and each might move down by 2 levels.

### Sift up/down 

```java
private void siftdown( int[] A, int k ) 
{
    while ( k < A.length ) 
    {
        int smallest = k;
        if ( k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest] )
        {
            smallest = k * 2 + 1;
        }
        if ( k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest] )
        {
            smallest = k * 2 + 2;
        }

        if ( smallest == k )
        {        
            break;
        }
        else
        {
          swap( A, smallest, k );
          k = smallest;
        }
    }
}

private void swap( int[] A, int pos1, int pos2 )
{
  if ( pos1 != pos2 )
  {
        int temp = A[smallest];
        A[smallest] = A[k];
        A[k] = temp;  
  }
}

public void heapify(int[] A) {
    for (int i = A.length / 2; i >= 0; i--) {
        siftdown(A, i);
    } 
}
```

### Improve built-in remove O(n)
* Built-in implementation remove() method for priorityqueue has O(n) time complexity.
  -  O(n) time is spent on looping through entire queue to find the element to be removed. O(logn) is used to remove the element
  -  But O(n) could be easily improved to O(logn) by adding an additional Map&lt;T, Node&gt; existingNodes. When Node has duplicate values, a counter could be added as Node class instance variable.

### Lambda expression as comparator 
```java
PriorityQueue<NumAndFreq> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) ); // decreasing order
PriorityQueue<NumAndFreq> minQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) ); // increasing order
```

### Top K problems 
* Calculate the top K most frequent characters in a string 
  - Use TreeMap to maintain topK sorted order. Suppose m is the number of input and n is the number of distinct input, then build treemap requires O(mlogn),  + nlogn) complexity.
  - A more efficient approach is to use HashMap + PriorityQueue. 
```java      
      // initialize
      Map<Character, Integer> histogram = new HashMap<>();
      histogram.put( 'c', 10 );
      histogram.put( 'a', 12 );
      histogram.put( 'b', 6 );
      // output according to priorityqueue
      Queue<Map.Entry<Character, Integer>> maxQueue = new PriorityQueue<>( ( o1, o2 ) ->  o2.getValue() - o1.getValue() );
      maxQueue.addAll( histogram.entrySet() );
      return maxQueue.stream()
                     .sorted( ( o1, o2 ) -> ( o2.getValue() - o1.getValue() ) )
                     .limit( k )
                     .map( o -> o.getKey() )
                     .collect( Collectors.toList() );
```
* The largest Kth element in an array
  - PriorityQueue O(nlogk)
  - Quicksort O(n)