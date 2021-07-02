package _1833_Maximum_Ice_Cream_Bars;

import java.util.Arrays;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins < 0) break;
            ans++;
        }
        return ans;
    }
}
