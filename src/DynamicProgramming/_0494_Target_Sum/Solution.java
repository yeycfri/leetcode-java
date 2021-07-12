package DynamicProgramming._0494_Target_Sum;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // x - (sum - x) = target
        // x = (sum + target) / 2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1) return 0;
        int x = (sum + target) / 2;
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = x; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[x];
    }
}
