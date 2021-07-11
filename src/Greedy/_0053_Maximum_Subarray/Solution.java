package Greedy._0053_Maximum_Subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(sum, result);
            if (sum < 0) sum = 0;
        }
        return result;
    }
}
