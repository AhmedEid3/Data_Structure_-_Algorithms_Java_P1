package ds;

public class DynamicArray<T> {
    private Object[] items;
    private int size = 0;

    public DynamicArray() {
        items = (T[]) new Object[7];
    }

    public DynamicArray(int length) {
        items = (T[]) new Object[length];
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (item == items[i]) return i;
        }
        return -1;
    }

    public void insert(T item) {
        if (size == items.length) resize(increaseSizeBy50());
        items[size++] = item;
    }

    public void insertAt(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        if (size == items.length) resize(increaseSizeBy50());

        for (int i = size - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = item;
        size++;
    }

    public T removeAt(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        Object valueIndex = null;
        for (int i = index; i < size - 1; i++) {
            if (i == index) valueIndex = items[i];
            items[i] = items[i + 1];
        }
        items[size - 1] = null;
        size--;

        if (size < items.length / 4) {
            resize(decreaseSizeBy50());
        }

        return (T) valueIndex;
    }

    public T remove(T item) {
        removeAt(indexOf(item));

        return item;
    }

    public void reverse() {
        Object temp;
        for (int i = 0; i < size / 2; i++) {
            temp = (T) items[i];
            items[i] = items[size - 1 - i]; // last item
            items[size - 1 - i] = temp;
        }
    }

    public int max() {
        if (size == 0) return 0;

        int max = (int) items[0];

        for (int i = 0; i < size; i++)
            if ((int) items[i] > max) max = (int) items[i];

        return max;
    }

    public int min() {
        if (size == 0) return 0;

        int min = (int) items[0];

        for (int i = 0; i < size; i++)
            if ((int) items[i] < min) min = (int) items[i];

        return min;
    }

    public int size() {
        return size;
    }

    public DynamicArray intersect(DynamicArray other) {
        var intersection = new DynamicArray(size);

        for (var item : items) {
            if (other.indexOf(item) >= 0)
                intersection.insert(item);
        }

        return intersection;
    }

    @Override()
    public String toString() {
        StringBuffer out = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            out.append(items[i]);
            if (i < size - 1) out.append(", ");
        }

        return out.append("]").toString();
    }

    private void resize(int length) {
        T[] temp = (T[]) new Object[length];

        for (int i = 0; i < size; i++) {
            temp[i] = (T) items[i];
        }

        items = temp;
    }

    private int increaseSizeBy50() {
        return (int) Math.ceil(items.length * 1.5);
    }

    private int decreaseSizeBy50() {
        return (int) Math.ceil(items.length * .5);
    }
}
