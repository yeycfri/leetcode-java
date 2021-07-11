package LinkedList._0002_Add_Two_Numbers;

import common.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head = dummy;
        int up = 0;
        while (l1 != null || l2 != null || up != 0) {
            int i1 = 0, i2 = 0;
            if (l1 != null) {
                i1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                i2 = l2.val;
                l2 = l2.next;
            }
            int val = i1 + i2 + up;
            up = val / 10;
            val %= 10;
            head.next = new ListNode(val);
            head = head.next;
        }
        return dummy.next;
    }
}
