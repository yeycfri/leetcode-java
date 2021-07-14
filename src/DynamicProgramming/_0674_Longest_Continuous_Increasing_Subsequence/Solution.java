package DynamicProgramming._0674_Longest_Continuous_Increasing_Subsequence;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int findLengthOfLCISGreedy(int[] nums) {
        int n = nums.length;
        int cnt = 1, max = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
