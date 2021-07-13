package DynamicProgramming._0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public int maxProfitGreedy(int[] prices) {
        int n = prices.length, low = Integer.MAX_VALUE, profit = 0;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i] - low);
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
