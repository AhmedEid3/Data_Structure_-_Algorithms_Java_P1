package ds;

public class QueueLinkedList<T> {
    private LinkedList<T> queue;

    public QueueLinkedList() {
        queue = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void enqueue(T value) {
        queue.addLast(value);
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return queue.removeFirst();
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return queue.getFirst();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
