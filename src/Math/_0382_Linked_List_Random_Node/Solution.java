package Math._0382_Linked_List_Random_Node;

import common.ListNode;

import java.util.Random;

public class Solution {

    private ListNode head;
    private Random r;

    // the head is guaranteed to be not null
    public Solution(ListNode head) {
        this.r = new Random();
        this.head = head;
    }

    public int getRandom() {
        int val = 0, i = 0;
        ListNode n = head;
        while (n != null) {
            if (r.nextInt(++i) == 0)
                val = head.val;
            n = n.next;
        }
        return val;
    }
}
