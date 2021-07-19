package Design._0460_LFU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    class Node {
        int key, val, freq;
        Node prev, next;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;

        DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }

        public Node removeFirst() {
            Node x;
            if ((x = head.next) == tail)
                return null;
            remove(x);
            return x;
        }

        public void addLast(Node x) {
            tail.prev.next = x;
            x.next = tail;
            x.prev = tail.prev;
            tail.prev = x;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }

    int size, minFreq, capacity;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, DoublyLinkedList> freqToKeys;

    public LFUCache(int capacity) {
        this.size = 0;
        this.minFreq = 0;
        this.capacity = capacity;
        keyToNode = new HashMap<>(capacity);
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        Node x = keyToNode.get(key);
        if (x != null) {
            increaseFreq(x);
            return x.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (capacity == 0)
            return;

        Node x = keyToNode.get(key);
        if (x != null) {
            x.val = val;
            increaseFreq(x);
            return;
        }
        if (size == capacity) {
            DoublyLinkedList keys = freqToKeys.get(minFreq);
            Node toRemove = keys.removeFirst();
            keyToNode.remove(toRemove.key);
            size--;
        }
        Node toAdd = new Node(key, val);
        keyToNode.put(key, toAdd);
        DoublyLinkedList keys = freqToKeys.getOrDefault(1, new DoublyLinkedList());
        keys.addLast(toAdd);
        freqToKeys.put(1, keys);
        minFreq = 1;
        size++;
    }

    private void increaseFreq(Node x) {
        int freq = x.freq;
        DoublyLinkedList keys = freqToKeys.get(freq);
        keys.remove(x);
        if (keys.isEmpty() && minFreq == freq) {
            minFreq++;
        }
        x.freq++;
        keys = freqToKeys.getOrDefault(x.freq, new DoublyLinkedList());
        keys.addLast(x);
        freqToKeys.put(x.freq, keys);
    }
}
