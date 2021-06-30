package _0746_Min_Cost_Climbing_Stairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int c1 = cost[0], c2 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int c = Math.min(c1, c2) + cost[i];
            c1 = c2;
            c2 = c;
        }
        return Math.min(c1, c2);
    }
}
