package LinkedList._0025_Reverse_Nodes_in_k_Group;

import common.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (true) {
            ListNode prev = cur, rTail = cur.next;
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null) return dummy.next;
            }

            ListNode nxt = cur.next;
            prev.next = reverse(rTail, nxt);
            rTail.next = nxt;
            cur = rTail;
        }
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null, cur = head;
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
