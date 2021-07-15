package DynamicProgramming._0053_Maximum_Subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArrayGreedy(int[] nums) {
        int cur = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = Math.max(cur, max);
            if (cur < 0) cur = 0;
        }
        return max;
    }
}
