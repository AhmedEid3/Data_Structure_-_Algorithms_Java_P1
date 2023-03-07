package ds;

import java.util.LinkedList;

public class HashTableV2 {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "='" + value + '\'';
        }

    }

    private int size = 5;

    private LinkedList<Entry>[] entries = new LinkedList[size];

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = entries[index];

        return bucket == null ? entries[index] = new LinkedList<>() : bucket;
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private int hash(int key) {
        return Math.abs(key) % size;
    }


    @Override
    public String toString() {
        String output = "{";

        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) continue;

            var listEntries = entries[i].toArray();
            for (int j = 0; j < listEntries.length; j++) {
                output += listEntries[j].toString() + ", ";
            }
        }

        return output + "}";
    }
}
