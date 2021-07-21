package Design._0706_Design_HashMap;

public class MyHashMap {

    class Node {
        int key, val;
        Node next;

        Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int n;
    private Node[] data;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        n = 1 << 16;
        data = new Node[n];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int loc = (n - 1) & hash(key);
        Node x = data[loc];
        if (x == null) {
            data[loc] = new Node(key, value, null);
        } else {
            Node cur = x;
            if (cur.key == key) {
                cur.val = value;
                return;
            }
            Node prev = cur;
            cur = cur.next;
            while (cur != null) {
                if (cur.key == key) {
                    cur.val = value;
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
            data[loc] = new Node(key, value, x);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int loc = (n - 1) & hash(key);
        Node x = data[loc];
        while (x != null) {
            if (x.key == key)
                return x.val;
            x = x.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int loc = (n - 1) & hash(key);
        Node x = data[loc];
        if (x != null) {
            Node cur = x;
            if (cur.key == key) {
                data[loc] = cur.next;
                return;
            }
            Node prev = cur;
            cur = cur.next;
            while (cur != null) {
                if (cur.key == key) {
                    prev.next = cur.next;
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }

    private int hash(int key) {
        return key ^ (key >>> 16);
    }
}
