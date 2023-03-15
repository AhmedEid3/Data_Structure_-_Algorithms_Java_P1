package ds;

import java.util.Arrays;

public class QueueArray<T> {
    private Object[] queue;
    private int count = 0;
    private int front = 0;
    private int rear = 0;

    public QueueArray(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == queue.length;
    }

    public void enqueue(T item) {
        if (isFull()) throw new IllegalArgumentException("Queue is full");

        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        var item = queue[front];
        queue[front] = (T) null;
        front = (front + 1) % queue.length;
        count--;

        return (T) item;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return (T) queue[front];
    }

    @Override()
    public String toString() {
        return Arrays.toString(queue);
    }
}
