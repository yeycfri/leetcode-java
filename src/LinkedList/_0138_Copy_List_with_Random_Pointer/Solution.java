package LinkedList._0138_Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            Node x = map.get(node);
            x.next = map.get(node.next);
            x.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        for (Node node = head; node != null; node = node.next.next) {
            Node nn = new Node(node.val);
            nn.next = node.next;
            node.next = nn;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nn = node.next;
            nn.random = (node.random == null) ? null : node.random.next;
        }
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nn = node.next;
            node.next = nn.next;
            nn.next = (node.next == null) ? null : node.next.next;
        }
        return newHead;
    }
}
