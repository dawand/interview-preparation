public class DoublyLinkedList {

    public static void main(String[] args) {
        // Create your subway line here:
        DoublyLinkedList subway = new DoublyLinkedList();
        subway.addToHead("Times Square");
        subway.addToHead("Grand Central");
        subway.addToHead("Central Park");
        subway.addToTail("Penn Station");
        subway.addToTail("Wall Street");
        subway.addToTail("Brooklyn Bridge");

        // subway.removeByData("Central Park");
        subway.removeHead();
        subway.removeTail();
        subway.removeByData("Times Square");

        subway.printList();
    }

    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;

        if (currentHead != null) {
            currentHead.setPreviousNode(newHead);
            newHead.setNextNode(currentHead);
        }
        this.head = newHead;

        if (this.tail == null) {
            this.tail = newHead;
        }
    }

    public void addToTail(String data) {
        Node newTail = new Node(data);
        Node currentTail = this.tail;

        if (currentTail != null) {
            currentTail.setNextNode(newTail);
            newTail.setPreviousNode(currentTail);
        }
        this.tail = newTail;

        if (this.head == null) {
            this.head = newTail;
        }
    }

    public String removeHead() {
        Node removedHead = this.head;

        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();

        if (this.head != null) {
            this.head.setPreviousNode(null);
        }
        if (removedHead == this.tail) {
            this.removeTail();
        }
        return removedHead.data;
    }

    public String removeTail() {
        Node removedTail = this.tail;

        if (removedTail == null) {
            return null;
        }
        this.tail = removedTail.getPreviousNode();

        if (this.tail != null) {
            this.tail.setNextNode(null);
        }
        if (removedTail == this.head) {
            this.removeHead();
        }
        return removedTail.data;
    }

    public Node removeByData(String data) {
        Node nodeToRemove = null;
        Node currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.data == data) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNextNode();
        }

        if (nodeToRemove == null) {
            return null;
        }
        if (nodeToRemove == this.head) {
            this.removeHead();
        } else if (nodeToRemove == this.tail) {
            this.removeTail();
        } else {
            Node nextNode = nodeToRemove.getNextNode();
            Node previousNode = nodeToRemove.getPreviousNode();
            nextNode.setPreviousNode(previousNode);
            previousNode.setNextNode(nextNode);
        }
        return nodeToRemove;
    }

    public String printList() {
        Node currentNode = this.head;
        String output = "<head> ";
        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);
        return output;
    }

}