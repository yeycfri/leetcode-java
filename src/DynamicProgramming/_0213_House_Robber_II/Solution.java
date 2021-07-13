package DynamicProgramming._0213_House_Robber_II;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int ans1 = robRange(nums, 0, n - 2);
        int ans2 = robRange(nums, 1, n - 1);
        return Math.max(ans1, ans2);
    }

    private int robRange(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] dp = new int[end + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
