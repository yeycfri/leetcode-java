package DynamicProgramming._0070_Climbing_Stairs;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int dp1 = 1, dp2 = 2;
        for (int i = 2; i < n; i++) {
            int tmp = dp1 + dp2;
            dp1 = dp2;
            dp2 = tmp;
        }
        return dp2;
    }
}
