package ds;

public class DoublyLinkedList {
    private class Node {
        private int value;
        private Node prev;
        private Node next;

        Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(int value) {
        if (isEmpty()) throwErrorEmpty();

        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return true;
            currentNode = currentNode.next;
        }

        return false;
    }

    public void reverse() {
        if (isEmpty()) return;

        var currentNode = head.next;
        var nextNode = currentNode.next;
        while (currentNode != tail) {
            currentNode.next = currentNode.prev;
            currentNode.prev = nextNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }

        var newHead = tail;
        newHead.next = newHead.prev;
        newHead.prev = null;

        var newTail = head;
        newTail.prev = newTail.next;
        newTail.next = null;

        head = newHead;
        tail = newTail;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) throwErrorEmpty();

        var currentNode = tail;
        for (int i = 1; i <= k; i++) {
            if (i == k) return currentNode.value;
            if (currentNode.prev == null)
                throw new IllegalArgumentException("Kth is greater than size of list.");
            currentNode = currentNode.prev;
        }


        throw new IllegalArgumentException("Error Kth is greater than size of list.");
    }

    public int getFirst() {
        if (isEmpty()) throwErrorEmpty();

        return head.value;
    }

    public int getLast() {
        if (isEmpty()) throwErrorEmpty();

        return tail.value;
    }

    public Node get(int value) {
        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    public void addFirst(int value) {
        var newNode = new Node(value);

        if (isEmpty()) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        var newNode = new Node(value);

        if (isEmpty()) head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void addAt(int value, int indexValue) {
        if (isEmpty()) throwErrorEmpty();

        var atNode = get(indexValue);
        if (atNode == null) throw new IllegalArgumentException("Error Index Value");

        var newNode = new Node(value);
        var nextNode = atNode.next;

        atNode.next = newNode;
        newNode.prev = atNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;
    }

    public int removeFirst() {
        if (isEmpty()) throwErrorEmpty();

        int value = head.value;

        if (isListContainOneItem()) clear();
        else {
            var secondNode = head.next;
            head.next = null;
            head = secondNode;
            head.prev = null;
        }
        size--;

        return value;
    }

    public int removeLast() {
        if (isEmpty()) throwErrorEmpty();

        int value = tail.value;

        if (isListContainOneItem()) clear();
        else {
            var newTail = tail.prev;
            newTail.next = null;
            tail.prev = null;
            tail = newTail;
        }
        size--;

        return value;
    }

    public int remove(int value) {
        if (isEmpty()) throwErrorEmpty();

        var removeNode = get(value);
        if (removeNode == null) throw new IllegalArgumentException("Value not found in list");

        int removeValue = removeNode.value;

        if (head == removeNode) removeFirst();
        else if (tail == removeNode) removeLast();
        else {
            var nextNode = removeNode.next;
            var prevNode = removeNode.prev;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            removeNode.next = null;
            removeNode.prev = null;
            size--;
        }

        return removeValue;
    }


    public void setFirst(int value) {
        if (isEmpty()) throwErrorEmpty();

        head.value = value;
    }

    public void setLast(int value) {
        if (isEmpty()) throwErrorEmpty();

        tail.value = value;
    }

    public void setAt(int value, int indexValue) {
        if (isEmpty()) throwErrorEmpty();

        var setNode = get(indexValue);

        if (setNode == null) throw new IllegalArgumentException("Item not found");

        setNode.value = value;
    }

    private void throwErrorEmpty() {
        throw new IllegalStateException("List is empty");
    }

    private boolean isListContainOneItem() {
        return head == tail && head != null;
    }

    @Override
    public String toString() {
        String out = "[";
        var currentNode = head;
        while (currentNode != null) {
            out = currentNode.next == null ? out + currentNode.value : out + currentNode.value + ", ";
            currentNode = currentNode.next;
        }
        return out + "]";
    }
}
