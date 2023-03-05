package ds;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
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

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int getFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        return head.value;
    }

    public int getLast() {
        if (isEmpty()) throw new NoSuchElementException();

        return tail.value;
    }

    public int indexOf(int item) {
        var currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value == item) return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        int index = indexOf(item);
        if (index != -1) return true;
        return false;
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        else if (head == tail) {
            clear();
            return;
        } else {
            var secondNode = head.next;
            head.next = null;
            head = secondNode;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        else if (head == tail) {
            clear();
            return;
        } else {
            var previousNode = getPreviousNode(tail);
            tail = previousNode;
            tail.next = null;
        }
        size--;
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

    public int getKthFromTheEnd(int k) {
        if (k <= 0 || isEmpty()) throw new NoSuchElementException();
        if (k == 1) return tail.value;

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

        return firstNode.value;


    }
    
    public int[] toArray() {
        int[] array = new int[size];

        var currentNode = head;
        int index = 0;
        while (currentNode != null) {
            array[index] = currentNode.value;
            currentNode = currentNode.next;
            index++;
        }

        return array;
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


    private Node getPreviousNode(Node node) {
        var currentNode = head;
        while (currentNode != null) {
            if (node == currentNode.next) return currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }
}
