package Design._0146_LRU_Cache_LinkedHashMap;

import java.util.*;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
