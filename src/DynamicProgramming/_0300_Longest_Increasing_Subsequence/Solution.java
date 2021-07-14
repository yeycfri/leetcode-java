package DynamicProgramming._0300_Longest_Increasing_Subsequence;

public class Solution {
    public int lengthOfLISGreedyBinarySearch(int[] nums) {
        int n = nums.length, idx = 1;
        int[] dp = new int[n + 1];
        dp[idx] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[idx]) {
                dp[++idx] = nums[i];
            } else {
                int left = 1, right = idx;
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (dp[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = nums[i];
            }
        }
        return idx;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
