package ds;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (item == items[i]) return i;
        }
        return -1;
    }

    public void insert(int item) {
        if (count == items.length) extend();
        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        if (count == items.length) extend();

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    public int removeAt(int index) {
        if (index >= count || index < 0) throw new IllegalArgumentException(index + " out of scope memory array");

        int valueIndex = 0;
        for (int i = index; i < count - 1; i++) {
            if (i == index) valueIndex = items[i];
            items[i] = items[i + 1];
        }
        count--;

        return valueIndex;
    }

    public int remove(int item) {

        int index = this.indexOf(item);

        this.removeAt(index);

        return item;
    }

    public void reverse() {
        int temp;
        for (int i = 0; i < count / 2; i++) {
            temp = items[i];
            items[i] = items[count - 1 - i]; // last item
            items[count - 1 - i] = temp;
        }
    }

    public int max() {
        if (count == 0) return 0;

        int max = items[0];

        for (int i = 0; i < count; i++)
            if (items[i] > max) max = items[i];

        return max;
    }

    public int min() {
        if (count == 0) return 0;

        int min = items[0];

        for (int i = 0; i < count; i++)
            if (items[i] < min) min = items[i];

        return min;
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items) {
            if (other.indexOf(item) >= 0)
                intersection.insert(item);
        }

        return intersection;
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
