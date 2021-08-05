package Math._0519_Random_Flip_Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    Map<Integer, Integer> V;
    Random rand;
    int remain, m, n;

    public Solution(int m, int n) {
        V = new HashMap<>();
        rand = new Random();
        remain = m * n;
        this.m = m;
        this.n = n;
    }

    public int[] flip() {
        int r = rand.nextInt(remain--);
        int x = V.getOrDefault(r, r);
        V.put(r, V.getOrDefault(remain, remain));
        return new int[]{x / n, x % n};
    }

    public void reset() {
        V.clear();
        remain = m * n;
    }
}
