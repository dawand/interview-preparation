## List 
### ArrayList vs LinkedList 
* Both implements List interface, maintain the insertion-order, non-synchronized collections

| Comparison | arraylist         | linkedlist  |
| --------------------- |:-------------:| -----:|
| Internal structure  | array    |  doubly linked list |
| Insert performance  | O(n)     |   O(1) |
| Search performance  | O(1)     |   O(n) |
| Memory overhead  | array and element      | two pointers and element |

### LinkedListNode
* Dummy Node trick: Maintain a list dummy head and actual tail pointer
  - Used across all linked list modification operations
```java
LinkedListNode dummy = new LinkedListNode( 0 );
LinkedListNode tail = dummy;

// append one more element to the tail
tail.next = appendedNode;
// move tail pointer forward
tail = appendedNode;

return dummy.next; // pointing to the actual list head
```

### Common tasks
* Median
```java
  public ListNode findMedian( ListNode head )
  {
    ListNode fast = head, slow = head;
    while ( fast != null && fast.next != null )
    {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
```
* Reverse list 
```java
// recursively, the key point here is record the reversed list tail before recursion
  public ListNode reverseListRecusively( ListNode head )
  {
    if ( head == null
        || head.next == null )
    {
      return head;
    }
    
    ListNode reversedListTail = head.next;
    ListNode reversedListHead = reverseList( head.next );
    reversedListTail.next = head;
    head.next = null;
    return reversedListHead;
  }
 
  private ListNode reverseListIteratively( ListNode head )
  {
    ListNode prev = null;
        
    while (head != null) 
    {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
        
    return prev;
  }
```
* Merge sorted list. 
  - The number of list K
    + if K == 2
      - Inputs
        * ListNode l1, ListNode l2
        * List<T> l1, List<T> l2
        * Iterator<T> iter1, Iterator<T> iter2
      - Solutions
        * Similar to merge sort process
    + if K > 2
      - Inputs
        * ListNode[] / List<ListNode> input
        * List<List<T>> input
        * List<Iterator<T>> input
      - Solutions: assume n is the total number of nodes
        * Merge list two by two: O( n^2 )
        * Divide and conquer: O( nlogn )
        * Heap: O( nlogk )
  - When there is any one list left, could merge directly
```java
// k == 2 case
private ListNode merge( ListNode list1, ListNode list2 )
{
  ListNode dummy = new ListNode( 0 );
  ListNode tail = dummy;
  while ( list1 != null && list2 != null ) 
  {
    if ( list1.val < list2.val ) 
    {
      tail.next = list1;
      list1 = list1.next;
    } 
    else 
    {
      tail.next = list2;
      list2 = list2.next;
    }
    
    tail = tail.next;
  }
        
  if ( list1 != null ) 
  {
    tail.next = list1;
  } 
  else 
  {
    tail.next = list2;
  }
        
  return dummy.next;
}

private List<Integer> merge( List<Integer> list1, List<Integer> l2 )
{
  List<Integer> result = new LinkedList<>();
  Iterator<Integer> iter1 = list1.iterator();
  Iterator<Integer> iter2 = list2.iterator();

  int head1 = iter1.hasNext() ? iter1.next() : null;
  int head2 = iter2.hasNext() ? iter2.next() : null;
  while ( head1 != null && head2 != null )
  {
    if ( head1 <= head2 )
    {
      result1.add( head1 );
      head1 = iter1.hasNext() ? iter1.next() : null;
    }
    else
    {
      result.add( head2 );
      head2 = iter2.hasNext() ? iter2.next() : null;
    }
  }

  while ( iter1.hasNext() )
  {
    result.add( iter1.next() );
  }

  while ( iter2.hasNext() )
  {
    result.add( iter2.next() );
  }

  return result;
}

K > 2 case:
// Heap based method is usually the most efficient one. The hard part is how to define the priority queue in case of different inputs.
// for ListNode[] / List<ListNode> input
Queue<ListNode> minQueue = new PriorityQueue<>( ( o1, o2 ) -> o1.val - o2.val );
// for List<List<T>> / List<Iterator<T>> input
Queue<ValAndIter> minQueue = new PriorityQueue<>( ( o1, o2 ) -> o1.val - o2.val );

```
