package Sorting._0148_Sort_List;

import common.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;

        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0, head);
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            ListNode prv = dummy, cur = dummy.next;

            while (cur != null) {
                // 获得 subLen 长度链表 l1
                ListNode l1 = cur;
                for (int i = 1; i < subLen && cur != null; i++)
                    cur = cur.next;

                // 不存在 l2，l1 已经有序，直接接上前置节点，结束循环
                if (cur == null) {
                    prv.next = l1;
                    break;
                }

                // 获得 subLen 长度链表 l2
                ListNode l2 = cur.next;
                cur.next = null;            // 断开 l1 与 l2
                cur = l2;
                for (int i = 1; i < subLen && cur != null; i++)
                    cur = cur.next;

                // 保存 l1、l2 后的下一段链表头部 nxt
                ListNode nxt = null;
                if (cur != null) {
                    nxt = cur.next;
                    cur.next = null;        // 断开 l2 与 nxt
                }

                // 归并排序后接上前置节点
                prv.next = merge(l1, l2);
                while (prv.next != null)
                    prv = prv.next;         // 前置节点移到已排序的最后一个节点

                cur = nxt;
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
}
