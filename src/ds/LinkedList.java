package ds;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private class Node {
        private Object value;
        private Node next;

        public Node(T value) {
            this.value = (T) value;
            this.next = null;
        }
    }

    private Node head, tail;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addLast(T item) {
        var node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addFirst(T item) {
        var node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        return (T) head.value;
    }

    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();

        return (T) tail.value;
    }

    public int indexOf(T item) {
        var currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value == item) return index;
            currentNode = currentNode.next;
            index++;
        }

        return -1;
    }

    public boolean contains(T item) {
        if (indexOf(item) != -1) return true;

        return false;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        var value = head.value;

        if (head == tail) {
            clear();
            return (T) value;
        } else {
            var secondNode = head.next;
            head.next = null;
            head = secondNode;
        }
        size--;

        return (T) value;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        var value = tail.value;

        if (head == tail) {
            clear();
            return (T) value;
        } else {
            var previousNode = getPreviousNode(tail);
            tail = previousNode;
            tail.next = null;
        }
        size--;

        return (T) value;
    }

    public T remove(T value) {
        if (isEmpty()) throw new IllegalStateException("List is empty");

        var removeNode = get(value);
        if (removeNode == null) throw new IllegalStateException("item not found");

        if (head == tail) clear();
        else if (removeNode == head) removeFirst();
        else if (removeNode == tail) removeLast();
        else {
            var prevNode = getPreviousNode(removeNode);
            var nextNode = removeNode.next;

            prevNode.next = nextNode;
            removeNode.next = null;
            size--;
        }

        return (T) removeNode.value;
    }

    public void reverse() {
        var prevNode = head;
        var currentNode = head.next;

        while (currentNode != null) {
            var next = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = next;
        }

        tail = head;
        tail.next = null;
        head = prevNode;
    }

    public T getKthFromTheEnd(int k) {
        if (k <= 0 || isEmpty()) throw new NoSuchElementException();
        if (k == 1) return (T) tail.value;

        var firstNode = head;
        var lastNode = head;
        int distanceBetweenNodes = k - 1;

        for (int i = 0; i < distanceBetweenNodes; i++) {
            lastNode = lastNode.next;
            if (lastNode == null)
                throw new IllegalArgumentException();
        }

        while (lastNode != tail) {
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }

        return (T) firstNode.value;
    }

    public T[] toArray() {
        Object[] array = new Object[size];

        var currentNode = head;
        int index = 0;
        while (currentNode != null) {
            array[index] = currentNode.value;
            currentNode = currentNode.next;
            index++;
        }

        return (T[]) array;
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


    private Node getPreviousNode(Node node) {
        var currentNode = head;
        while (currentNode != null) {
            if (node == currentNode.next) return currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    private Node get(T value) {
        if (isEmpty()) throw new IllegalStateException("List is empty");

        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    private void clear() {
        head = tail = null;
        size = 0;
    }

}
