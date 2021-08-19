package DynamicProgramming._0312_Burst_Balloons;

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        System.arraycopy(nums, 0, val, 1, n);
        val[0] = val[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
