package ds;

public class Stack {
    private int[] items;
    private int count;

    public Stack() {
        items = new int[1];
    }

    public void push(int item) {
        if (count == items.length) extend();
        items[count++] = item;
    }

    public int peek() {
        return items[count - 1];
    }


    public int pop() {
        if (isEmpty()) throw new IllegalArgumentException("Stack is empty");
        int value = peek();
        count--;
        return value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override()
    public String toString() {
        String out = "[";
        for (int i = 0; i < count; i++) {
            if (i < count - 1) out += items[i] + ", ";
            else out += items[i];
        }
        return out + "]";
    }

    private void extend() {
        int increaseSizeBy100 = (count * 2);
        int[] temp = new int[increaseSizeBy100];

        for (int i = 0; i < count; i++) {
            temp[i] = items[i];
        }

        items = temp;
    }
}
