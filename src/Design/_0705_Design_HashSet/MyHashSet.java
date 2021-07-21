package Design._0705_Design_HashSet;

import java.util.HashMap;

public class MyHashSet {

    private int n;
    private Node[] nodes;

    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }

        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        n = 1 << 15;
        nodes = new Node[n];
    }

    public void add(int key) {
        int loc = (n - 1) & hash(key);
        Node x = nodes[loc];
        if (x == null) {
            nodes[loc] = new Node(key);
        } else {
            Node search = x;
            while (search != null) {
                if (x.key == key) return;
                search = search.next;
            }
            Node toAdd = new Node(key, x);
            nodes[loc] = toAdd;
        }
    }

    public void remove(int key) {
        int loc = (n - 1) & hash(key);
        Node x = nodes[loc];
        if (x != null) {
            Node cur = x;
            if (cur.key == key) {
                nodes[loc] = cur.next;
            } else {
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
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int loc = (n - 1) & hash(key);
        Node x = nodes[loc];
        while (x != null) {
            if (x.key == key) {
                return true;
            }
            x = x.next;
        }
        return false;
    }

    private int hash(int key) {
        return key ^ (key >>> 16);
    }
}
