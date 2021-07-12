package DynamicProgramming._0062_Unique_Paths;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[j] += j > 0 ? dp[j - 1] : 0;
            }
        }
        return dp[m - 1];
    }
}
