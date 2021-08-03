package Sorting._0581_Shortest_Unsorted_Continuous_Subarray;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        System.arraycopy(nums, 0, sorted, 0, n);
        Arrays.sort(sorted);
        int l = 0, r = n - 1;
        while (l < n && nums[l] == sorted[l]) l++;
        while (r >= 0 && nums[r] == sorted[r]) r--;
        return r < 0 ? 0 : r - l + 1;
    }

    public int findUnsortedSubarrayGreedy(int[] nums) {
        int n = nums.length, l = -1, r = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min < nums[n - i - 1])
                l = n - i - 1;
            else
                min = nums[n - i - 1];
            if (max > nums[i])
                r = i;
            else
                max = nums[i];
        }
        return r == -1 ? 0 : r - l + 1;
    }
}
