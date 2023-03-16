package ds;

import java.util.LinkedList;

public class HashTable<K, V> {
    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }

    private int size = 5;

    private LinkedList<Entry>[] entries = new LinkedList[size];

    public void put(K key, V value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public V get(K key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
    }

    public void remove(K key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(K key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(K key) {
        var index = hash(key);
        var bucket = entries[index];

        return bucket == null ? entries[index] = new LinkedList<>() : bucket;
    }

    private Entry getEntry(K key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }


    @Override
    public String toString() {
        StringBuffer output = new StringBuffer("{");

        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) continue;

            var listEntries = entries[i].toArray();
            for (int j = 0; j < listEntries.length; j++) {
                output.append(listEntries[j].toString() + ", ");
            }
        }

        return output.append("}").toString();
    }
}
