package ds;

import java.util.Arrays;

public class ArrayQueue {

    private int[] items;
    private int count = 0;
    private int front = 0;
    private int rear = 0;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException("Queue is full");

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;

        return item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return items[front];
    }

    @Override()
    public String toString() {
        return Arrays.toString(items);
    }

}
