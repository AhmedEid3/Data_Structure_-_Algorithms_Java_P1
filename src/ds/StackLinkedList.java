package ds;

public class StackLinkedList<T> {
    private LinkedList<T> stack;

    public StackLinkedList() {
        this.stack = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T value) {
        stack.addLast(value);
    }

    public T pop() {
        return stack.removeLast();
    }

    public T peek() {
        return stack.getLast();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
