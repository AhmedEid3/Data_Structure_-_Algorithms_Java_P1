package ds;

public class DoublyLinkedList<T> {
    private class Node {
        private Object value;
        private Node prev;
        private Node next;

        Node(T value) {
            this.value = (T) value;
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

    public boolean contains(T value) {
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

    public T getKthFromTheEnd(int k) {
        if (isEmpty()) throwErrorEmpty();

        var currentNode = tail;
        for (int i = 1; i <= k; i++) {
            if (i == k) return (T) currentNode.value;
            if (currentNode.prev == null)
                throw new IllegalArgumentException("Kth is greater than size of list.");
            currentNode = currentNode.prev;
        }


        throw new IllegalArgumentException("Error Kth is greater than size of list.");
    }

    public T getFirst() {
        if (isEmpty()) throwErrorEmpty();

        return (T) head.value;
    }

    public T getLast() {
        if (isEmpty()) throwErrorEmpty();

        return (T) tail.value;
    }

    public Node get(T value) {
        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    public void addFirst(T value) {
        var newNode = new Node(value);

        if (isEmpty()) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        var newNode = new Node(value);

        if (isEmpty()) head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void addAt(T indexValue, T value) {
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

    public T removeFirst() {
        if (isEmpty()) throwErrorEmpty();

        var value = (T) head.value;

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

    public T removeLast() {
        if (isEmpty()) throwErrorEmpty();

        var value = (T) tail.value;

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

    public T remove(T value) {
        if (isEmpty()) throwErrorEmpty();

        var removeNode = get(value);
        if (removeNode == null) throw new IllegalArgumentException("Value not found in list");

        var removeValue = (T) removeNode.value;

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


    public void setFirst(T value) {
        if (isEmpty()) throwErrorEmpty();

        head.value = value;
    }

    public void setLast(T value) {
        if (isEmpty()) throwErrorEmpty();

        tail.value = value;
    }

    public void setAt(T indexValue, T value) {
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
        StringBuffer out = new StringBuffer("[");
        var currentNode = head;
        while (currentNode != null) {
            out.append(currentNode.value);
            if (currentNode.next != null) out.append(", ");
            currentNode = currentNode.next;
        }

        return out.append("]").toString();
    }
}
