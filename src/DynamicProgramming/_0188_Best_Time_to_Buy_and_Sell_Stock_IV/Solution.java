package DynamicProgramming._0188_Best_Time_to_Buy_and_Sell_Stock_IV;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int[] dp = new int[k * 2 + 1];
        for (int i = 0; i < k; i++) {
            dp[2 * i + 1] = -prices[0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1, d = -1; j < dp.length; j++, d = -d) {
                dp[j] = Math.max(dp[j], dp[j - 1] + prices[i] * d);
            }
        }
        return dp[k * 2];
    }
}
