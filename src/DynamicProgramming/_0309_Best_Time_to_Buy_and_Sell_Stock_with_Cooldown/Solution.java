package DynamicProgramming._0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[1][0] = Math.max(dp[0][0], Math.max(dp[0][2], dp[0][3]) - prices[i]);
            dp[1][1] = dp[0][0] + prices[i];
            dp[1][2] = dp[0][1];
            dp[1][3] = Math.max(dp[0][2], dp[0][3]);
            System.arraycopy(dp[1], 0, dp[0], 0, 4);
        }
        return Math.max(dp[1][1], Math.max(dp[1][2], dp[1][3]));
    }
}
