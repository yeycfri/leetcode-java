package TwoPointers._0075_Sort_Colors;

public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, l = 0, r = n - 1, i = 0;
        while (i <= r) {
            while (i < r && nums[i] == 2) {
                swap(nums, i, r--);
            }
            if (nums[i] == 0) {
                swap(nums, i, l++);
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
