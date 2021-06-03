package _0024_Swap_Nodes_in_Pairs;

import common.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp1 = cur.next;
            ListNode tmp2 = tmp1.next.next;

            cur.next = cur.next.next;
            cur.next.next = tmp1;
            tmp1.next = tmp2;
            cur = tmp1;
        }
        return dummy.next;
    }
}
