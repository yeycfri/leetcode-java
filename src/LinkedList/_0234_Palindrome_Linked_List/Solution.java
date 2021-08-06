package LinkedList._0234_Palindrome_Linked_List;

import common.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reverse(slow.next);
        while (tail != null) {
            if (tail.val != head.val)
                return false;
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prv = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prv;
            prv = cur;
            cur = temp;
        }
        return prv;
    }
}
