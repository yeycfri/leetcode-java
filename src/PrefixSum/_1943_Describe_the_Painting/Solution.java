package PrefixSum._1943_Describe_the_Painting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int len = 0;
        for (int[] seg : segments) len = Math.max(len, seg[1]);

        long[] diff = new long[len + 1];
        boolean[] point = new boolean[len + 1];
        for (int[] s : segments) {
            diff[s[0]] += s[2];
            diff[s[1]] -= s[2];
            point[s[0]] = true;
            point[s[1]] = true;
        }
        List<List<Long>> ans = new ArrayList<>();
        long sum = 0, j = 0;
        for (long i = 0; i < diff.length; i++) {
            if (point[(int) i]) {
                if (sum != 0) {
                    ans.add(Arrays.asList(j, i, sum));
                }
                j = i;
            }
            sum += diff[(int) i];
        }
        return ans;
    }
}
