package _0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            if (prices[i] > min + fee) {
                profit += prices[i] - min - fee;
                min = prices[i] - fee;
            }
        }
        return profit;
    }
}
