package DynamicProgramming._1277_Count_Square_Submatrices_with_All_Ones;

public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue;
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
