package LinkedList._0023_Merge_k_Sorted_Lists;

import common.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeTwo(lists, 0, lists.length - 1);
    }

    public ListNode mergeTwo(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;
        int mid = l + ((r - l) >> 1);
        return merge(mergeTwo(lists, l, mid), mergeTwo(lists, mid + 1, r));
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = (p1 == null) ? p2 : p1;
        return dummy.next;
    }
}
