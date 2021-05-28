package _0300_Longest_Increasing_Subsequence;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];
        int len = 1;
        dp[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int left = 1, right = len;
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
        return len;
    }
}
