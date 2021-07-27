package Sorting._0147_Insertion_Sort_List;

import common.ListNode;

public class Solution {

    private static final int MIN = -5001;

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(MIN, head);
        ListNode last = head, cur = last.next;
        while (cur != null) {
            if (last.val <= cur.val) {
                last = last.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val < cur.val) {
                    prev = prev.next;
                }
                last.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = last.next;
        }
        return dummy.next;
    }
}
