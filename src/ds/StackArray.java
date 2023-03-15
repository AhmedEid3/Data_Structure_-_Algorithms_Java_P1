package ds;

public class StackArray<T> {
    private Object[] stack;
    private int top = -1;
    private int capacity;

    public StackArray(int capacity) {
        stack = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void push(T item) {
        if (isFull()) throw new IllegalArgumentException("Stack overflow");

        stack[++top] = item;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        return (T) stack[top];
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        return (T) stack[top--];
    }

    public int size() {
        return top + 1;
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

        return out.append("]").toString();
    }
}
