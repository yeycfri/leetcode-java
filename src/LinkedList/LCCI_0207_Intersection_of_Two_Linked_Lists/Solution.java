package LinkedList.LCCI_0207_Intersection_of_Two_Linked_Lists;

import common.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0, m = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            n++;
            curA = curA.next;
        }
        while (curB != null) {
            m++;
            curB = curB.next;
        }

        if (n > m) {
            curA = headB;
            curB = headA;
        } else {
            curA = headA;
            curB = headB;
        }
        int count = Math.abs(n - m);
        while (count-- > 0) {
            curB = curB.next;
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
