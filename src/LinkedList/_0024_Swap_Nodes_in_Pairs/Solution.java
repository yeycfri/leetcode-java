package LinkedList._0024_Swap_Nodes_in_Pairs;

import common.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy;

        // 后面不足两个节点，则不用继续
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            node1.next = node2.next;
            node2.next = node1;
            cur.next = node2;
            cur = node1;
        }
        return dummy.next;
    }
}
