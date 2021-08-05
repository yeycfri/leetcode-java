package TwoPointers._0283_Move_Zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] != 0)
                swap(nums, l++, r);
            r++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
