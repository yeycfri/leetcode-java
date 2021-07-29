package Sorting._0215_Kth_Largest_Element_in_an_Array;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickselect(int[] nums, int l, int r, int k) {
        int i = l, j = r, p = l + ((r - l) >> 1);
        swap(nums, l, p);
        int x = nums[l];
        while (i < j) {
            while (i < j && nums[j] <= x) j--;
            if (i < j) nums[i] = nums[j];
            while (i < j && nums[i] >= x) i++;
            if (i < j) nums[j] = nums[i];
        }
        nums[i] = x;
        if (i == k)
            return nums[k];
        return (k < i) ? quickselect(nums, l, i - 1, k) : quickselect(nums, i + 1, r, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
