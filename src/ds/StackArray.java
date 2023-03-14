package ds;

public class StackArray {
    private int[] stack;
    private int top = -1;
    private int capacity;

    public StackArray(int capacity) {
        stack = new int[capacity];
        this.capacity = capacity;
    }

    public void push(int item) {
        if (isFull()) throw new IllegalArgumentException("Stack overflow");

        stack[++top] = item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        return stack[top];
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override()
    public String toString() {
        StringBuffer out = new StringBuffer("[");

        for (int i = 0; i <= top; i++) {
            out.append(stack[i]);
            if (i < top) out.append(", ");
        }
        out.append("]");

        return out.toString();
    }
}
