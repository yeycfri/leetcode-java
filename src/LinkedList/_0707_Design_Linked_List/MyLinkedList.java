package LinkedList._0707_Design_Linked_List;

class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    ListNode dummyHead;
    ListNode dummyTail;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.dummyHead = new ListNode(0);
        this.dummyTail = new ListNode(0);
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
        this.size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        ListNode cur;
        if (index < (this.size - index)) {
            cur = this.dummyHead;
            while (index-- >= 0) {
                cur = cur.next;
            }
        } else {
            cur = this.dummyTail;
            while (index++ < this.size) {
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    public void insert(int val, ListNode left, ListNode right) {
        ListNode inserted = new ListNode(val, right, left);
        left.next = inserted;
        right.prev = inserted;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        insert(val, dummyHead, dummyHead.next);
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        insert(val, dummyTail.prev, dummyTail);
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) return;
        ListNode cur;
        if (index < (this.size - index)) {
            cur = this.dummyHead;
            while (index-- >= 0) {
                cur = cur.next;
            }
        } else {
            cur = this.dummyTail;
            while (index++ < this.size) {
                cur = cur.prev;
            }
        }
        insert(val, cur.prev, cur);
        this.size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) return;
        ListNode cur;
        if (index < (this.size - index)) {
            cur = this.dummyHead;
            while (index-- >= 0) {
                cur = cur.next;
            }
        } else {
            cur = this.dummyTail;
            while (index++ < size) {
                cur = cur.prev;
            }
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        this.size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);              // 1
        myLinkedList.addAtTail(4);              // 1->4
        myLinkedList.addAtTail(6);              // 1->4->6
        myLinkedList.addAtIndex(1, 2);    // 1->2->4->6
        myLinkedList.addAtIndex(2, 3);    // 1->2->3->4->6
        myLinkedList.addAtIndex(4, 5);    // 1->2->3->4->5->6
        System.out.println(myLinkedList.get(2));    // return 3
        myLinkedList.deleteAtIndex(2);              // 1->2->4->5->6
        System.out.println(myLinkedList.get(2));    // return 4
    }
}
