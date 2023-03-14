package ds;

import java.util.Arrays;

public class QueueArray {
    private int[] queue;
    private int count = 0;
    private int front = 0;
    private int rear = 0;

    public QueueArray(int capacity) {
        queue = new int[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalArgumentException("Queue is full");

        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;

        return item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return queue[front];
    }

    @Override()
    public String toString() {
        return Arrays.toString(queue);
    }

}
