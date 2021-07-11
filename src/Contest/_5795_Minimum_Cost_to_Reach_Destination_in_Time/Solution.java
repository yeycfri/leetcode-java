package Contest._5795_Minimum_Cost_to_Reach_Destination_in_Time;

import java.util.*;

public class Solution {

    private static final int INF = (int) (1e6 + 1);

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] dp = new int[maxTime + 1][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, INF);
        }
        dp[0][0] = passingFees[0];
        for (int t = 1; t <= maxTime; t++) {
            for (int[] e : edges) {
                int i = e[0], j = e[1], time = e[2];
                if (t >= time) {
                    dp[t][i] = Math.min(dp[t][i], dp[t - time][j] + passingFees[i]);
                    dp[t][j] = Math.min(dp[t][j], dp[t - time][i] + passingFees[j]);
                }
            }
        }
        int min = INF;
        for (int t = 1; t <= maxTime; t++) {
            min = Math.min(min, dp[t][n - 1]);
        }
        return min == INF ? -1 : min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = new int[][]{
                new int[]{0, 1, 10},
                new int[]{1, 2, 10},
                new int[]{2, 5, 10},
                new int[]{0, 3, 1},
                new int[]{3, 4, 10},
                new int[]{4, 5, 15}
        };
        System.out.println(solution.minCost(29, edges, new int[]{5, 1, 2, 20, 20, 3}));
    }
}
