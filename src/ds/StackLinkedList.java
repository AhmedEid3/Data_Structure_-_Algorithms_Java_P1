package ds;

public class StackLinkedList {
    private LinkedList stack;

    public StackLinkedList() {
        this.stack = new LinkedList();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int value) {
        stack.addLast(value);
    }

    public int pop() {
        return stack.removeLast();
    }

    public int peek() {
        return stack.getLast();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return "Stack: " + stack;
    }
}
