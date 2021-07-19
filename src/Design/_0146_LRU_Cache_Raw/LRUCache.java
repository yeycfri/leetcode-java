package Design._0146_LRU_Cache_Raw;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size, capacity;
    private Node head, tail;
    private Map<Integer, Node> map;

    private void removeNode(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private Node removeFirst() {
        Node x;
        if ((x = head.next) == tail)
            return null;
        removeNode(x);
        return x;
    }

    private void addLast(Node x) {
        tail.prev.next = x;
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = x;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node x = map.get(key);
            removeNode(x);
            addLast(x);
            return x.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node x = map.get(key);
            x.val = value;
            removeNode(x);
            addLast(x);
            return;
        }
        if (size == capacity) {
            Node x = removeFirst();
            map.remove(x.key);
            size--;
        }
        Node x = new Node(key, value);
        map.put(key, x);
        addLast(x);
        size++;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}
