package LinkedList._0143_Reorder_List;

import common.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode mid = mid(head), tail = reverse(mid.next);
        mid.next = null;
        ListNode cur = head;
        while (cur != null && tail != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = tail.next;

            cur.next = tail;
            tail.next = temp1;
            cur = temp1;
            tail = temp2;
        }
    }

    private ListNode mid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
