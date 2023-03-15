package ds;

public class QueueLinkedList {
    private LinkedList<Integer> queue;

    public QueueLinkedList() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void enqueue(int value) {
        queue.addLast(value);
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return queue.removeFirst();
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return queue.getFirst();
    }

    @Override
    public String toString() {
        return "Queue: " + queue;
    }

}
