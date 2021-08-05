package TwoPointers._0027_Remove_Element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] != val)
                nums[l++] = nums[r];
            r++;
        }
        return l;
    }
}
