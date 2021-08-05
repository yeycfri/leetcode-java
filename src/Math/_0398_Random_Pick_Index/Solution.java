package Math._0398_Random_Pick_Index;

import java.util.Random;

public class Solution {
    private int[] d;
    private Random r;

    public Solution(int[] nums) {
        d = nums;
        r = new Random();
    }

    public int pick(int target) {
        int j = 0, idx = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] == target && r.nextInt(++j) == 0) {
                idx = i;
            }
        }
        return idx;
    }
}
