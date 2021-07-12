package DynamicProgramming._0474_Ones_and_Zeroes;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroes = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
