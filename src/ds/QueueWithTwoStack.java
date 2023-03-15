package ds;

import java.util.Stack;

public class QueueWithTwoStack<T> {
    private Stack<T> itemsStack1 = new Stack<T>();
    private Stack<T> itemsStack2 = new Stack<T>();

    public boolean isEmpty() {
        return itemsStack1.isEmpty() && itemsStack2.isEmpty();
    }

    public void enqueue(T item) {
        itemsStack1.push(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        moveStackOneToStackTwo();

        return itemsStack2.pop();
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        moveStackOneToStackTwo();

        return itemsStack2.peek();
    }

    private void moveStackOneToStackTwo() {
        if (itemsStack2.isEmpty()) {
            while (!itemsStack1.isEmpty()) {
                itemsStack2.push(itemsStack1.pop());
            }
        }
    }

    @Override
    public String toString() {
        moveStackOneToStackTwo();
        return itemsStack2.toString();
    }

}
