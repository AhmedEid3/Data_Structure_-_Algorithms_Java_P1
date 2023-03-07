package ds;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        public int key;
        public String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Entry)) return false;
            var other = (Entry) obj;
            return this.key == other.key;
        }

        @Override
        public String toString() {
            return key + "='" + value + '\'';
        }
    }

    private int size = 5;
    private LinkedList<Entry>[] entries = new LinkedList[size];

    public void put(int k, String v) {
        var bucket = getOrCreateBucket(k);

        var entryIndex = findEntryIndex(k);
        if (entryIndex > -1) {
            bucket.remove(entryIndex);
        }

        bucket.addLast(new Entry(k, v));
    }

    public String get(int k) {
        var bucket = getBucket(k);
        var entryIndex = findEntryIndex(k);

        return entryIndex > -1 ? bucket.get(entryIndex).value : null;
    }

    public void remove(int k) {
        var bucket = getBucket(k);
        var entryIndex = findEntryIndex(k);

        if (entryIndex == -1) throw new IllegalStateException("key doesn't exist");

        bucket.remove(entryIndex);
    }

    private int hash(int key) {
        return Math.abs(key) % size;
    }

    private LinkedList<Entry> getBucket(int k) {
        return entries[hash(k)];
    }

    private LinkedList<Entry> getOrCreateBucket(int k) {
        var index = hash(k);
        var bucket = entries[index];

        return bucket == null ? entries[index] = new LinkedList<>() : bucket;
    }

    private int findEntryIndex(int k) {
        var bucket = getBucket(k);

        if (bucket != null) {
            var indexExistEntry = bucket.indexOf(new Entry(k, ""));
            if (indexExistEntry > -1) {
                return indexExistEntry;
            }
        }

        return -1;
    }


    @Override
    public String toString() {
        String out = "{";

        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) continue;

            var listEntries = entries[i].toArray();
            for (int j = 0; j < listEntries.length; j++) {
                out += listEntries[j].toString() + ", ";
            }
        }

        return out + "}";
    }
}
