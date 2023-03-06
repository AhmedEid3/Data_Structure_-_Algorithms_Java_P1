package ds;

import java.util.Stack;

public class QueueWithTwoStack {
    private Stack<Integer> itemsStack1 = new Stack();
    private Stack<Integer> itemsStack2 = new Stack();

    public boolean isEmpty() {
        return itemsStack1.isEmpty() && itemsStack2.isEmpty();
    }

    public void enqueue(int item) {
        itemsStack1.push(item);
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        moveStackOneToStackTwo();

        return itemsStack2.pop();
    }

    public int peek() {
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

}
