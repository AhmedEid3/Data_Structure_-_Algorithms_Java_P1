package ds;


public class PriorityQueue {
    private int[] items;
    private int count = 0;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException("Queue is full");

        int index = shiftItemsToInsert(item);
        items[index] = item;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return items[--count];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        return items[count - 1];
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (item < items[i]) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }

        return i + 1;
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

}
