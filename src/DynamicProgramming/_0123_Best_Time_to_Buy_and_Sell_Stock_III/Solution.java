package DynamicProgramming._0123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[1] = Math.max(dp[1], -prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return dp[4];
    }
}
