package LinkedList._0287_Find_the_Duplicate_Number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                int i1 = 0, i2 = slow;
                while (i1 != i2) {
                    i1 = nums[i1];
                    i2 = nums[i2];
                }
                return i1;
            }
        }
    }
}
