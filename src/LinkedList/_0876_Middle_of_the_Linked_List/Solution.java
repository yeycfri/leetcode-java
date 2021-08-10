package LinkedList._0876_Middle_of_the_Linked_List;

import common.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
