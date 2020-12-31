import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class MyHashTable<K, V> implements HashTableAPI<K, V> {
    private int size;
    private double loadFactor;
    private List<Entry> buckets;
    private Set<K> keySet;
    private int numBuckets;

    private int hashFunc(K key, int numBuckets) {
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    public MyHashTable() {
        size = 0;
        loadFactor = 0.75;
        buckets = new ArrayList<Entry>(16);
        for (int i = 0 ; i < 16 ; i++) {
            buckets.add(i, null);
        }
        keySet = new HashSet<K>();
        numBuckets = 16;

    }
    public MyHashTable(int initialSize) {
        size = 0;
        loadFactor = 0.75;
        buckets = new ArrayList<Entry>(initialSize);
        for (int i = 0 ; i < initialSize ; i++) {
            buckets.add(i, null);
        }
        keySet = new HashSet<K>();
        numBuckets = initialSize;
    }
    public MyHashTable(int initialSize, double loadFactor) {
        size = 0;
        this.loadFactor = loadFactor;
        buckets = new ArrayList<Entry>(initialSize);
        for (int i = 0 ; i < initialSize ; i++) {
            buckets.add(i, null);
        }
        keySet = new HashSet<K>();
        numBuckets = initialSize;
    }

    private class Entry {
        K key;
        V val;
        Entry next;

        Entry(K k, V v, Entry n) {
            key = k;
            val = v;
            next = n;
        }

        Entry get(K k) {
            if (k != null && k.equals(key)) {
                return this;
            }
            if (next == null) {
                return null;
            }
            return next.get(k);
        }
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new ArrayList<Entry>(16);
        for (int i = 0 ; i < 16 ; i++) {
            buckets.add(i, null);
        }
        keySet = new HashSet<K>();
        numBuckets = 16;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        int hc = hashFunc(key, numBuckets);
        if (buckets.get(hc) == null) {
            return null;
        }
        return buckets.get(hc).val;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int newSize) {
        List<Entry> newBuckets = new ArrayList<Entry>(newSize);
        for (int i = 0 ; i < newSize ; i++) {
            newBuckets.add(i, null);
        }
        for (K key : keySet) {
            int hc = hashFunc(key, newSize);
            V value = get(key);
            Entry e = newBuckets.get(hc);
            if (e == null) {
                newBuckets.set(hc, new Entry(key, value, null));
            } else {
                newBuckets.set(hc, new Entry(key, value, e));
            }
        }
        buckets = newBuckets;
        numBuckets = newSize;
    }

    @Override
    public void put(K key, V value) {
        if ((double) size / (double) numBuckets > loadFactor) {
            resize(numBuckets * 2);
        }
        int hc = hashFunc(key, numBuckets);
        Entry e = buckets.get(hc);
        if (e == null) {
            Entry newEntry = new Entry(key, value, null);
            buckets.set(hc, newEntry);
            size++;
            keySet.add(key);
        } else {
            if (e.get(key) == null) {
                buckets.set(hc, new Entry(key, value, e));
                size++;
                keySet.add(key);
            } else {
                buckets.get(hc).get(key).val = value;
            }
        }
    }

    @Override
    public Set keySet() {
        return keySet;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keySet.iterator();
    }
}
